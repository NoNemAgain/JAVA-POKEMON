package fr.upem.dut.info.pokemonproject;

import java.io.IOException;
import java.io.Serializable;

import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.player.BotPlayer;
import fr.upem.dut.info.pokemonproject.player.RealPlayer;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class League implements Serializable {
	/**
	 * Class League allow to create league objects in order to let the {@link RealPlayer} fight {@link BotPlayer}
	 * Used in the {@link Fight} class
	 */
	private static final long serialVersionUID = -3938419115936082958L;
	private BotPlayer[] league;
	private BotPlayer activeBp;
	private int numberBot = 0;
	private int number = 0;
	private int compteurDeath = 0;
	private Pokedex pokedex = new Pokedex();
	private PokeCapacity pokeCapacity = new PokeCapacity();

	public League(int number, int numberDresseur) throws IOException {
		this.league = generateLeagueDUT(number, numberDresseur);
		this.activeBp = league[numberBot];
	}

	public League() throws IOException {
		this.league = generateLeagueDefault();
		this.activeBp = league[numberBot];
	}

	public boolean isEmpty() {
		for (int i = 0; i < league.length; i++) {
			if (league[i] != null) {
				return false;
			}
		}
		return true;
	}

	public void deleteBot() {
		int i;
		for (i = 0; i < league.length; i++) {
			if (league[i] != null) {
				league[i] = null;
				deadBot();
			}
		}
	}

	public BotPlayer deadBot() {
		numberBot += 1;
		compteurDeath += 1;
		if (!isEmpty() && activeBp.lose()) {
			switchActiveBp(numberBot);

		}
		return activeBp;
	}

	public void switchActiveBp(int numberBot) {
		if ((numberBot <= league.length - 1) && league[numberBot] != null) {
			System.out.println(activeBp + " arrive sur le terrain !");
			activeBp = league[numberBot % league.length];

		} else {
			activeBp = null;
		}
	}
	public BotPlayer getActiveBp() {
		return activeBp;
	}

	public PokemonFight generatePokemonFight() {
		int random = Pokemon.random(1, 807);
		PokemonFight pf = pokedex.getPokedex().get(random).createPokemon();
		int numberCapacity = 0;
		CapacityDamage cd;
		CapacityDamage[] capacities = new CapacityDamage[4];
		while (numberCapacity < 4) {
			cd = pokeCapacity.randomCapacityDamage();
			if (cd.canChooseCapacity(pf)) {
				capacities[numberCapacity] = cd;
				numberCapacity += 1;
			}
		}
		pf.setCapacities(capacities);
		return pf;
	}

	public PokemonFight[] generateTeam(int numberPokemon) {
		PokemonFight[] team = new PokemonFight[6];
		int compteur = 0;
		while (compteur < numberPokemon) {
			team[compteur] = generatePokemonFight();
			compteur += 1;
		}
		return team;
	}

	public BotPlayer generateBotPlayer(int numberPokemon, int numDresseur) throws IOException {

		return new BotPlayer("dresseur " + numDresseur, generateTeam(numberPokemon));
	}

	public BotPlayer[] generateLeagueDUT(int number, int numberDresseur) throws IOException {
		BotPlayer[] league = new BotPlayer[numberDresseur];
		int compteur = 0;
		while (compteur < numberDresseur) {
			league[compteur] = generateBotPlayer(number, compteur + 1);
			compteur += 1;
		}
		return league;
	}

	public BotPlayer[] generateLeagueDefault() throws IOException {

		int compteur = 0;
		int numberPokemon = 5;
		int numberDresseur = 6;
		BotPlayer[] league = new BotPlayer[numberDresseur];
		while (compteur < numberDresseur - 1) {
			league[compteur] = generateBotPlayer(numberPokemon, compteur + 1);
			compteur += 1;
		}
		league[numberDresseur - 1] = generateBotPlayer(numberPokemon + 1, compteur + 1);
		return league;
	}

	public void teamString() {

		for (int i = 0; i < league.length; i++) {
			if (league[i] != null) {
				league[i].teamString();
			}
		}
		System.out.println("\n");
	}

}
