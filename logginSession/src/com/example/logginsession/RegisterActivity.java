package com.example.logginsession;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegisterActivity extends Activity {
	
	Button login;
	AlertDialog unimplementedPopup;/**/
	private AlertDialog userAlphanumPopup;
	private AlertDialog passAlphanumPopup;
	private AlertDialog passLengthPopup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		addListenerOnButton();
		initialisePopups();
	}
	
	public void addListenerOnButton() {
			
		login = (Button) findViewById(R.id.register_button);		
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				unimplementedPopup.show();
			}

		});
		String username = findViewById(R.id.usernameText).toString();
		String password = findViewById(R.id.editText3).toString();
		String confirm = findViewById(R.id.editText3).toString();
		
		if (password.equals(confirm)){
			
		}
	}
	
	private void initialisePopups() {
		unimplementedPopup = new AlertDialog.Builder(this)
		.setTitle("Not Implemented")
		.setMessage("Login has not been implemented")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;
		userAlphanumPopup = new AlertDialog.Builder(this)
		.setTitle("Not Implemented")
		.setMessage("Login has not been implemented")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;		
		passAlphanumPopup = new AlertDialog.Builder(this)
		.setTitle("Not Implemented")
		.setMessage("Login has not been implemented")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;		
		passLengthPopup = new AlertDialog.Builder(this)
		.setTitle("Not Implemented")
		.setMessage("Login has not been implemented")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;
	}
}
