package com.example.logginsession;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class LoginActivity extends Activity {

	private final int MIN_PASSWORD_LENGTH = 6;
	
	Button login;
	AlertDialog unimplementedPopup;
	EditText usernameText;
	EditText passwordText;

	private AlertDialog userAlphanumPopup;
	private AlertDialog blankPasswordPopup;
	private AlertDialog blankUsernamePopup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		addListenerOnButton();
		initialisePopups();
	}

	public void addListenerOnButton() {

		usernameText = (EditText) findViewById(R.id.usernameText);
		passwordText = (EditText) findViewById(R.id.passwordText);
		
		login = (Button) findViewById(R.id.login_main);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				//unimplementedPopup.show();
				String username = usernameText.getText().toString();
				String password = passwordText.getText().toString();
				
				if (username.length()==0) {
					blankUsernamePopup.show();
					return;
				}
				if (password.length()==0) {
					blankPasswordPopup.show();
					return;
				}
				
				System.err.println("!!!!!!!!!!!!!!!!    "+password);
				PSQL_Connection.sendRequest("db.doc.ic.ac.uk/g1227125_u","g1227125_u","RtoxBd22NV",
						new LoginQuery("SELECT user_id FROM users WHERE user_name='"+
								username+"' AND user_password='"+password +"'" ));
				
			}

		});


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
		blankUsernamePopup = new AlertDialog.Builder(this)
		.setTitle("Username Missing")
		.setMessage("The username field has been left blank")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();
		;		
		blankPasswordPopup = new AlertDialog.Builder(this)
		.setTitle("Password Missing")
		.setMessage("The password field has been left blank")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		}).create();

		;
	}


}
