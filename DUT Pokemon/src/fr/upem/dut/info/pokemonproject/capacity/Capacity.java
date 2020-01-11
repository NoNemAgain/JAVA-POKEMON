package fr.upem.dut.info.pokemonproject.capacity;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public interface Capacity {
	/**
	 * Interface used to allow to call every different types of capacities like {@link CapacityDamage} 
	 * and CapacityStatus (in the futur) by the same name
	 */
	Type getType();

	boolean canChooseCapacity(PokemonFight p);

	String getName();
}
