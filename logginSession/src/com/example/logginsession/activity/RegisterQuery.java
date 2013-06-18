package com.example.logginsession.activity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.logginsession.query.MyQuery;

public class RegisterQuery extends MyQuery {

	public RegisterQuery(MyActivity activity, String query) {
		super(activity, query);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub

	}

}
