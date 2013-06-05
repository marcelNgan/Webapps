package com.example.maptrial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {
	
	Button login;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		//addListenerOnButton();
	}
	
	public void addListenerOnButton() {
		 
		login = (Button) findViewById(R.id.login_main);
 
		login.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			  Intent login = 
                            new Intent(LoginActivity.this, MapActivity.class);
			  LoginActivity.this.startActivity(login);
 
			}
 
		});
	}
}
