package fr.upem.dut.info.pokemonproject;

import java.util.HashMap;

public class Pokedex {
	private HashMap<Integer,Pokemon> pokedex;
	private final int version ;
	public Pokedex () {
		HashMap<Integer,Pokemon> pokedex = new HashMap<>();
		this.version=0;
	}
	

}
