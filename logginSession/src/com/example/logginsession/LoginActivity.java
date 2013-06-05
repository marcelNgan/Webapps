package com.example.logginsession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {
	
	Button login;
	AlertDialog unimplementedPopup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		addListenerOnButton();
	}
	
	public void addListenerOnButton() {
		 
		unimplementedPopup = new AlertDialog.Builder(this)
		.setTitle("Not Implemented")
		.setMessage("Login has not been implemented")
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
					}
				}).create();
		;

		login = (Button) findViewById(R.id.login_button);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//unimplementedPopup.show();
				String username = findViewById(R.id.editText1).toString();
				String password = findViewById(R.id.editText2).toString();
				
				try {
					doPost(null, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}

		});


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// response.setContentType("text/html");
		
		//PrintWriter out = response.getWriter();
		//String operation = request.getParameter("op");
		PrintWriter out = new PrintWriter(System.out);
		String operation = "";
		
		if (operation == null) {
			out.println("<br>no operation specified</br>");
			return;
		}
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			out.println("<h1>Driver not found: " + e + e.getMessage() + "</h1>");
		}
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://db.doc.ic.ac.uk/g1227125_u",
					"g1227125_u", "RtoxBd22NV");
			Statement stmt = conn.createStatement();
			//handleOperation(operation, stmt, request, out);
		} catch (Exception e) {
			out.println("<h1>exception: " + e + e.getMessage() + "</h1>");
		}
	}
	
	

}
