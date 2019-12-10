package fr.upem.dut.info.pokemonproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class Pokedex {
	private HashMap<Integer,Pokemon> pokedex;
	 private static final String fileName = "src/fr/upem/dut/info/source/pokedex.csv";
	private final int version ;
	public Pokedex () {
		HashMap<Integer,Pokemon> pokedex = new HashMap<>();
		this.version=0;
	}
	public void init() throws FileNotFoundException {
		FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
	}
	
	

}
