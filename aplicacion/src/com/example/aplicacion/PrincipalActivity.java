package com.example.aplicacion;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class PrincipalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_principal);
		
		getActionBar().hide();
		
		int time = 2000;
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent INTENTE = new Intent(PrincipalActivity.this, MainActivity.class);
				startActivity(INTENTE);
				finish();
			}
		}, time);
	}
}
