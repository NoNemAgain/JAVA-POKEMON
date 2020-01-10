package fr.upem.dut.info.pokemonproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.PokeCapacity;
import fr.upem.dut.info.pokemonproject.loader.Pokedex;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		
		
		
		Fight f1 = new Fight();
		
	    String s = "";
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder menu = new StringBuilder();
			menu.append("Bienvenue dans le menu :\n");
			menu.append("Touche charg ===> pour charger\n");
			menu.append("Touche jouer ===> pour jouer\n");
			menu.append("Touche init ===> pour initialiser des joueurs sans pokémon\n");
			menu.append("Touche init1 ===> pour initialiser des joueurs avec pokémon\n");
			System.out.println(menu.toString());
		    while ((s!=null && s.equalsIgnoreCase("jouer")) == false ||  s.equalsIgnoreCase("jouer")==false ) {
		    	s = bufferRead.readLine();
		    	if(s.equals("charg")) {
		    		f1.charger();
		    		System.out.println("chargement avec succès !");
		    	}
		    	if(s.equals("init")) {
		    		f1=f1.initialise2Players();
		    	}
		    	if(s.equals("init1")) {
		    		 f1=f1.initialise2PlayersWithPokemons();
		    	}
		    }
		}
		catch(IOException e)
		{
		    e.printStackTrace();
		}
        try{
           BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
           f1.printMenu(f1.getPlayer1());
            while ((s!=null && s.equalsIgnoreCase("quit")) == false ||  s.equalsIgnoreCase("quit")==false) {
            	s = bufferRead.readLine();
            	f1.tour(s);
            }
            System.out.println("Le jeu est termine !");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

	}
}
