package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public class Fight {
	private Player player1;
	private Player player2;
	public int round =0; 
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
}
