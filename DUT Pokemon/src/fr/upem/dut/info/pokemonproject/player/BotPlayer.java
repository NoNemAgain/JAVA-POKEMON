package fr.upem.dut.info.pokemonproject.player;

import java.io.IOException;
import java.io.Serializable;

import fr.upem.dut.info.pokemonproject.Fight;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class BotPlayer extends AbstractPlayer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6504470861979063728L;

	public BotPlayer(String name,PokemonFight... team) throws IOException {
		super(name, team);
	}
	@Override
	public int action(String event, Pokedex pokedex, PokeCapacity pokeCapacity, TypesMultiplicators tm,
			Player oppenent, Fight f1,int round) throws IOException {
		
		switch (randomGenerateAction()) {
		case "1": //utiliser capacite 1
			if(activePokemon.getCapacity(1)!=null) {
			activePokemon.attack(oppenent.getActivePokemon(), activePokemon.getCapacity(1), tm);}
			break;
		case "2": //utiliser capacite 2
			if(activePokemon.getCapacity(2)!=null) {
			activePokemon.attack(oppenent.getActivePokemon(), activePokemon.getCapacity(2), tm);}
			break;
		case "3": //utiliser capacite 3
			if(activePokemon.getCapacity(3)!=null) {
			activePokemon.attack(oppenent.getActivePokemon(), activePokemon.getCapacity(3), tm);}
			break;
		case "4": //utiliser capacite 4
			if(activePokemon.getCapacity(4)!=null) {
			activePokemon.attack(oppenent.getActivePokemon(), activePokemon.getCapacity(4), tm);}
			break;
	
		default:
			System.out.println("Touche inconnue veuillez réessayer !\n");
			break;
		}
		oppenent.deletePokemon();
		return round+=1;
	}
	
	public String randomGenerateAction() {
		int random= Pokemon.random(0, 4);
		if (random ==0) {
			return "1";
		}
		if (random ==1) {
			return "2";
		}
		if (random ==2) {
			return "3";
		}
		else {
			return "4";
		}
		
	}
	
}
