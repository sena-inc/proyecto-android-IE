package com.example.aplicacion;

import java.io.DataOutputStream;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	EditText login,pass;
	Button validar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		login = (EditText)findViewById(R.id.editText1);
 		pass = (EditText)findViewById(R.id.editText2);
 		
 		validar = (Button)findViewById(R.id.button1);
 		
 		validar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {


				Thread tr = new Thread() {
					@Override
					public void run() {
						final String res =EnviarPost(login.getText().toString(),pass.getText().toString());
						runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								int r=obJSON(res);
								
								if (r>0) {
									Intent i = new Intent(getApplicationContext(), MenuActivity.class);
									startActivity(i);
								}else {
									Toast.makeText(getApplicationContext(), "usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
								}
								
							}
						});
					}
				};
				tr.start();
			}
		});
 		
	}
	public String EnviarPost (String usuario , String contraseña) {
		String guardar="id="+usuario+"&pass="+contraseña;
		HttpsURLConnection conectar = null;
		String respuesta="";
		
		try {
			URL url = new URL("192.168.0.17/validar/validar.php");
			conectar=(HttpsURLConnection)url.openConnection();
			conectar.setRequestMethod("POST");
			conectar.setRequestProperty("Content-Lenght",""+Integer.toString(guardar.getBytes().length));
			
			conectar.setDoOutput(true);
			DataOutputStream datico = new DataOutputStream(conectar.getOutputStream());
			datico.writeBytes(guardar);
			datico.close();
			
			Scanner consumido = new Scanner(conectar.getInputStream());
			
			while(consumido.hasNextLine()) {
				respuesta+=(consumido.nextLine());
			}
			
		} catch (Exception e) {}
		
			return respuesta.toString();
		
	}
	public int obJSON (String respta) {
		int res=0;
		try {
			JSONArray json = new JSONArray(respta);
			if(json.length()>0) {
				res=1;
			}
			
			
		} catch (Exception e) {}
			return res;	
		
	}
}
