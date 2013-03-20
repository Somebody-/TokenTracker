package com.ekflagristoj.tokentracker;

import com.ekflagristoj.tokentracker.util.Randomizer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class RandomizerActivity extends Activity {

	private Randomizer rnd = new Randomizer();
	
	private TextView lblResult;
	private NumberPicker sidesPicker;
	private String[] sidesOptions = { "4", "6", "8", "10", "12", "20", "100" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_randomizer);
		lblResult = (TextView)findViewById( R.id.lblResult );
		sidesPicker = (NumberPicker)findViewById( R.id.sidesPicker );
		sidesPicker.setMinValue( 0 );
		sidesPicker.setMaxValue( (sidesOptions.length - 1) );
		sidesPicker.setValue( 5 );
		sidesPicker.setDisplayedValues( sidesOptions );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_randomizer, menu);
		return true;
	}

	public void flipCoin( View v ) {
		String result = rnd.flipCoin();
		if ( result == "h" ) {
			lblResult.setText( (CharSequence)"Heads" );
		} else {
			lblResult.setText( (CharSequence)"Tails" );
		}
	}
	public void rollDie( View v ) {
		int faces;
		faces = Integer.parseInt( sidesOptions[ sidesPicker.getValue() ] );
		if ( faces >= 2 ) {
			Integer result = rnd.rollDie( faces );
			lblResult.setText( (CharSequence)result.toString() );
		}
	}
	public void done( View v ) {
		Intent intobj = new Intent( RandomizerActivity.this, MainActivity.class );
		startActivity( intobj );
	}
}
