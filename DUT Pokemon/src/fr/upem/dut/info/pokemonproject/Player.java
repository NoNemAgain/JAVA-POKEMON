package fr.upem.dut.info.pokemonproject;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	private PokemonFight[] team = new PokemonFight[6];
	
	public Player(PokemonFight... team) {
		this.team=team;
	}
	void deadPokemon() {
		for(int i = 1; i <= 6; i++) {
			if (team[i].isdead()) {
				team[i]=null;
				System.out.println(team[i].dead());
			}
		}
	}
}

