package com.example.tarealog;

import com.example.tarealog.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Bloq extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bloq);
	}
	public void validaringreso(View view) {
		
		Intent intent = new Intent(getApplicationContext(), Log.class);		
		startActivity(intent);
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bloq, menu);
		return true;
	}

}
