package com.example.tarealog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioSQLiteHelper extends SQLiteOpenHelper{ //heredando de la clase SQLiteOpenHelper

	private String sqlCreate= "CREATE TABLE Usuario(User TEXT, password TEXT)";

	public UsuarioSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		//constructor de la clase
	}

	@Override
	public void onCreate(SQLiteDatabase db) {//se ejecuta una sola vez
		// TODO Auto-generated method stub
		
		db.execSQL(sqlCreate);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTs Usuario");//borra la antigua
		db.execSQL(sqlCreate);//crea la nueva
		
	}

}
