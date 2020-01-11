package fr.upem.dut.info.pokemonproject.player;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import fr.upem.dut.info.pokemonproject.Fight;
import fr.upem.dut.info.pokemonproject.capacity.Capacity;
import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public abstract class AbstractPlayer implements Player, Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -5227016998938907053L;
	private final String name;
	protected PokemonFight[] team;
	protected PokemonFight activePokemon;
	protected int compteurDeath = 0;
	private int numberPokemon = 0;
	private Pokedex pokedex = new Pokedex();
	private PokeCapacity pokeCapacity = new PokeCapacity();

	public AbstractPlayer(String name, PokemonFight... team) throws IOException {
		this.name = name;
		if (team.length != 0) {
			this.activePokemon = team[numberPokemon];
		} else {
			this.activePokemon = null;
		}
		if (team.length == 0) {
			this.team = pickPokemon(pokedex, pokeCapacity);
		} else {
			this.team = team;
		}
	}

	public void switchPokemon(int numberPokemon) {
		if ((numberPokemon % 5 <= team.length - 1) && team[numberPokemon % 5] != null) {
			activePokemon = team[numberPokemon % 5];
			System.out.println(activePokemon + " arrive sur le terrain !");
		} else {
			activePokemon = null;
		}
	}

	public void mode(boolean mode, Player oppenent) {
		if (mode) {
			String s = "" + Pokemon.random(1, 6);
			oppenent.changePokemon(s.charAt(0));
		}
	}

	public void changePokemon(char input) {
		int numberPokemonIfWrong = numberPokemon;
		switch (input) {
		case '1': // choose pokemon 1
			numberPokemon = 0;
			break;
		case '2': // choose pokemon 2
			numberPokemon = 1;
			break;
		case '3': // choose pokemon 3
			numberPokemon = 2;
			break;
		case '4': // choose pokemon 4
			numberPokemon = 3;
			break;
		case '5': // choose pokemon 5
			numberPokemon = 4;
			break;
		case '6': // choose pokemon 6
			numberPokemon = 5;
			break;
		default:
			System.out.println("euh c'est pas bon la");
			break;
		}
		if (team.length - 1 >= numberPokemon && team[numberPokemon] != null) {
			switchPokemon(numberPokemon);
		} else {
			numberPokemon = numberPokemonIfWrong;
		}
	}

	public abstract int action(String event, Pokedex pokedex, PokeCapacity pokeCapacity, TypesMultiplicators tm,
			Player oppenent, Fight f1, int round, boolean mode) throws IOException, ClassNotFoundException;

	public boolean lose() {
		if (compteurDeath == team.length || activePokemon == null) {
			System.out.println("Vous avez perdu " + name);
			return true;
		} else {
			return false;
		}
	}

	public void deadPokemon() {
		numberPokemon += 1;
		compteurDeath += 1;
		if (!lose()) {
			switchPokemon(numberPokemon);
		}
	}

	public void deletePokemon() {
		int i;
		for (i = 0; i < team.length; i++) {
			if (team[i] != null && team[i].isDead()) {
				team[i] = null;
				deadPokemon();
			}
		}
	}

	public void teamString() {
		System.out.println("Equipe de " + name + " : \n");
		for (int i = 0; i < team.length; i++) {
			if (team[i] != null) {
				System.out.println("(" + (i + 1) + ") " + team[i].getName() + " HP : " + team[i].getHp()
						+ " || Capacites : " + team[i].getCapacities());
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

	public PokemonFight[] pickPokemon(Pokedex pokedex, PokeCapacity pokeCapacity) {
		int count = 0;
		PokemonFight[] teams = new PokemonFight[6];
		int numPoke;
		Scanner input = null;
		// ask the user to pick pokemons
		while (count < 6) {
			System.out.println("Veuillez choisir votre pokemon numero " + (count + 1));
			System.out.println("\nEcrivez le numero du pokemon ( 'quit' pour arreter )\n");
			input = new Scanner(System.in);
			if (!input.hasNextInt() && input.next().equals("quit")) {
				break;
			}
			if (input.hasNextInt()) {
				numPoke = input.nextInt();
			} else {
				continue;
			}
			if (numPoke < 0 || numPoke > 807) {
			} else {
				Pokemon poke = pokedex.getPokedex().get(numPoke);
				PokemonFight pokemon = poke.createPokemon();
				pokemon.setCapacities(pickCapacitiy(pokemon, pokeCapacity));
				System.out.println(pokemon);
				teams[count] = pokemon;
				if (count == 0) {
					activePokemon = teams[count];
				}
				count++;
			}
		}
		return teams;
	}

	public CapacityDamage[] pickCapacitiy(PokemonFight pokemon, PokeCapacity pokeCapacity) {
		int count = 0;
		CapacityDamage[] capacities = new CapacityDamage[4];
		String nameCapa = null;
		Scanner input = null;
		while (count < 4 || nameCapa.equals("quit")) {
			System.out.println("Veuillez choisir votre capacite numero " + (count + 1));
			System.out.println("\nEcrivez le nom de la capacite ( 'quit' pour arreter )\n");
			input = new Scanner(System.in);
			nameCapa = input.next();
			if (nameCapa.equals("quit")) {
				break;
			}
			if (pokeCapacity.getCapacities().containsKey(nameCapa)) {
				Capacity poke = pokeCapacity.getCapacities().get(nameCapa);
				if (poke.canChooseCapacity(pokemon)) {
					capacities[count] = (CapacityDamage) poke;
					count++;
				}
			}
		}
		return capacities;
	}

	public boolean isPlayer() {
		return true;
	}

	@Override
	public String toString() {
		return "AbstractPlayer [name=" + name + ", team=" + Arrays.toString(team) + ", activePokemon=" + activePokemon
				+ "]";
	}

}
