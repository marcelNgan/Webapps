package com.example.logginsession.activity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.logginsession.query.MyQuery;

public class RegisterCheckQuery extends MyQuery {

	private boolean used=false;
	
	public RegisterCheckQuery(MyActivity activity, String query) {
		super(activity, query);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseResult(ResultSet rs) throws SQLException {
		used=true;

	}

	public boolean isInUse() {
		// TODO Auto-generated method stub
		return used;
	}

}
