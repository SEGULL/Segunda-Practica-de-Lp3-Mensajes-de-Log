package com.example.tarealog;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WelcomeUser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_user);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_user, menu);
		return true;
	}

}
