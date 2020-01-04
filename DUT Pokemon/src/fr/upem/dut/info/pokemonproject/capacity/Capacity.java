package fr.upem.dut.info.pokemonproject.capacity;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public interface Capacity {
	Type getType();
	boolean canChooseCapacity(PokemonFight p);
	String getName();
	
}
