package fr.upem.dut.info.pokemonproject;

public class PokemonFight extends Pokemon{
		private Capacity capacity1;
		private Capacity capacity2;
		private Capacity capacity3;
		private Capacity capacity4;
		private static int id = 0;
		private float exp ;
		private int pv ;
		private int attack;
		private int attackSpe;
		private int defense;
		private int defenseSpe;
		private int speed;
	public PokemonFight(int number, String name, String path, int height, int weight, Type type,Capacity capacity1,Capacity capacity2,Capacity capacity3,Capacity capacity4,int exp,int pv,int attack,int attackSpe,int defense,int defenseSpe,int speed) throws IllegalAccessException {
		super(number, name, path, height, weight, type);
		if (exp<0||pv<0||attack<0||attackSpe<0||defense<0||defenseSpe<0||speed<0) {
			throw new IllegalAccessException();
		}
		this.capacity1=capacity1;
		this.capacity2=capacity2;
		this.capacity3=capacity3;
		this.capacity4=capacity4;
		id++;
		this.exp=exp;
		this.pv=pv;
		this.attack=attack;
		this.attackSpe=attackSpe;
		this.defense=defense;
		this.defenseSpe=defenseSpe;
		this.speed=speed;
	}

}
