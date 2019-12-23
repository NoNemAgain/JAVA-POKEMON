package fr.upem.dut.info.pokemonproject;

import java.awt.event.KeyEvent;
import java.util.Scanner;

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
		if(numberPokemon != 0) {
			this.activePokemon=team[numberPokemon];
		}
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
	public void changePokemon(String event) {
		switch (event) {
		case "1": //choisir le pokemon 1
			if(team[0]==null) {break;}
			switchPokemon(0);
			break;
		case "2": //choisir le pokemon 2
			if(team[1]==null) {break;}
			switchPokemon(1);
			break;
		case "3": //choisir le pokemon 3
			if(team[2]==null) {break;}
			switchPokemon(2);
			break;
		case "4": //choisir le pokemon 4
			if(team[3]==null) {break;}
			switchPokemon(3);
			break;
		case "5": //choisir le pokemon 5
			if(team[4]==null) {break;}
			switchPokemon(4);
			break;
		case "6": //choisir le pokemon 6
			if(team[5]==null) {break;}
			switchPokemon(5);
			break;
		}
	}
	public void action(String event,Pokedex pokedex, PokeCapacity pokeCapacity) {
		switch (event) {
		case "p": //voir pokedex
			System.out.println("Voici le pokedex : \n");
			System.out.println(pokedex.toString());
			break;
		case "c": //voir pokeCapacity
		
		case "pick": //pick a new pokemon from pokedex 
			pickPokemon(pokedex);
			break;
			
		case "1": //utiliser capacite 1
			
		case "2": //utiliser capacite 2
			
		case "3": //utiliser capacite 3
		
		case "4": //utiliser capacite 4
			
		case "r": // fuir
			
		case "s": // changer de pokemon
			System.out.println("===============================================================\n");
			System.out.println("Entrez un nombre pour choisir le pokemon que vous souhaitez :\n");
			String input;
			Scanner scanIn = new Scanner(System.in);
			input = scanIn.nextLine();
			scanIn.close();        
			changePokemon(input);
		default:
			System.out.println("Touche inconnue veuillez réessayer !\n");
			
	}
		StringBuilder menu = new StringBuilder();
		menu.append("Bienvenue dans le menu :\n");
		menu.append("Touche p ===> voir le pokedex\n");
		menu.append("Touche c ===> voir les capacités\n");
		menu.append("Touche pick ===> pour prendre un nouveau pokemon\n");
		menu.append("Touche 1 ===> utiliser la capacité 1\n");
		menu.append("Touche 2 ===> utiliser la capacité 2\n");
		menu.append("Touche 3 ===> utiliser la capacité 3\n");
		menu.append("Touche 4 ===> utiliser la capacité 4\n");
		menu.append("Touche r ===> fuir\n");
		menu.append("Touche s ===> changer de pokemon\n");
		System.out.println(menu.toString());
	}
	public void pickPokemon(Pokedex pokedex) {
		int count = 0;
		System.out.println("Si vous tapez des caractères autres qu'un nombre vous passerez au pokemon suivant\n");
		int numPoke;
		Scanner input = null;
		while(count<6) {
			System.out.println("Veuillez choisir votre pokemon numero "+(count+1));
			System.out.println("\nEcrivez le numero du pokemon\n");
			input = new Scanner(System.in);
			numPoke = input.nextInt();
			System.out.println(numPoke);
			PokemonFight pokemon =  pokedex.getPokedex().get(numPoke).createPokemon();
			team[count] = pokemon.createPokemon();
			count++;
		}
		input.close();
	}
	public boolean lose (int compteurDeath) {
		if (compteurDeath !=5) {
			return false ;
			
		}
		System.out.println("Vous avez perdu "+ name);
		return true;
		
	}
}

