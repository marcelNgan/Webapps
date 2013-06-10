package com.example.logginsession;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class MyQuery {

	private String query;
	
	public MyQuery(String query) {
		this.query=query;
	}
	
	public String getQuery() {
		return query;
	}
	
	public abstract void parseRequest(ResultSet rs) throws SQLException;
}
