package fr.upem.dut.info.pokemonproject;

import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Fight {
	private Player player1;
	private Player player2;
	private Pokedex pokedex;
	private PokeCapacity pokeCapacity;
	public int round =0; 
	Path path =Paths.get("backup");
	public Fight (Player player1, Player player2,Pokedex pokedex,PokeCapacity pokeCapacity) {
		this.player1=Objects.requireNonNull(player1);
		this.player2=Objects.requireNonNull(player2);
		
	}
	public void tour(KeyEvent event) {
		if (round %2==0) {
			player1.action(event,pokedex,pokeCapacity);
		}
		else {
			player2.action(event,pokedex,pokeCapacity);
		}
		round+=1;;;
		
	}
	public void sauvegarder() throws IOException
    {
        // Crée un fichier texte
		try (OutputStream back = Files.newOutputStream(path);
				ObjectOutputStream out = new ObjectOutputStream(back)){
			out.writeObject(player1);
			out.writeObject(player2);
			out.writeObject(round);// sauvergarde}ddazd
		}
    }
	public void charger() throws IOException, ClassNotFoundException 
	{
		try( InputStream back = Files.newInputStream(path);
				ObjectInputStream in = new ObjectInputStream(back)){
			player1 = (Player) in.readObject(); 
			player2 = (Player) in.readObject();
			round = (int) in.readObject(); // recuperation}
		}
	}
}
