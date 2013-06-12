package com.example.logginsession.activity;

import com.example.logginsession.query.MyQuery;

import android.app.Activity;

public abstract class MyActivity extends Activity {

	public abstract void handleQuery(MyQuery query);
}
