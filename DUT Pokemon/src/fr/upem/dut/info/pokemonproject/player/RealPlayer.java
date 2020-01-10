package fr.upem.dut.info.pokemonproject.player;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import fr.upem.dut.info.pokemonproject.Fight;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class RealPlayer extends AbstractPlayer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7223569687102081698L;

	
	public RealPlayer(String name,PokemonFight... team) throws IOException {
		super(name,team);
	}
	public int action(String event,Pokedex pokedex, PokeCapacity pokeCapacity, TypesMultiplicators tm,Player oppenent,Fight f1,int round) throws IOException, ClassNotFoundException {
		switch (event) {
		case "p": //show pokedex
			System.out.println("Voici le pokedex : \n");
			System.out.println(pokedex);
			f1.printMenu(this);
			return round;
		case "c": //show pokeCapacity
			System.out.println("Voici l'ensemble des capacites : \n");
			System.out.println(pokeCapacity);
			f1.printMenu(this);
			return round;
		case "m": //show menu
			f1.printMenu(this);
			return round;
		case "t":
			teamString();
			f1.printMenu(this);
			return round;
		case "1": //use capacity 1
			if(activePokemon.getCapacity(1)!=null) {
			activePokemon.attack(oppenent.getActivePokemon(), activePokemon.getCapacity(1), tm);}
			break;
		case "2": //use capacity 2
			if(activePokemon.getCapacity(2)!=null) {
			activePokemon.attack(oppenent.getActivePokemon(), activePokemon.getCapacity(2), tm);}
			break;
		case "3": //use capacity 3
			if(activePokemon.getCapacity(3)!=null) {
			activePokemon.attack(oppenent.getActivePokemon(), activePokemon.getCapacity(3), tm);}
			break;
		case "4": //use capacity 4
			if(activePokemon.getCapacity(4)!=null) {
			activePokemon.attack(oppenent.getActivePokemon(), activePokemon.getCapacity(4), tm);}
			break;
		case "r": //flee
			compteurDeath = team.length;
			break;
		case "charg" :
	    		f1.charger();
	    		System.out.println("chargement avec succès !");
	    		return round;
		case "s": //change pokemon
			System.out.println("===============================================================\n");
			System.out.println("Entrez un nombre pour choisir le pokemon que vous souhaitez :\n");
			teamString();
			char input;
			Scanner scanIn = new Scanner(System.in);
			input = scanIn.nextLine().charAt(0);
			changePokemon(input);
			break;
		case "sauv":
			sauvegarder(f1);
			f1.printMenu(this);
			return round;
		default:
			System.out.println("Touche inconnue veuillez reessayer !\n");
			f1.printMenu(this);
			return round;
		}
		oppenent.deletePokemon();
		lose();
		f1.printMenu(oppenent);
		return round+=1;
	}
}