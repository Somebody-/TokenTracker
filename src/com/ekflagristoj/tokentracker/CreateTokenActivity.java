package com.ekflagristoj.tokentracker;

import com.ekflagristoj.tokentracker.util.TokenDataSource;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class CreateTokenActivity extends Activity {

	private TextView txtName;
	private TextView txtType;
	private TextView txtPower;
	private TextView txtToughness;
	private TextView txtTokentext;
	private CheckBox chkColorless;
	private CheckBox chkWhite;
	private CheckBox chkBlue;
	private CheckBox chkBlack;
	private CheckBox chkRed;
	private CheckBox chkGreen;
	private CheckBox chkArtifact;
	private CheckBox[] colorsArray = new CheckBox[7];
	
	private TokenDataSource dataSource = new TokenDataSource( this );
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_token);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		txtName = (TextView) findViewById( R.id.txtName );
		txtType = (TextView) findViewById( R.id.txtType );
		txtPower = (TextView) findViewById( R.id.txtPower );
		txtToughness = (TextView) findViewById( R.id.txtToughness );
		txtTokentext = (TextView) findViewById( R.id.txtTokentext );
		
		chkColorless = (CheckBox) findViewById( R.id.chkColorless );
		chkWhite = (CheckBox) findViewById( R.id.chkWhite );
		chkBlue = (CheckBox) findViewById( R.id.chkBlue );
		chkBlack = (CheckBox) findViewById( R.id.chkBlack );
		chkRed = (CheckBox) findViewById( R.id.chkRed );
		chkGreen = (CheckBox) findViewById( R.id.chkGreen );
		chkArtifact = (CheckBox) findViewById( R.id.chkArtifact );
		
		colorsArray[0] = chkColorless;
		colorsArray[1] = chkWhite;
		colorsArray[2] = chkBlue;
		colorsArray[3] = chkBlack;
		colorsArray[4] = chkRed;
		colorsArray[5] = chkGreen;
		colorsArray[6] = chkArtifact;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_create_token, menu);
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

	public void colorlessChecked( View v ) {
		if ( chkColorless.isChecked() ) {
			chkWhite.setEnabled( false );
			chkBlue.setEnabled( false );
			chkBlack.setEnabled( false );
			chkRed.setEnabled( false );
			chkGreen.setEnabled( false );
			chkArtifact.setEnabled( false );
		} else {
			chkWhite.setEnabled( true );
			chkBlue.setEnabled( true );
			chkBlack.setEnabled( true );
			chkRed.setEnabled( true );
			chkGreen.setEnabled( true );
			chkArtifact.setEnabled( true );
		}
	}
	public void saveToken( View v )	{
		//Declare
		String tokenName = "";
		String tokenType = "";
		String tokenText = "";
		String colors = "";
		Integer tokenPower = 0;
		Integer tokenToughness = 0;
		//Initialize
		tokenName = txtName.getText().toString();
		if ( txtType.getText().toString().equals("") ) {
			tokenType = tokenName;
		} else {
			tokenType = txtType.getText().toString();
		}
		if ( txtPower.getText().toString().equals("") ) {
			tokenPower = 0;
		} else {
			tokenPower = Integer.parseInt( txtPower.getText().toString() );
		}
		if ( txtToughness.getText().toString().equals("") ) {
			tokenToughness = 0;
		} else {
			tokenToughness = Integer.parseInt( txtToughness.getText().toString() );
		}
		tokenText = txtTokentext.getText().toString();
		for ( CheckBox c : colorsArray ) {
			if ( c.isChecked() ) {
				colors += c.getText().toString() + ",";
			}
		}
		if ( colors.charAt( colors.length()-1 ) == ',' ) {
			colors = colors.substring( 0, (colors.length()-1) );
		}
		//Save to DB
		dataSource.open();
		dataSource.createToken( tokenName, tokenType, colors, tokenPower, tokenToughness, tokenText);
		dataSource.close();
		//Go back to main activity
		Intent intobj = new Intent( CreateTokenActivity.this, MainActivity.class );
		startActivity( intobj );
	}
	public void resetForm( View v ) {
		CharSequence blank = "";
		txtName.setText( blank );
		txtType.setText( blank );
		txtPower.setText( blank );
		txtToughness.setText( blank );
		txtTokentext.setText( blank );
		
		chkColorless.setChecked( false );
		chkWhite.setChecked( false );
		chkBlue.setChecked( false );
		chkBlack.setChecked( false );
		chkRed.setChecked( false );
		chkGreen.setChecked( false );
		chkArtifact.setChecked( false );
	}
	public void cancelCreation( View v ) {
		Intent intobj = new Intent( CreateTokenActivity.this, MainActivity.class );
		startActivity( intobj );
	}
}
