package fr.upem.dut.info.pokemonproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.upem.dut.info.pokemonproject.capacity.PokeCapacity;
import fr.upem.dut.info.pokemonproject.capacity.TypesMultiplicators;
import fr.upem.dut.info.pokemonproject.pokemon.Pokedex;


public class Main {

	public static void main(String[] args) throws IOException {
		Pokedex pokedex = new Pokedex();
		TypesMultiplicators tm =new TypesMultiplicators();
		PokeCapacity pokeCapacity = new PokeCapacity();
		Player p1 = new Player("Albert");
		
	    String s = null;
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
    		StringBuilder menu = new StringBuilder();
    		menu.append("Bienvenue dans le menu :\n");
    		menu.append("Touche p ===> voir le pokedex\n");
    		menu.append("Touche c ===> voir les capacités\n");
    		menu.append("Touche 1 ===> utiliser la capacité 1\n");
    		menu.append("Touche 2 ===> utiliser la capacité 2\n");
    		menu.append("Touche 3 ===> utiliser la capacité 3\n");
    		menu.append("Touche 4 ===> utiliser la capacité 4\n");
    		menu.append("Touche r ===> fuir\n");
    		menu.append("Touche s ===> changer de pokemon\n");
    		System.out.println(menu.toString());
            while ((s!=null && s.equalsIgnoreCase("quit")) == false ||  s.equalsIgnoreCase("quit")==false) {
            	s = bufferRead.readLine();
            	p1.action(s, pokedex, pokeCapacity);
            }

            System.out.println("Le jeu est terminé !");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

		
	}

}
