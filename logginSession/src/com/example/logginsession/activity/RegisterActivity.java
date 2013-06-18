package com.example.logginsession.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.logginsession.R;
import com.example.logginsession.Util;

public class RegisterActivity extends Activity {
	
	Button login;
	AlertDialog unimplementedPopup;/**/
	private AlertDialog userAlphanumPopup;
	private AlertDialog passAlphanumPopup;
	private AlertDialog passLengthPopup;
	private AlertDialog passMatchPopup;
	
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
				RegisterActivity.this.register();
			}

		});
		
	}
	
	public void register() {
		String username = findViewById(R.id.usernameText).toString();
		String password = findViewById(R.id.editText3).toString();
		String confirm = findViewById(R.id.editText3).toString();
		
		if (Util.isAlphaNumeric(username)){
			userAlphanumPopup.show();
			return;
		}
		
		if (Util.isAlphaNumeric(password)){
			passAlphanumPopup.show();
			return;
		}
		
		if (password.length()<6){
			passLengthPopup.show();
			return;
		}
		
		if (!password.equals(confirm)){
			passMatchPopup.show();
			return;
		}
		
		// all ok!
		
		
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
		.setTitle("Invalid Username")
		.setMessage("Usernames may be made up of letters and digits only")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;		
		passAlphanumPopup = new AlertDialog.Builder(this)
		.setTitle("Invalid Password")
		.setMessage("Passwords may be made up of letters and digits only")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;		
		passLengthPopup = new AlertDialog.Builder(this)
		.setTitle("Invalid Password")
		.setMessage("The password must be at least 6 characters long")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;
		passMatchPopup = new AlertDialog.Builder(this)
		.setTitle("Invalid Password")
		.setMessage("The supplied passwords do no match")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;
	}
}
