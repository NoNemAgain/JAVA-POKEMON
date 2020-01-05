package fr.upem.dut.info.pokemonproject;

import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class League {
	protected BotPlayer[] league;
	private BotPlayer activeBp;
	private Player player;
	public League(Player player,BotPlayer... league) {
		this.league=league;
		this.activeBp=league[0];
	}
}
