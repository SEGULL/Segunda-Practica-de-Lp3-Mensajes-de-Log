package com.example.tarealog;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class NewIntLog extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_int_log);
	}
	public void CrearUser(View view){
		Intent intent = new Intent(getApplicationContext(), FormNewUser.class);		
		startActivity(intent);
		
	}
	public void IntentarNew(View view){
		Intent intent = new Intent(getApplicationContext(), Bloq.class);		
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_int_log, menu);
		return true;
	}

}
