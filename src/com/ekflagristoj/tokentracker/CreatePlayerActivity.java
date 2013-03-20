package com.ekflagristoj.tokentracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class CreatePlayerActivity extends Activity {

	private TextView txtPlayerName = (TextView) findViewById( R.id.txtPlayerName );
	private TextView txtPlayerLife = (TextView) findViewById( R.id.txtPlayerLife );
	private TextView txtPlayerPoison = (TextView) findViewById( R.id.txtPlayerPoison );
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_player);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_create_player, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void subtractLife( View v ) {
		Integer currentSetting = Integer.parseInt( txtPlayerLife.getText().toString() );
		if ( currentSetting > 1 ) {
			currentSetting -= 1;
		}
		txtPlayerLife.setText( (CharSequence)currentSetting.toString() );
	}
	public void addLife( View v ) {
		Integer currentSetting = Integer.parseInt( txtPlayerLife.getText().toString() );
		currentSetting += 1;
		txtPlayerLife.setText( (CharSequence)currentSetting.toString() );		
	}
	public void subtractPoison( View v ) {
		Integer currentSetting = Integer.parseInt( txtPlayerPoison.getText().toString() );
		if ( currentSetting > 1 ) {
			currentSetting -= 1;
		}
		txtPlayerPoison.setText( (CharSequence)currentSetting.toString() );		
	}
	public void addPoison( View v ) {
		Integer currentSetting = Integer.parseInt( txtPlayerPoison.getText().toString() );
		if ( currentSetting < 9 ) {
			currentSetting += 1;
		}
		txtPlayerPoison.setText( (CharSequence)currentSetting.toString() );
	}
	public void addPlayer( View v ) {
		//Grab values
		String playerName = txtPlayerName.getText().toString();
		Integer playerLife = Integer.parseInt( txtPlayerLife.getText().toString() );
		Integer playerPoison = Integer.parseInt( txtPlayerPoison.getText().toString() );
		//Validate
		
		//Pass back to main activity
		Intent intobj = new Intent( CreatePlayerActivity.this, MainActivity.class );
		intobj.setAction( "SPAWN_PLAYER" );
		intobj.putExtra( "playerName", playerName );
		intobj.putExtra( "playerLife", playerLife );
		intobj.putExtra( "playerPoison", playerPoison );
		startActivity( intobj );
	}
	public void resetForm( View v ) {
		txtPlayerName.setText( "" );
		txtPlayerLife.setText( (CharSequence)"20");
		txtPlayerPoison.setText( (CharSequence)"0" );
	}
	public void cancelCreation( View v ) {
		Intent intobj = new Intent( CreatePlayerActivity.this, MainActivity.class );
		startActivity( intobj );
	}
}
