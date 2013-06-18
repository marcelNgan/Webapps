package com.example.logginsession;
// Plain_Postgres.java - example connection to Postgres

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.logginsession.query.MyQuery;

import android.os.AsyncTask;
import android.os.Looper;

public class PSQL_Connection extends AsyncTask<MyRequest, Void, Boolean> {
	
	public void execute(MyRequest request) {
		execute(new MyRequest[]{request});
	}
	
	@Override
	protected Boolean doInBackground(MyRequest[] requests) {
		for (MyRequest request : requests) 
			executeRequest(request);
		
		return true;
    }

	private void executeRequest(MyRequest request) {
        String url = request.getUrl();  
        String user = request.getUser();
        String pass = request.getPass();
        MyQuery query = request.getQuery();
		
		System.out.println( "Films Example in Plain Java, Postgres version\n" );

        try {
 	    Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println( "Driver not found: " + e + "\n" + e.getMessage() );
        }

        try {
        	
        	String uri = "jdbc:postgresql://" + url + "?&ssl=true" + "&sslfactory=org.postgresql.ssl.NonValidatingFactory" ;
        	
        	Connection conn = DriverManager.getConnection (	uri, user, pass );

            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(query.getQuery());
            while ( rs.next() ) {
                query.parseResult(rs);
            }
            
            query.finish();
            query.notifyActivity();
            conn.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e + "\n" + e.getMessage() );
        }
		
	}

	public static void sendRequest(String url, String user,	String pass, MyQuery query) {

		new PSQL_Connection().execute(
				new MyRequest( url,	user,pass,query));
	}
		

}
