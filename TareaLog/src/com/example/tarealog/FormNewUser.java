package com.example.tarealog;

import java.util.ArrayList;





import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FormNewUser extends FragmentActivity {

	private static final ArrayList<String> names = new ArrayList<String>();
	private static final ArrayList<String> passs = new ArrayList<String>();
	public static final String NAME_TAG = "name";
	private TextView txt_name;
	private TextView txt_pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_new_user);

		final EditText input_name = (EditText) findViewById(R.id.txt_nombre);
		final EditText input_pass = (EditText) findViewById(R.id.txt_password);
		ListView list = (ListView) findViewById(R.id.lt_names);
		Button btn_submit = (Button) findViewById(R.id.btn_enviar);

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				names);
		list.setAdapter(adapter);
		
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

			String name = adapter.getItem(arg2);
				if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
				
				} else {
				
					
				}

			}
		});

		
		btn_submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = input_name.getText().toString();
				String pas = input_pass.getText().toString();
				
				if (!names.contains(name)&&!passs.contains(pas)) {
					UsuarioSQLiteHelper uDB=new UsuarioSQLiteHelper(getApplicationContext(), "DBUsuarios", null, 1);//instancia de la DB
					SQLiteDatabase db=uDB.getWritableDatabase();
				
					
					db.execSQL("INSERT INTO Usuario(User,password)VALUES('"+name+"','"+pas+"')");
					
					db.close();//cerrar la conexion
					
					if (!names.contains(name)&&!passs.contains(pas)){
					SQLiteDatabase dbSelect=uDB.getReadableDatabase();
					
					Cursor cursor = dbSelect.rawQuery("SELECT  User FROM Usuario", null);//query de consulta a la DB(select)
					
					while (cursor.moveToNext()){ 
						//names.add(name);
					  
							 names.add(cursor.getString(0));
								adapter.notifyDataSetChanged();
								


						}
					
					cursor.close();
					db.close();}
								}else{
					
					Button btnSubmit = (Button) findViewById(R.id.btn_enviar);

					btnSubmit.setOnClickListener(new MiListener());
				}

			}
		});
	}
	//Log.e("SQLiteText", "Nombre Usuario: "+cursor.getString(1)); //1 indice de nombre//dame el string de la columna 1
	//

	
	//dbSelect.close();

	//names.add(name);
	//adapter.notifyDataSetChanged();	


//	            	modifica arrays


	//names.add(namea);
	//adapter.notifyDataSetChanged();
	
	class MiListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "Lo Sentimos Pero Ya Esta Registrado :)",
					Toast.LENGTH_LONG).show();
//			Log.e(TAG, "Me hicieron click");

		}
	}
	
	class MiListener1 implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "User Registrado:)",
					Toast.LENGTH_LONG).show();
//			Log.e(TAG, "Me hicieron click");

		}
	}

}


