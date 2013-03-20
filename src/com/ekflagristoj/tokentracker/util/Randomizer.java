package com.ekflagristoj.tokentracker.util;

import java.util.Random;

public class Randomizer {

	private Random randomizer;
	
	public String flipCoin() {
		return ( ( randomizer.nextInt(2) == 1 ) ? "h" : "t" );
	}
	public int rollDie( int faces ) {
		return ( randomizer.nextInt( faces ) + 1 );
	}
	public Randomizer() {
		this.randomizer = new Random();
	}
}
