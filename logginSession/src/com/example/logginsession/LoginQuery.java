package com.example.logginsession;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginQuery extends MyQuery {

	public LoginQuery(String query) {
		super(query);
	}

	@Override
	public void parseRequest(ResultSet rs) throws SQLException {
		String uid = rs.getString("user_id");
		//String username = rs.getString("user_name");
		//String password = rs.getString("user_password");
        System.out.println(uid);
	}

}
