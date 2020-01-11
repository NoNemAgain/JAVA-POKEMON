package fr.upem.dut.info.pokemonproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import fr.upem.dut.info.pokemonproject.player.BotPlayer;

public class Main {
	/**
	 * Main class it's the place where the game is supposed to start
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Fight f1 = new Fight();
		String s = "";

		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder menu = new StringBuilder();
			menu.append("Bienvenue dans le menu :\n");
			menu.append("Touche init ===> (Multi) pour initialiser des joueurs sans pokémon\n");
			menu.append("Touche init1 ===> (Multi) pour initialiser des joueurs avec pokémon\n");
			menu.append("Touche init2 ===> Battre contre la ligue DUT 1\n");
			menu.append("Touche init3 ===> Battre contre la ligue Default 1\n");
			System.out.println(menu.toString());
			while (true) {
				s = bufferRead.readLine();
				if (s.equals("init")) {
					f1 = f1.initialise2Players();
					break;
				}
				if (s.equals("init1")) {
					f1 = f1.initialise2PlayersWithPokemons();
					break;
				}
				if (s.equals("init2")) {
					f1 = f1.initiliaseLigueDUT();
					break;
				}
				if (s.equals("init3")) {
					f1 = f1.initiliaseLigueDefault();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder menu = new StringBuilder();
			menu.append("Bienvenue dans le menu :\n");
			menu.append("Touche mode ===> pour jouer avec le mode homemade\n");
			menu.append("Touche next ===> next sinon\n");
			System.out.println(menu.toString());
			while (true) {
				s = bufferRead.readLine();
				if (s.equals("mode")) {
					f1.setMode();
					break;
				}
				if (s.equals("next")) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			f1.printMenu(f1.getPlayer1());
			while (((s != null && s.equalsIgnoreCase("quit")) == false && f1.actualPlayer() != null)
					|| (s.equalsIgnoreCase("quit") == false && f1.actualPlayer() != null)) {
				if (f1.actualPlayer().isPlayer()) {
					s = bufferRead.readLine();
				} else {
					s = ((BotPlayer) f1.getPlayer2()).randomGenerateAction();
				}
				f1.tour(s);
			}
			System.out.println("Le jeu est termine !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
