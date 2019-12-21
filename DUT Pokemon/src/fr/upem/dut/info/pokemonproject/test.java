package fr.upem.dut.info.pokemonproject;

import java.io.IOException;
import java.util.HashMap;

public class test {

	public static void main(String[] args) throws IOException {
		Pokedex poke = new Pokedex();
		System.out.println(poke);
		
		PokeCapacity capacities = new PokeCapacity();
		HashMap<String, CapacityDamage> a = capacities.getCapacities();
		System.out.println(a.get("leer"));
	}

}//
