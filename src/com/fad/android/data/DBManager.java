package com.fad.android.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager {
	
	public static final int DB_VER = 1;
	public static final String DB_NAME = "TEST";
	
	public static final String TBL_PERSONA = "persona";
	public static final String FLD_ID = "id_persona";
	public static final String FLD_NOMBRE = "nombre";
	public static final String FLD_APELLIDO = "apellido";
	public static final String FLD_EDAD = "edad";
	
	private Context context;
	private DBHelper conn;
	public DBManager (Context ctx) {
		context = ctx;
		conn = new DBHelper(ctx);
	}
	
	public void insertPersona(Persona p) {
		SQLiteDatabase db;
		String insertQuery = "INSERT INTO " + TBL_PERSONA + "(" + FLD_NOMBRE + "," + FLD_APELLIDO + "," +
		FLD_EDAD +") VALUES ('" + p.getNombre() + "','" + p.getApellido() + "'," + p.getEdad() + ")";
		db = conn.getWritableDatabase();
		db.execSQL(insertQuery);
	}
	public void deletePersona(int id) {
		
	}
	public void updatePersona(Persona p){
		
	}
	public Persona selectPersona(int id) {
		SQLiteDatabase db;
		Persona p=null;
		Cursor cursor;
		String selectQuery = "SELECT " +FLD_ID + ","+ FLD_NOMBRE + "," + FLD_APELLIDO + "," +
				FLD_EDAD + " FROM " + TBL_PERSONA + " WHERE " + FLD_ID + "=" + id;
		db=conn.getReadableDatabase();
		cursor = db.rawQuery(selectQuery, null);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			p = new Persona();
			p.setId(cursor.getInt(cursor.getColumnIndex(FLD_ID)));
			p.setNombre(cursor.getString(cursor.getColumnIndex(FLD_NOMBRE)));
			p.setApellido(cursor.getString(cursor.getColumnIndex(FLD_APELLIDO)));
			p.setEdad(cursor.getInt(cursor.getColumnIndex(FLD_EDAD)));
		}
		return p;
	}
	
	public class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DB_NAME, null, DB_VER);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTabla = "CREATE TABLE " + TBL_PERSONA + " ("+FLD_ID + " INTEGER PRIMARY KEY" +
					" AUTOINCREMENT,"+ FLD_NOMBRE + " TEXT," + FLD_APELLIDO +
					" TEXT," + FLD_EDAD + " INTEGER)";
			db.execSQL(createTabla);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
