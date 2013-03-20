package com.ekflagristoj.tokentracker.util;

public class Player
{
	private String name;
	private int life;
	private int poison;
	
	public void setName( String value )
	{
		this.name = value;
	}
	public void setLife( int value )
	{
		this.life = value;
	}
	private void setPoison( int value )
	{
		this.poison = value;
	}
	
	public String getName()
	{
		return this.name;
	}
	public int getLife()
	{
		return this.life;
	}
	public int getPoison()
	{
		return this.poison;
	}
	
	public Player()
	{
		this.setName( "" );
		this.setLife( 20 );
		this.setPoison( 0 );
	}
	public Player( String name, int life, int poison ) {
		this.setName( name );
		this.setLife( life );
		this.setPoison( poison );
	}
}