package com.example.aplicacion;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

public class MenuActivity extends Activity {
	EditText dato,estado;
	String mensaje ="";
	ListView resultado;
	ArrayList<String>datos = new ArrayList<String>();
	Switch funcion;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
	
	}
		
	public void datos (View v) {
		mensaje = "";
		resultado =(ListView)findViewById(R.id.listView1);
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				String response = HttpRequest.get("http://"+cambiarIP.ip+"/Validar/consultar.php").body();
				
				try {
					JSONArray objecto = new JSONArray(response);
					
					for (int i =0; i < objecto.length(); i++) {
						mensaje = ""+objecto.getJSONArray(i).toString(0);
						datos.add(i, mensaje);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}).start();
		resultado.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos));
		datos.clear();
	}
	public void modificar (View v) {
		dato = (EditText)findViewById(R.id.ID);
		estado = (EditText)findViewById(R.id.estado);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				String response = HttpRequest.get("http://"+cambiarIP.ip+"/Validar/actualizar.php?id="+dato.getText().toString()+"&estado="+estado.getText().toString()).body();
				
			}
		}).start();
	}
}
