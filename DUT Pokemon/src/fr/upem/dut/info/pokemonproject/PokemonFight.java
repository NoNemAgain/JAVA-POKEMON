package fr.upem.dut.info.pokemonproject;

public class PokemonFight extends Pokemon{
		private static int id = 0;
		private float exp ;
		private int pv ;
		private int attack;
		private int attackSpe;
		private int defense;
		private int defenseSpe;
		private int speed;
		private final Capacity[] capacities;
	public PokemonFight(int number, String name, String path, int height, int weight,Type type,Type type2,int exp,int pv,int attack,int attackSpe,int defense,int defenseSpe,int speed,Capacity... capacities) throws IllegalAccessException {
		super(number, name, path, height, weight, type);
		if (exp<0||pv<0||attack<0||attackSpe<0||defense<0||defenseSpe<0||speed<0 || capacities[0] == null || capacities[4] != null) {
			throw new IllegalAccessException();
		}
		id++;
		this.exp=exp;
		this.pv=pv;
		this.attack=attack;
		this.attackSpe=attackSpe;
		this.defense=defense;
		this.defenseSpe=defenseSpe;
		this.speed=speed;
		this.capacities=capacities;
	}

}
