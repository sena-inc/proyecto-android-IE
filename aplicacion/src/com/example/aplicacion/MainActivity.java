package com.example.aplicacion;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button oprimir;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		oprimir = (Button)findViewById(R.id.button1);
		
		oprimir.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(MainActivity.this, LoginActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void Que (View v){
		
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);  
		dialogo1.setTitle("Que es ?"); 
		
		dialogo1.setMessage("� ---- ?");
		dialogo1.setCancelable(false); 
		dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int i) {
				
				
			}
		});
		dialogo1.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this ,"adi�s",Toast.LENGTH_SHORT).show();
				
			}
		});
		dialogo1.create().show();
	}
	
	public void funciona(View v) {
		
		AlertDialog.Builder dialogo2 = new AlertDialog.Builder(this);  
		dialogo2.setTitle("Para que funciona ?"); 
		
		dialogo2.setMessage("� ---- ?");
		dialogo2.setCancelable(false); 
		dialogo2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int i) {
				
				
			}
		});
		dialogo2.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this ,"adi�s",Toast.LENGTH_SHORT).show();
				
			}
		});
		dialogo2.create().show();
		
	}
	
	public void equipo(View v) {
		
		AlertDialog.Builder dialogo3 = new AlertDialog.Builder(this);  
		dialogo3.setTitle("Nuestro equipo desarrollador ?"); 
		
		dialogo3.setMessage("� ---- ?");
		dialogo3.setCancelable(false); 
		dialogo3.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int i) {
				
				
			}
		});
		dialogo3.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this ,"adi�s",Toast.LENGTH_SHORT).show();
				
			}
		});
		dialogo3.create().show();
	}
}
