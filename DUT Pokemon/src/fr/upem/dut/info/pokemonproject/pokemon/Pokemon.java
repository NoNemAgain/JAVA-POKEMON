package fr.upem.dut.info.pokemonproject.pokemon;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

import fr.upem.dut.info.pokemonproject.Type;

public class Pokemon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3347003819739762398L;
	private final int number;
	protected final String name ;
	private final String path ;
	private final int height ;
	private final int weight ;
	private final Type type;
	private final Type type2;
	
	public Pokemon(int number, String name, String path, int height, int weight, Type type,Type type2) {
		if (number<0 || height <0 ||weight <0) {
			throw new IllegalArgumentException();
		}
		this.number = number;
		this.name = Objects.requireNonNull(name);
		this.path = Objects.requireNonNull(path);
		this.height = height;
		this.weight = weight;
		this.type = Objects.requireNonNull(type);
		this.type2 = type2;
	}
	public Pokemon(int number, String name, String path, int height, int weight, Type type) {
		this(number,name,path,height,weight,type,null);
	}
	public static int random(int borneInf, int borneSup) {
		/** Make a random int between a min and a max number **/
		Random random = new Random();
		int nb;
		nb = borneInf+random.nextInt(borneSup-borneInf);
		return nb;
	}
	@Override 
	public boolean equals(Object o ) {
		if(!(o instanceof Pokemon)) {
			return false; 
		}
		Pokemon p  = (Pokemon) o;
		return number==p.number && name.equals(p.name) && path.equals(p.path) && height==p.height && weight==p.weight && type.equals(p.type) && type2.equals(p.type2);
	}
	@Override
	public int hashCode() {
		return Objects.hash(number, name, path,height,weight,type,type2);
	}
	@Override
	public String toString() {
		return "Pokemon [number=" + number + ", name=" + name + ", path=" + path + ", height=" + height + ", weight="
				+ weight + ", type=" + type + ", type2=" + type2 + "]";
	}
	public String dead() {
		return name+" est mort !\n";
	}
	public Type getType() {
		return type;
	}
	public Type getType2() {
		return type2;
	}
	public String getName() {
		return name;
	}
	public PokemonFight createPokemon() {
		/** Create a PokemonFight with random stats from a basic Pokemon **/
		return new PokemonFight(number, name, path, height, weight, type, type2, 0, Pokemon.random(100,300), Pokemon.random(30,180), Pokemon.random(30,180), Pokemon.random(10, 200), Pokemon.random(10, 200), Pokemon.random(0,180));
	}
	
}
