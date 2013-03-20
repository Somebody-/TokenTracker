package com.ekflagristoj.tokentracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void resetGame( View v ) {
		
	}
	public void spawnPlayer( View v ) {
		Intent intobj = new Intent( MainActivity.this, CreatePlayerActivity.class );
		startActivity( intobj );
	}
	public void newToken( View v ) {
		Intent intobj = new Intent( MainActivity.this, CreateTokenActivity.class );
		startActivity( intobj );
	}
	public void spawnToken( View v ) {
		Intent intobj = new Intent( MainActivity.this, SpawnTokenActivity.class );
		startActivity( intobj );
	}
	public void makeRandom( View v ) {
		Intent intobj = new Intent( MainActivity.this, RandomizerActivity.class );
		startActivity( intobj );
	}
}
