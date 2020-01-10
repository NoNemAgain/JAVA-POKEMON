package fr.upem.dut.info.pokemonproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class Fight {
	private Player player1;
	private Player player2;
	private Pokedex pokedex;
	private PokeCapacity pokeCapacity;
	private TypesMultiplicators tm;
	private int round =0; 
	private boolean mode =false;
	Path path =Paths.get("src/fr/upem/dut/info/pokemonproject/source/backup");
	private League league ;
	public Fight (Player player1, Player player2,Pokedex pokedex,PokeCapacity pokeCapacity,TypesMultiplicators tm) {
		this.player1=Objects.requireNonNull(player1);
		this.player2=Objects.requireNonNull(player2);
		this.tm = tm;
		this.pokedex = pokedex;
		this.pokeCapacity = pokeCapacity;
	}
	public Fight() {
		super();
	}
	public Fight (Player player1,Pokedex pokedex,PokeCapacity pokeCapacity,TypesMultiplicators tm,League league) {
		super();
		setPlayer2(league.getActiveBp());
		
	}
	public Player getPlayer1() {
		return player1;
	}
	
	
	public void tour(String event) throws IOException, ClassNotFoundException {
		//User interact with the program
		if (round %2==0&&(!(end()))) {
			round = player1.action(event,pokedex,pokeCapacity,tm, player2,this,round);
			return;
		}
		if(round %2!=0&& (!end())){
			round = player2.action(event,pokedex,pokeCapacity,tm, player1,this,round);
			return;
		}
		
		
	}
	public boolean end() {
		if (player1.lose()||player2.lose()) {
			return true;
		}
		return false;
	}
	public boolean getMode() {
		return getMode();
	}
	public void sauvegarder() throws IOException{
		// Create a file
		try (OutputStream back = Files.newOutputStream(path);
				ObjectOutputStream out = new ObjectOutputStream(back)){
			out.writeObject(player1);
			out.writeObject(player2);
			out.writeObject(round);// save}
			/*if (league != null){
				out.writeObject(league);
			}*/
		}
    }
	public void charger() throws IOException, ClassNotFoundException {
		try( InputStream back = Files.newInputStream(path);
				ObjectInputStream in = new ObjectInputStream(back)){
			player1 = (Player) in.readObject(); 
			player2 = (Player) in.readObject();
			round = (int) in.readObject(); // load}
			/*if ((League)in.readObject() != null) {
				league =(League) in.readObject() ;
			}*/
		}
	}
	public void setPlayer2(BotPlayer bp) {
		player2=bp;
	}
	
	public void switchBot() {
		if(player2.lose()) {
			league.switchActiveBp();
			round= 0 ;
		}
	}
	public void dataBase() throws IOException {
		Pokedex pokedex =new Pokedex ();
		PokeCapacity pokeCapacity =new PokeCapacity();
		TypesMultiplicators tm =new TypesMultiplicators();
	}
	public Fight initialise2Players () throws IOException {
		Pokedex pokedex =new Pokedex ();
		PokeCapacity pokeCapacity =new PokeCapacity();
		TypesMultiplicators tm =new TypesMultiplicators();
		Player p1 = new Player("Albert");
		Player p2 = new Player("Jean");
		return new Fight(p1, p2, pokedex, pokeCapacity,tm);
	}
	public Fight initialise2PlayersWithPokemons () throws IOException {
		Pokedex pokedex =new Pokedex ();
		PokeCapacity pokeCapacity =new PokeCapacity();
		TypesMultiplicators tm =new TypesMultiplicators();
		CapacityDamage cut  = pokeCapacity.getCapacities().get("cut");
		CapacityDamage pound  = pokeCapacity.getCapacities().get("pound");
		CapacityDamage doubleSlap  = pokeCapacity.getCapacities().get("double-slap");
		CapacityDamage[] capacityDamages = {cut,pound,doubleSlap};
		PokemonFight poke1 = pokedex.getPokedex().get(1).createPokemon();
		PokemonFight poke2 = pokedex.getPokedex().get(2).createPokemon();
		PokemonFight poke3 = pokedex.getPokedex().get(3).createPokemon();
		PokemonFight poke4 = pokedex.getPokedex().get(4).createPokemon();
		poke1.setCapacities(capacityDamages);
		poke2.setCapacities(capacityDamages);
		poke3.setCapacities(capacityDamages);
		poke4.setCapacities(capacityDamages);
		Player p1 = new Player("Albert",poke1,poke2);
		Player p2 = new Player("Jean",poke3,poke4);
		return new Fight(p1, p2, pokedex, pokeCapacity,tm);
	}
	public void printMenu(Player opp) {
		StringBuilder menu = new StringBuilder();
		menu.append("Bienvenue dans le menu "+opp.getName()+":\n");
		menu.append("Touche p ===> voir le pokedex\n");
		menu.append("Touche c ===> voir les capacites\n");
		menu.append("Touche t ===> pour voir votre equipe\n");
		menu.append("Touche 1 ===> utiliser la capacite 1\n");
		menu.append("Touche 2 ===> utiliser la capacite 2\n");
		menu.append("Touche 3 ===> utiliser la capacite 3\n");
		menu.append("Touche 4 ===> utiliser la capacite 4\n");
		menu.append("Touche r ===> fuir\n");
		menu.append("Touche s ===> changer de pokemon\n");
		menu.append("Touche sauv ===> pour sauvegarder\n");
		menu.append("Touche m ===> pour menu\n");
		menu.append("Touche charg ===> pour charger\n");
		System.out.println(menu.toString());
	}
}
