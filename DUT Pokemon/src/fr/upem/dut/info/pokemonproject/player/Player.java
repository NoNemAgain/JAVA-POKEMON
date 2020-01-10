package fr.upem.dut.info.pokemonproject.player;

import fr.upem.dut.info.pokemonproject.Fight;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public interface Player {

	int action(String event, Pokedex pokedex, PokeCapacity pokeCapacity, TypesMultiplicators tm, Player player2,
			Fight fight, int round);

	boolean lose();

	String getName();

	PokemonFight getActivePokemon();

	void deletePokemon();

}
