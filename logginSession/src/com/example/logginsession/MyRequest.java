package com.example.logginsession;

public class MyRequest {

	private String url;
	private String user;
	private String pass;
	private MyQuery query;
	
	public MyRequest(String url, String user, String pass, MyQuery query) {
		this.url=url;
		this.user=user;
		this.pass=pass;
		this.query=query;
		
	}
	
	public MyRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPass() {
		return pass;
	}
	public MyQuery getQuery() {
		return query;
	}
}
