package fr.upem.dut.info.pokemonproject;

import java.io.IOException;

import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class League {
	protected BotPlayer[] league;
	private BotPlayer activeBp;
	private int numberBot=0;
	private int number =0;
	private Pokedex pokedex;
	private PokeCapacity pokeCapacity;
	public League(Pokedex pokedex,PokeCapacity pokeCapacity) {
		this.pokedex = pokedex;
		this.pokeCapacity = pokeCapacity;
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
		CapacityDamage[] capacities = null ;
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
		PokemonFight[] team = null;
		int compteur =0 ;
		while (compteur<number) {
			team[compteur]=generatePokemonFight();
			compteur+=1;
		}
		return team;
	}
	public BotPlayer generateBotPlayer(int number) throws IOException {
		number+=1;;
		
		return new BotPlayer("dresseur " + number, generateTeam(number) );
	}
}
