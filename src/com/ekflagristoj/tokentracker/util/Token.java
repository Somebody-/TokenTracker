package com.ekflagristoj.tokentracker.util;

import java.util.ArrayList;

public class Token {

	private long id;
	private String name;
	private ArrayList<String> colors = new ArrayList<String>();
	private String type;
	private int power, toughness;
	private String text;
	
	public void setID( long value ) {
		this.id = value;
	}
	public void setName( String value )	{
		this.name = value;
	}
	public void setType( String value )	{
		this.type = value;
	}
	public void setPower( int value ) {
		this.power = value;
	}
	public void setToughness( int value ) {
		this.toughness = value;
	}
	public void setText( String value )	{
		this.text = value;
	}
	public void setColors( String[] values ) {
		this.colors = new ArrayList<String>();
		for ( String color : values )
		{
			this.colors.add( color );
		}
	}

	public long getID() {
		return this.id;
	}
	public String getName()
	{
		return this.name;
	}
	public String getType()
	{
		return this.type;
	}
	public int getPower()
	{
		return this.power;
	}
	public int getToughness()
	{
		return this.toughness;
	}
	public String getText()
	{
		return this.text;
	}
	public String[] getColors()
	{
		return this.colors.toArray( new String[this.colors.size()] );
	}
	
	public Token( long id, String name, String[] colors, String type, String subtype, int power, int toughness, String[] abilities, String text )
	{
		this.setID( id );
		this.setName( name );
		this.setColors( colors );
		this.setType( type );
		this.setPower( power );
		this.setToughness( toughness );
		this.setText( text );
	}
	public Token() {
		this.setID( 0 );
		this.setName( "" );
		this.colors = new ArrayList<String>();
		this.setType( "" );
		this.setPower( 0 );
		this.setToughness( 0 );
		this.setText( "" );
	}
	
	public String colorsToCSV() {
		String csvString = "";
		for( String color : this.colors ) {
			csvString += color + ",";
		}
		csvString = csvString.substring(0, (csvString.lastIndexOf(",") - 1) );
		return csvString;
	}
	public void csvToColors( String csv ) {
		ArrayList<String> colors = new ArrayList<String>();
		int startPos = 0; 
		int endPos;
		for ( int i = 0; i < csv.length(); i++ ) {
			if ( csv.charAt(i) == ',' ) {
				endPos = i;
				colors.add( csv.substring(startPos, endPos) );
				startPos = ( endPos + 1 );
			}
		}
		this.setColors( colors.toArray( new String[colors.size()] ) );
	}
}
