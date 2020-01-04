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

import fr.upem.dut.info.pokemonproject.capacity.PokeCapacity;
import fr.upem.dut.info.pokemonproject.capacity.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.Pokedex;

public class Fight {
	private Player player1;
	private Player player2;
	private Pokedex pokedex;
	private PokeCapacity pokeCapacity;
	private TypesMultiplicators tm;
	public int round =0; 
	Path path =Paths.get("backup");
	public Fight (Player player1, Player player2,Pokedex pokedex,PokeCapacity pokeCapacity,TypesMultiplicators tm) {
		this.player1=Objects.requireNonNull(player1);
		this.player2=Objects.requireNonNull(player2);
		this.tm = tm;
	}
	public void tour(String event) throws IOException {
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
		System.out.println("dzapùflzkpfl");
        // Crée un fichier texte
		try (OutputStream back = Files.newOutputStream(path);
				ObjectOutputStream out = new ObjectOutputStream(back)){
			out.writeObject(player1);
			out.writeObject(player2);
			out.writeObject(round);// sauve	rgarde}
			out.flush();
		}
    }
	public void charger() throws IOException, ClassNotFoundException {
		try( InputStream back = Files.newInputStream(path);
				ObjectInputStream in = new ObjectInputStream(back)){
			player1 = (Player) in.readObject(); 
			player2 = (Player) in.readObject();
			round = (int) in.readObject(); // recuperation}
		}
	}
}
