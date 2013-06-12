package com.example.logginsession.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.logginsession.activity.MyActivity;

public abstract class MyQuery {

	private String query;
	private MyActivity activity;
	
	public MyQuery(MyActivity activity, String query) {
		this.query=query;
		this.activity=activity;
	}
	
	public String getQuery() {
		return query;
	}
	
	public void notifyActivity() {
		activity.handleQuery(this);
	}
	
	public abstract void parseResult(ResultSet rs) throws SQLException;

	public void finish() {
		// TODO Auto-generated method stub
		
	}
}
