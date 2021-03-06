package com.example.logginsession.activity;

import com.example.logginsession.R;
import com.example.logginsession.R.id;
import com.example.logginsession.R.layout;
import com.example.logginsession.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	Button login;
	Button register;
	Button map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnButton();
		
		/*PSQL_Connection.sendRequest("jdbc:postgresql://db.doc.ic.ac.uk/films?&ssl=true",
				"lab","lab",new FilmRequestQuery("SELECT * FROM films"));*/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addListenerOnButton() {
		 
		login = (Button) findViewById(R.id.login_main);
		login.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			  Intent login = 
                            new Intent(MainActivity.this, LoginActivity.class);
			  MainActivity.this.startActivity(login);
 
			}
 
		});
		
		register = (Button) findViewById(R.id.register_main);
		register.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
 
			  Intent register = 
                            new Intent(MainActivity.this, RegisterActivity.class);
			  MainActivity.this.startActivity(register);
 
			}
 
		});
		
		map = (Button) findViewById(R.id.mapShortcut);
		map.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
 
			  Intent register = 
                            new Intent(MainActivity.this, MapActivity.class);
			  MainActivity.this.startActivity(register);
 
			}
 
		});
 
	}
}
