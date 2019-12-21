package fr.upem.dut.info.pokemonproject;

import java.awt.event.KeyEvent;

import fr.upem.dut.info.pokemonproject.capacity.PokeCapacity;
import fr.upem.dut.info.pokemonproject.pokemon.Pokedex;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

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
		switchPokemon(numberPokemon);
		
		
	}
	public void switchPokemon(int numberPokemon) {
		activePokemon=team[numberPokemon];
	}
	public void choosePokemon(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_1: //choisir le pokemon 1
			if(team[0]==null) {break;}
			switchPokemon(0);
			break;
		case KeyEvent.VK_2: //choisir le pokemon 2
			if(team[1]==null) {break;}
			switchPokemon(1);
			break;
		case KeyEvent.VK_3: //choisir le pokemon 3
			if(team[2]==null) {break;}
			switchPokemon(2);
			break;
		case KeyEvent.VK_4: //choisir le pokemon 4
			if(team[3]==null) {break;}
			switchPokemon(3);
			break;
		case KeyEvent.VK_5: //choisir le pokemon 5
			if(team[4]==null) {break;}
			switchPokemon(4);
			break;
		case KeyEvent.VK_6: //choisir le pokemon 6
			if(team[5]==null) {break;}
			switchPokemon(5);
			break;
	}
	}
	public void action (KeyEvent event,Pokedex pokedex, PokeCapacity pokeCapacity) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_P: //voir pokedex
			pokedex.toString();
		case KeyEvent.VK_C: //voir pokeCapacity
			
		case KeyEvent.VK_1: //utiliser capacité 1
			
		case KeyEvent.VK_2: //utiliser capacité 2
			
		case KeyEvent.VK_3: //utiliser capacité 3
		
		case KeyEvent.VK_4: //utiliser capacité 4
			
		case KeyEvent.VK_R: // fuir
			
		case KeyEvent.VK_S: // changer de pokémon
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

