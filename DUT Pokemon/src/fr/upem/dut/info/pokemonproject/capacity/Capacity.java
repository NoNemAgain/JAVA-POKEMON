package fr.upem.dut.info.pokemonproject.capacity;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public interface Capacity {
	Type getType();
	void damage(PokemonFight p,TypesMultiplicators tm);
	boolean canChooseCapacity(PokemonFight p);
	String getName();
	
}
