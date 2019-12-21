package fr.upem.dut.info.pokemonproject;

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
	public int round =0; 
	Path path =Paths.get("backup");
	public Fight (Player player1, Player player2) {
		this.player1=Objects.requireNonNull(player1);
		this.player2=Objects.requireNonNull(player2);
		
	}
	public void tour() {
		if (round %2==0) {
			player1.action();
		}
		else {
			player2.action();
		}
		round+=1;
		
	}
	public void sauvegarder() throws IOException
    {
        // Cr�e un fichier texte
		try (OutputStream back = Files.newOutputStream(path);
				ObjectOutputStream out = new ObjectOutputStream(back)){
			out.writeObject(player1);
			out.writeObject(player2);
			out.writeObject(round);// sauvergarde}
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
