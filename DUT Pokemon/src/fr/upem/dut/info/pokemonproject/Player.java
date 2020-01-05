package fr.upem.dut.info.pokemonproject;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import fr.upem.dut.info.pokemonproject.capacity.Capacity;
import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7223569687102081698L;
	private final String name;
	protected PokemonFight[] team;
	protected PokemonFight activePokemon;
	protected int compteurDeath = 0;
	private int numberPokemon = 0;
	private Pokedex pokedex = new Pokedex();
	private PokeCapacity pokeCapacity = new PokeCapacity();
	
	public Player(String name,PokemonFight... team) throws IOException {
		this.name=name;
		if(team.length != 0) {
			this.activePokemon=team[numberPokemon];
		}
		else {
			this.activePokemon = null;
		}
		if (team.length ==0) {
			this.team=pickPokemon(pokedex, pokeCapacity);
		}
		else {
			this.team=team;
		}
	}
	public void switchPokemon(int numberPokemon) {	
		if((numberPokemon%5<=team.length-1) && team[numberPokemon%5] != null) {
			activePokemon=team[numberPokemon%5];
			System.out.println(activePokemon+" arrive sur le terrain !");
		}
		else {
			activePokemon=null;
		}
	}
	public void changePokemon(char input) {
		int numberPokemonIfWrong= numberPokemon;
		switch (input) {	
		case '1': //choose pokemon 1
			numberPokemon= 0;
			break;
		case '2':  //choose pokemon 2
			numberPokemon= 1;
			break;
		case '3':  //choose pokemon 3
			numberPokemon= 2;
			break;
		case '4':  //choose pokemon 4
			numberPokemon= 3;
			break;
		case '5':  //choose pokemon 5
			numberPokemon= 4;
			break;
		case '6':  //choose pokemon 6
			numberPokemon= 5;
			break;
		default:
			System.out.println("euh c'est pas bon là");
			break;
		}
		if(team[numberPokemon]!=null) {
			switchPokemon(numberPokemon);
			
		}
		else {	
			numberPokemon=numberPokemonIfWrong;
		}
	}
	public void action(String event,Pokedex pokedex, PokeCapacity pokeCapacity, TypesMultiplicators tm,Player oppenent,Fight f1) throws IOException {
		switch (event) {
		case "p": //show pokedex
			System.out.println("Voici le pokedex : \n");
			System.out.println(pokedex);
			break;
		case "c": //show pokeCapacity
			System.out.println("Voici l'ensemble des capacites : \n");
			System.out.println(pokeCapacity);
			break;
		case "t":
			teamString();
			break;
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
			break;
		default:
			System.out.println("Touche inconnue veuillez réessayer !\n");
			break;
		}
		oppenent.deletePokemon();
		printMenu(oppenent);
		lose();
	}
	public void printMenu(Player opp) {
		StringBuilder menu = new StringBuilder();
		menu.append("Bienvenue dans le menu "+opp.getName()+":\n");
		menu.append("Touche p ===> voir le pokedex\n");
		menu.append("Touche c ===> voir les capacités\n");
		menu.append("Touche t ===> pour voir votre équipe\n");
		menu.append("Touche 1 ===> utiliser la capacité 1\n");
		menu.append("Touche 2 ===> utiliser la capacité 2\n");
		menu.append("Touche 3 ===> utiliser la capacité 3\n");
		menu.append("Touche 4 ===> utiliser la capacité 4\n");
		menu.append("Touche r ===> fuir\n");
		menu.append("Touche s ===> changer de pokemon\n");
		menu.append("Touche sauv ===> pour sauvegarder\n");
		System.out.println(menu.toString());
	}
	public PokemonFight[] pickPokemon(Pokedex pokedex,PokeCapacity pokeCapacity) {
		int count = 0;
		PokemonFight[] teams = new PokemonFight[6];
		System.out.println("Si vous tapez des caractères autres qu'un nombre vous passerez au pokemon suivant\n");
		int numPoke;
		Scanner input = null;
		 //ask the user to pick pokemons
		while(count<6) {
			System.out.println("Veuillez choisir votre pokemon numero "+(count+1));
			System.out.println("\nEcrivez le numero du pokemon\n");
			input = new Scanner(System.in);
			if(!input.hasNextInt() && input.next().equals("quit")) { break;}
			if(input.hasNextInt()) {
				numPoke = input.nextInt();
			}
			else {
				continue;
			}
			if(numPoke<0 || numPoke>807) { }
			else {
				Pokemon poke = pokedex.getPokedex().get(numPoke);
				PokemonFight pokemon =  poke.createPokemon();
				pokemon.setCapacities(pickCapacitiy(pokemon,pokeCapacity));
				System.out.println(pokemon);
				teams[count] = pokemon;
				if(count==0) {activePokemon = teams[count]; }
				count++;
			}
		}
		return teams;
	}
	public CapacityDamage[] pickCapacitiy(PokemonFight pokemon,PokeCapacity pokeCapacity) {
		int count = 0;
		CapacityDamage[] capacities = new CapacityDamage[4];
		System.out.println("Si vous tapez des caractères autres qu'un nombre vous passerez a la capacité suivante\n");
		String nameCapa = null;
		Scanner input = null;
		while(count<4 || nameCapa.equals("quit")) {
			System.out.println("Veuillez choisir votre capacité numero "+(count+1));
			System.out.println("\nEcrivez le nom de la capacité\n");
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
	public boolean lose() {
		if (compteurDeath ==team.length || activePokemon == null) {
			System.out.println("Vous avez perdu "+ name);
			return true;
		}
		else {
			return false;
		}
	}
	public void deadPokemon() {
		numberPokemon+=1;
		compteurDeath+=1;
		if(!lose()) {
			switchPokemon(numberPokemon);
		}
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
	public void teamString() {
		System.out.println("Equipe de "+name+" : \n");
		for(int i=0;i<team.length;i++) {
			if(team[i] != null) {
				System.out.println("("+(i+1)+") "+team[i].getName()+" HP : "+team[i].getHp()+" || Capacités : "+ team[i].getCapacities());
			}
		}
		System.out.println("\n");
	}
	public void sauvegarder(Fight f1) throws IOException {
		f1.sauvegarder();
	}
	public PokemonFight getActivePokemon() {
		return activePokemon;
	}
	public String getName() {
		return name;
	}
}