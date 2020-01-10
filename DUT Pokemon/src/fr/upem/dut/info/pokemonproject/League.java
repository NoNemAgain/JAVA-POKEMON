package fr.upem.dut.info.pokemonproject;

import java.io.IOException;

import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.player.BotPlayer;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class League {
	private BotPlayer[] league;
	private BotPlayer activeBp;
	private int numberBot=0;
	private int number=0;
	private Pokedex pokedex = new Pokedex();
	private PokeCapacity pokeCapacity= new PokeCapacity();
	public League(int number) throws IOException {
		
		this.league=generateLeague(number);
		this.activeBp=league[numberBot];
	}
	public BotPlayer switchActiveBp() {	
		league[numberBot]=null;
		numberBot+=1;
		activeBp=league[numberBot%league.length];
		System.out.println(activeBp+" arrive sur le terrain !");
		return activeBp;
	}
	public BotPlayer getActiveBp() {
		return activeBp;
	}
	public PokemonFight generatePokemonFight () {
		int random= Pokemon.random(1, 807);
		PokemonFight pf= pokedex.getPokedex().get(random).createPokemon();
		int numberCapacity =0;
		CapacityDamage cd;
		CapacityDamage[] capacities = new CapacityDamage[4] ;
		while (numberCapacity<4) {
			cd=pokeCapacity.randomCapacityDamage();
			if (cd.canChooseCapacity(pf)){
				capacities[numberCapacity]=cd;
				numberCapacity +=1;
			}
		}
		pf.setCapacities(capacities);
		return pf;
	}
	public PokemonFight[] generateTeam(int number) {
		PokemonFight[] team = new PokemonFight[6];
		int compteur =0 ;
		while (compteur<number) {
			team[compteur]=generatePokemonFight();
			compteur+=1;
		}
		return team;
	}
	public BotPlayer generateBotPlayer(int number,int num) throws IOException {
		
		return new BotPlayer("dresseur " + num, generateTeam(number) );
	}
	public BotPlayer[] generateLeague(int number) throws IOException {
		BotPlayer[] league = new BotPlayer[number];
		int compteur =0 ;
		while (compteur<number) {
			league[compteur]=generateBotPlayer(number,compteur+1);
			compteur+=1;
		}
		return league;
	}
	public void teamString() {
		
		for(int i=0;i<league.length;i++) {
			if(league[i] != null) {
				league[i].teamString();
			}
		}
		System.out.println("\n");
	}
	
}
