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

import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;

public class Fight {
	private Player player1;
	private Player player2;
	private Pokedex pokedex;
	private PokeCapacity pokeCapacity;
	private TypesMultiplicators tm;
	public int round =0; 
	Path path =Paths.get("src/fr/upem/dut/info/pokemonproject/source/backup");
	private League league ;
	public Fight (Player player1, Player player2,Pokedex pokedex,PokeCapacity pokeCapacity,TypesMultiplicators tm) {
		this.player1=Objects.requireNonNull(player1);
		this.player2=Objects.requireNonNull(player2);
		this.tm = tm;
		this.pokedex = pokedex;
		this.pokeCapacity = pokeCapacity;
	}
	public Fight (Player player1,Pokedex pokedex,PokeCapacity pokeCapacity,TypesMultiplicators tm,League league) {
		super();
		setPlayer2(league.getActiveBp());
		
	}
	
	public void tour(String event) throws IOException {
		//User interact with the program
		if (round %2==0&&(!(end()))) {
			player1.action(event,pokedex,pokeCapacity,tm, player2,this);
		}
		if (round %2!=0&& (!end())){
			player2.action(event,pokedex,pokeCapacity,tm, player1,this);
		}
		round+=1;
	}
	public boolean end() {
		if (player1.lose()||player2.lose()) {
			return true;
		}
		return false;
	}
	public void sauvegarder() throws IOException{
		// Create a file
		try (OutputStream back = Files.newOutputStream(path);
				ObjectOutputStream out = new ObjectOutputStream(back)){
			out.writeObject(player1);
			out.writeObject(player2);
			out.writeObject(round);// save}
			if (league != null){
				out.writeObject(league);
			}
		}
    }
	public void charger() throws IOException, ClassNotFoundException {
		try( InputStream back = Files.newInputStream(path);
				ObjectInputStream in = new ObjectInputStream(back)){
			player1 = (Player) in.readObject(); 
			player2 = (Player) in.readObject();
			round = (int) in.readObject(); // load}
			if ((League)in.readObject() != null) {
				league =(League) in.readObject() ;
			}
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
	;
}
