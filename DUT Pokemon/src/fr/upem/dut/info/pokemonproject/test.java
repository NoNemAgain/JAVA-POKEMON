package fr.upem.dut.info.pokemonproject;

import java.io.IOException;
import java.util.HashMap;

import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;

public class test {

	public static void main(String[] args) throws IOException {
		Pokedex poke = new Pokedex();
		System.out.println(poke);
		
		PokeCapacity capacities = new PokeCapacity();
		HashMap<String, CapacityDamage> a = capacities.getCapacities();
		System.out.println(a.get("leer"));
		
		TypesMultiplicators tm =new TypesMultiplicators();
		System.out.println(tm);
	}

}//
