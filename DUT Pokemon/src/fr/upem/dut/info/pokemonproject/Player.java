package fr.upem.dut.info.pokemonproject;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	private final String name ;
	private PokemonFight[] team = new PokemonFight[5];
	private PokemonFight activePokemon ;
	int compteurDeath=0 ;
	int numberPokemon =0;
	
	public Player(String name,PokemonFight... team) {
		this.name=name;
		this.activePokemon=team[numberPokemon];
		this.team=team;
	}
	public void deadPokemon() {
		activePokemon.isdead();
		numberPokemon +=1;
		compteurDeath+=1;
		this.activePokemon=team[numberPokemon];
		
	}
	public void switchPokemon() {
		;;;
	}
	public void action (KeyEvent event,Pokedex pokedex, PokeCapacity pokeCapacity) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_P: //voir pokedex
			pokedex.toString();
		case KeyEvent.VK_C: //voir pokeCapacity
			
		case KeyEvent.VK_1: //utiliser capacit� 1
			
		case KeyEvent.VK_2: //utiliser capacit� 2
			
		case KeyEvent.VK_3: //utiliser capacit� 3
		
		case KeyEvent.VK_4: //utiliser capacit� 4
			
		case KeyEvent.VK_R: // fuir
			
		case KeyEvent.VK_S: // changer de pok�mon
	}
		System.out.println(team[0]);
	}
	public boolean lose (int compteurDeath) {
		if (compteurDeath !=5) {
			return false ;
			
		}
		System.out.println("Vous avez perdu "+ name);
		return true;
		
	}
}

