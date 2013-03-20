package com.ekflagristoj.tokentracker;

import java.util.List;

import com.ekflagristoj.tokentracker.util.Token;
import com.ekflagristoj.tokentracker.util.TokenDataSource;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.support.v4.app.NavUtils;

public class SpawnTokenActivity extends Activity {

	private TokenDataSource datasource;
	private List<Token> ALLTOKENS;

	private RadioGroup grpTokens;
	private RadioButton radToken;
	private String radioText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spawn_token);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		grpTokens = (RadioGroup) findViewById( R.id.grpTokens );
		
		datasource = new TokenDataSource( this );
		datasource.openRead();
		ALLTOKENS = datasource.getAllTokens();
		datasource.close();
		for ( Token t : ALLTOKENS ) {
			String colorAbbreviation = abbreviateColors( t.getColors() );
			radioText = t.getName() + " (" + colorAbbreviation + ") " + t.getPower() + "/" + t.getToughness();
			radToken = new RadioButton( this );
			radToken.setText( (CharSequence) radioText );
			grpTokens.addView( radToken );
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_spawn_token, menu);
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

	public void spawn( View v ) {
		Intent intobj = new Intent( SpawnTokenActivity.this, MainActivity.class );
		startActivity( intobj );
	}
	public void cancel( View v ) {
		Intent intobj = new Intent( SpawnTokenActivity.this, MainActivity.class );
		startActivity( intobj );
	}
	
	private String abbreviateColors( String[] colors ) {
		String colorAbbreviation = "";
		for ( String color : colors ) {
			if ( color.equals("Colorless") ) {
				colorAbbreviation += "N";
			} else if ( color.equals("Artifact") ) {
				colorAbbreviation += "A";
			} else if ( color.equals("White") ) {
				colorAbbreviation += "W";
			} else if ( color.equals("Blue") ) {
				colorAbbreviation += "U";
			} else if ( color.equals("Black") ) {
				colorAbbreviation += "B";
			} else if ( color.equals("Red") ) {
				colorAbbreviation += "R";
			} else if ( color.equals("Green") ) {
				colorAbbreviation += "G";
			} else {
				colorAbbreviation += color;
			}
		}
		return colorAbbreviation;
	}
}
