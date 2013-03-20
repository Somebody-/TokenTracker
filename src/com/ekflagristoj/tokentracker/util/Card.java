package com.ekflagristoj.tokentracker.util;

import com.ekflagristoj.tokentracker.util.Token;


public class Card
{
	//Token the card is for
	public Token tokenType;
	//How many tokens are in this physical card stack
	private int stackNum;
	//Is the stack tapped?
	private boolean tapped;
	
	//Mutators
	public void setTokenType( Token value )
	{
		this.tokenType = value;
	}
	public void setStackNum( int value )
	{
		this.stackNum = value;
	}
	public void setTapped( boolean value ) {
		this.tapped = !this.tapped;
	}
	//Accessors
	public Token getTokenType()
	{
		return this.tokenType;
	}
	public int getStackNum()
	{
		return this.stackNum;
	}

	
	//Constructor
	public Card( Token type, int quantity )
	{
		this.setTokenType( type );
		this.setStackNum( quantity );
	}
	
	public boolean isTapped() {
		return this.tapped;
	}
}