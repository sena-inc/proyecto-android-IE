package com.example.aplicacion;

import java.io.DataOutputStream;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;

import android.R.array;
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
		login = (EditText)findViewById(R.id.estado);
 		pass = (EditText)findViewById(R.id.ID);
 		
 		validar = (Button)findViewById(R.id.login);
 		
 		validar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						String response = HttpRequest.get("http://"+cambiarIP.ip+"/Validar/validar.php?id="+login.getText().toString()+"&pass="+pass.getText().toString()).body();
						try {
							JSONArray objecto = new JSONArray(response);
								
								if(objecto.length()>0) {
									Intent e = new Intent(getApplicationContext(), MenuActivity.class);
									startActivity(e);
								}else{
									Toast.makeText(getApplicationContext(), "usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
								}
							
							}catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								}
							
								
							
							
					}
				}).start();
				
			}
 		});
	}
		
	
	}

