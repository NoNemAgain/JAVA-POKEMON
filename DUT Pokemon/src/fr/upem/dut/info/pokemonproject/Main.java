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
		Pokedex pokedex = new Pokedex();
		TypesMultiplicators tm =new TypesMultiplicators();
		PokeCapacity pokeCapacity = new PokeCapacity();
		/*CapacityDamage cut  = pokeCapacity.getCapacities().get("cut");
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
		System.out.println(pokedex);
		System.out.println(pokeCapacity);
		Player p1 = new Player("Albert",poke1,poke2);
		Player p2 = new Player("Jean",poke3,poke4);*/
		Player p1 = new Player("Albert");
		Player p2 = new Player("Jean");
		Fight f1 = new Fight(p1, p2, pokedex, pokeCapacity,tm);
	    String s = "";
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder menu = new StringBuilder();
			menu.append("Bienvenue dans le menu :\n");
			menu.append("Touche charg ===> pour charger\n");
			menu.append("Touche jouer ===> pour jouer\n");
			System.out.println(menu.toString());
		    while ((s!=null && s.equalsIgnoreCase("jouer")) == false ||  s.equalsIgnoreCase("jouer")==false) {
		    	s = bufferRead.readLine();
		    	if(s.equals("charg")) {
		    		f1.charger();
		    		System.out.println("chargement avec succès !");
		    	}
		    }
		}
		catch(IOException e)
		{
		    e.printStackTrace();
		}
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
    		StringBuilder menu = new StringBuilder();
    		menu.append("Bienvenue dans le menu du joueur 1 :\n");
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
    		System.out.println(menu.toString());
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
