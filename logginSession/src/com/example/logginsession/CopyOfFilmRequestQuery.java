package com.example.logginsession;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CopyOfFilmRequestQuery extends MyQuery {

	public CopyOfFilmRequestQuery(String query) {
		super(query);
	}

	@Override
	public void parseRequest(ResultSet rs) throws SQLException {
		String title = rs.getString("title");
        String director = rs.getString("director");
        String origin = rs.getString("origin");
        String made = rs.getString("made");
        String length = rs.getString("length");
        System.out.println(title+","+director+","+origin+","+made+","+length );
	}

}
