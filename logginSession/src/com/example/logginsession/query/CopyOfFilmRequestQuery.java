package com.example.logginsession.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.logginsession.activity.MyActivity;

public class CopyOfFilmRequestQuery extends MyQuery {


	public CopyOfFilmRequestQuery(MyActivity activity, String query) {
		super(activity, query);
	}

	@Override
	public void parseResult(ResultSet rs) throws SQLException {
		String title = rs.getString("title");
        String director = rs.getString("director");
        String origin = rs.getString("origin");
        String made = rs.getString("made");
        String length = rs.getString("length");
        System.out.println(title+","+director+","+origin+","+made+","+length );
	}

}
