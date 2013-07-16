package com.fad.android;

import com.fad.android.data.DBManager;
import com.fad.android.data.Persona;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private DBManager conn;
	private Persona p;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		conn = new DBManager(this);
		p = new Persona();
		p.setNombre("Maria");
		p.setApellido("Gonzalez");
		p.setEdad(33);
		p.setId(1);
		conn.insertPersona(p);
		p = new Persona();
		p.setNombre("Elena");
		p.setApellido("Troya");
		p.setEdad(30);
		p.setId(1);
		conn.insertPersona(p);
		
		p = conn.selectPersona(3);
		Log.d("DEBUG","nombre :" +  p.getNombre() + " " + p.getApellido() + " edad : " + p.getEdad());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
