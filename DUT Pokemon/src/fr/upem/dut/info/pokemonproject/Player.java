package fr.upem.dut.info.pokemonproject;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	private final String name ;
	private PokemonFight[] team = new PokemonFight[5];
	
	public Player(String name,PokemonFight... team) {
		this.name=name;
		this.team=team;
	}
	public void deadPokemon() {
		for(int i = 0; i <= 5; i++) {
			if (team[i].isdead()) {
				team[i]=null;
				System.out.println(team[i].dead());
			}
		}
	}
	public void action (KeyEvent event) {
		
		System.out.println(team[0]);
	}
}

