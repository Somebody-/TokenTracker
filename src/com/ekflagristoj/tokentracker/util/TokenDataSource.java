package com.ekflagristoj.tokentracker.util;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TokenDataSource {

	private SQLiteDatabase db;
	private DatabaseHelper dbHelper;
	private String[] columns = { 
			DatabaseHelper.COLUMN_ID, 
			DatabaseHelper.COLUMN_NAME, 
			DatabaseHelper.COLUMN_TYPE,
			DatabaseHelper.COLUMN_COLORS,
			DatabaseHelper.COLUMN_POWER,
			DatabaseHelper.COLUMN_TOUGHNESS,
			DatabaseHelper.COLUMN_TEXT
			};
	
	public TokenDataSource( Context c ) {
		dbHelper = new DatabaseHelper( c );
	}
	public void open() throws SQLException {
	    db = dbHelper.getWritableDatabase();
	}
	public void openRead() throws SQLException {
		db = dbHelper.getReadableDatabase();
	}
	public void close() {
	    db.close();
	}
	public void createToken( String name, String type, String colors, int power, int toughness, String text ) {
		
		ContentValues values = new ContentValues();
		values.put( DatabaseHelper.COLUMN_NAME, name );
		values.put( DatabaseHelper.COLUMN_TYPE, type );
		values.put( DatabaseHelper.COLUMN_COLORS, colors );
		values.put( DatabaseHelper.COLUMN_POWER, power );
		values.put( DatabaseHelper.COLUMN_TOUGHNESS, toughness );
		values.put( DatabaseHelper.COLUMN_TEXT, text );
		
		long insertId = db.insert( DatabaseHelper.TABLE_NAME, null, values );
	    //Cursor cursor = db.query( DatabaseHelper.TABLE_NAME, columns, DatabaseHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
	    //cursor.moveToFirst();
	    //Token newToken = cursorToToken(cursor);
	    //cursor.close();
	    //return newToken;
	}
	private Token cursorToToken(Cursor cursor) {
	    Token t = new Token();
	    t.setID( cursor.getLong(0) );
	    t.setName( cursor.getString(1) );
	    t.setType( cursor.getString(2) );
	    t.csvToColors( cursor.getString(3) );
	    t.setPower( cursor.getInt(4) );
	    t.setToughness( cursor.getInt(5) );
	    t.setText( cursor.getString(6) );
	    return t;
	}
	public void deleteToken( Token t ) {
		long id = t.getID();
		db.delete( DatabaseHelper.TABLE_NAME, DatabaseHelper.COLUMN_ID + " = " + id, null);
	}
	public List<Token> getAllTokens() {
		List<Token> tokensList = new ArrayList<Token>();

		Cursor cursor = db.query( DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Token t = cursorToToken(cursor);
			tokensList.add( t );
		    cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return tokensList;
	}

}
