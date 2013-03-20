package com.ekflagristoj.tokentracker.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	public static final String DATABASE_NAME = "tokens.db";
	public static final int DATABASE_VERSION = 2;
	public static final String TABLE_NAME = "tokens";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_TYPE = "type";
	public static final String COLUMN_COLORS = "colors";
	public static final String COLUMN_POWER = "power";
	public static final String COLUMN_TOUGHNESS = "toughness";
	public static final String COLUMN_TEXT = "text";
	
	private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " ( "
			+ COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME + " text not null, "
			+ COLUMN_TYPE + " text not null, "
			+ COLUMN_COLORS + " text not null, "
			+ COLUMN_POWER + " integer not null, "
			+ COLUMN_TOUGHNESS + " integer not null, "
			+ COLUMN_TEXT + " text " + ");";
	
	
	public DatabaseHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL( TABLE_CREATE );		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME );
		onCreate( db );
	}

}
