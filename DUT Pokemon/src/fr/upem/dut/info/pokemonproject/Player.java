package fr.upem.dut.info.pokemonproject;

import java.io.IOException;
import java.util.Scanner;
import fr.upem.dut.info.pokemonproject.capacity.Capacity;
import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.capacity.PokeCapacity;
import fr.upem.dut.info.pokemonproject.capacity.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.Pokedex;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class Player {
	private final String name ;
	private PokemonFight[] team;
	private PokemonFight activePokemon ;
	private int compteurDeath = 0;
	private int numberPokemon = 0;
	private Pokedex pokedex = new Pokedex();
	private PokeCapacity pokeCapacity = new PokeCapacity();
	
	public Player(String name,PokemonFight... team) throws IOException {
		this.name=name;
		this.numberPokemon = team.length;
		if(numberPokemon != 0) {
			this.activePokemon=team[numberPokemon-1];
		}
		else {
			this.activePokemon = null;
		}
		this.team=pickPokemon(pokedex, pokeCapacity);
	}
	public void deadPokemon() {
		numberPokemon +=1;
		compteurDeath+=1;
		switchPokemon(numberPokemon);
	}
	public void switchPokemon(int numberPokemon) {
		activePokemon=team[numberPokemon%5];
		System.out.println(activePokemon+" arrive sur le terrain !");
	}
	public void changePokemon(char input) {
		switch (input) {
		case '1': //choisir le pokemon 1
			if(team[0]==null) {break;}
			switchPokemon(0);
			break;
		case '2': //choisir le pokemon 2
			if(team[1]==null) {break;}
			switchPokemon(1);
			break;
		case '3': //choisir le pokemon 3
			if(team[2]==null) {break;}
			switchPokemon(2);
			break;
		case '4': //choisir le pokemon 4
			if(team[3]==null) {break;}
			switchPokemon(3);
			break;
		case '5': //choisir le pokemon 5
			if(team[4]==null) {break;}
			switchPokemon(4);
			break;
		case '6': //choisir le pokemon 6
			if(team[5]==null) {break;}
			switchPokemon(5);
			break;
		default:
			System.out.println("euh c'est pas bon l�");
			break;
		}
	}
	public void action(String event,Pokedex pokedex, PokeCapacity pokeCapacity, TypesMultiplicators tm,Player oppenent) {
		StringBuilder menu = new StringBuilder();
		menu.append("Bienvenue dans le menu :\n");
		menu.append("Touche p ===> voir le pokedex\n");
		menu.append("Touche c ===> voir les capacit�s\n");
		menu.append("Touche 1 ===> utiliser la capacit� 1\n");
		menu.append("Touche 2 ===> utiliser la capacit� 2\n");
		menu.append("Touche 3 ===> utiliser la capacit� 3\n");
		menu.append("Touche 4 ===> utiliser la capacit� 4\n");
		menu.append("Touche r ===> fuir\n");
		menu.append("Touche s ===> changer de pokemon\n");
		switch (event) {
		case "p": //voir pokedex
			System.out.println("Voici le pokedex : \n");
			System.out.println(pokedex.toString());
			break;
		case "c": //voir pokeCapacity
			
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
		case "r": // fuir
			
		case "s": // changer de pokemon
			System.out.println("===============================================================\n");
			System.out.println("Entrez un nombre pour choisir le pokemon que vous souhaitez :\n");
			char input;
			Scanner scanIn = new Scanner(System.in);
			input = scanIn.nextLine().charAt(0);
			changePokemon(input);
			break;
		default:
			System.out.println("Touche inconnue veuillez r�essayer !\n");
			break;
		}
		oppenent.deletePokemon();
		System.out.println(menu.toString());
	}
	public PokemonFight[] pickPokemon(Pokedex pokedex,PokeCapacity pokeCapacity) {
		int count = 0;
		PokemonFight[] teams = new PokemonFight[6];
		System.out.println("Si vous tapez des caract�res autres qu'un nombre vous passerez au pokemon suivant\n");
		int numPoke;
		Scanner input = null;
		while(count<6) {
			System.out.println("Veuillez choisir votre pokemon numero "+(count+1));
			System.out.println("\nEcrivez le numero du pokemon\n");
			input = new Scanner(System.in);
			if(!input.hasNextInt() && input.next().equals("quit")) { break;}
			numPoke = input.nextInt();
			if(numPoke<0 || numPoke>807) { }
			else {
				Pokemon poke = pokedex.getPokedex().get(numPoke);
				PokemonFight pokemon =  poke.createPokemon();
				pokemon.setCapacities(pickCapacitiy(pokemon,pokeCapacity));
				System.out.println(pokemon);
				teams[count] = pokemon;
				count++;
			}
		}
		return teams;
	}
	public CapacityDamage[] pickCapacitiy(PokemonFight pokemon,PokeCapacity pokeCapacity) {
		int count = 0;
		CapacityDamage[] capacities = new CapacityDamage[4];
		System.out.println("Si vous tapez des caract�res autres qu'un nombre vous passerez a la capacit� suivante\n");
		String nameCapa = null;
		Scanner input = null;
		while(count<4 || nameCapa.equals("quit")) {
			System.out.println("Veuillez choisir votre capacit� numero "+(count+1));
			System.out.println("\nEcrivez le nom de la capacit�\n");
			input = new Scanner(System.in);
			nameCapa = input.next();
			if(nameCapa.equals("quit")) { break; }
			if(pokeCapacity.getCapacities().containsKey(nameCapa)) {
				Capacity poke = pokeCapacity.getCapacities().get(nameCapa);
				if(poke.canChooseCapacity(pokemon)) {
					capacities[count] = (CapacityDamage) poke;
					count++;
				}
			}
		}
		return capacities;
	}
	public boolean lose (int compteurDeath) {
		if (compteurDeath !=5) {
			return false;
		}
		System.out.println("Vous avez perdu "+ name);
		return true;
	}
	public PokemonFight getActivePokemon() {
		return activePokemon;
	}
	public void deletePokemon() {
		int i;
		for(i=0;i<team.length;i++) {
			if(team[i]!=null && team[i].isDead()) {
				team[i]=null;
				deadPokemon();
			}
		}
	}
}