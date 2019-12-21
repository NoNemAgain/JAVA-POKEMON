package fr.upem.dut.info.pokemonproject;

import java.io.IOException;
import java.util.HashMap;

public class test {

	public static void main(String[] args) throws IOException {
		Pokedex poke = new Pokedex();
		HashMap<Integer, Pokemon> hp = poke.getPokedex();
		for( int i=0; i <= hp.size(); i++ ) {
			System.out.println(hp.get(i));
		}
		
		PokeCapacity capacities = new PokeCapacity();
		HashMap<String, CapacityDamage> a = capacities.getCapacities();
		System.out.println(a.get("leer"));
	}

}//
