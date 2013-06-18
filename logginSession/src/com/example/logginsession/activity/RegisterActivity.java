package com.example.logginsession.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.logginsession.PSQL_Connection;
import com.example.logginsession.R;
import com.example.logginsession.Util;
import com.example.logginsession.query.MyQuery;

public class RegisterActivity extends MyActivity {
	
	Button register;
	AlertDialog unimplementedPopup;/**/
	private AlertDialog userAlphanumPopup;
	private AlertDialog passAlphanumPopup;
	private AlertDialog passLengthPopup;
	private AlertDialog passMatchPopup;
	private AlertDialog usernameInUsePopup;
	private AlertDialog registerSuccess;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		addListenerOnButton();
		initialisePopups();
	}
	
	public void addListenerOnButton() {
			
		register = (Button) findViewById(R.id.register_button);		
		register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				RegisterActivity.this.register();
			}

		});
		
	}
	
	public void register() {
		String username = ((EditText)findViewById(R.id.usernameText)).getText().toString();
		String password = ((EditText)findViewById(R.id.passwordText)).getText().toString();
		String confirm = ((EditText)findViewById(R.id.confirmText)).getText().toString();
		
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
		registerSuccess.show();
		
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
		registerSuccess = new  AlertDialog.Builder(this)
		.setTitle("Success!")
		.setMessage("You are ready to play!")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				 Intent login = 
                         new Intent(RegisterActivity.this, MapActivity.class);
				 RegisterActivity.this.startActivity(login);
			}
		}).create();
		;
	}

	@Override
	public void handleQuery(MyQuery query) {
		if (query==null) return;
		if (query instanceof RegisterCheckQuery) {
			RegisterCheckQuery q = (RegisterCheckQuery)query;
			if (q.isInUse()) {
				usernameInUsePopup.show();
				return;
			}
			
			// actually register
			PSQL_Connection.sendRequest("db.doc.ic.ac.uk/g1227125_u","g1227125_u","RtoxBd22NV",
					new RegisterQuery(this,"" ));
			
		}
	}
}
