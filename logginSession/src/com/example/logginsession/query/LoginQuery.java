package com.example.logginsession.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.logginsession.activity.MyActivity;

public class LoginQuery extends MyQuery {

	public LoginQuery(MyActivity activity, String query) {
		super(activity, query);
	}

	private int results = 0;
	private int uid;
	
	public int numResults() {
		return results;
	}

	@Override
	public void finish() {
	}

	@Override
	public void parseResult(ResultSet rs) throws SQLException {
		String uid = rs.getString("user_id");        
        this.uid=Integer.parseInt(uid);
        results++;
        
        System.out.println(uid);

	}

	public int getLogin() {
		return uid;
	}

}
