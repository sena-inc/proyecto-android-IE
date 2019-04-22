package com.example.aplicacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.VelocityTrackerCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends Activity {

		EditText id,nom,ape,tel,mail,pass,rol;
		Button registro;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
	}
	
	public void registro (View v) {
		id = (EditText)findViewById(R.id.estado);
		nom = (EditText)findViewById(R.id.ID);
		ape = (EditText)findViewById(R.id.editText3);
		tel = (EditText)findViewById(R.id.editText4);
		mail = (EditText)findViewById(R.id.editText6);
		pass = (EditText)findViewById(R.id.editText5);
		rol = (EditText)findViewById(R.id.editText7);
		
		registro = (Button)findViewById(R.id.login);
		
		registro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						String response = HttpRequest.get("http://"+cambiarIP.ip+"/Validar/Registrar.php?id="+id.getText().toString()+"&nombre="+nom.getText().toString()+"&apellido="+ape.getText().toString()+"&telefono="+tel.getText().toString()+"&corre="+mail.getText().toString()+"&pass="+pass.getText().toString()+"&rol="+rol.getText().toString()).body();
						
						try {
							runOnUiThread(new  Runnable() {
								public void run() {
									try {
										
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
							});
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}).start();
				
			}
		});
		
		
	}
}
