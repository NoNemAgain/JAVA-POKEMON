package fr.upem.dut.info.pokemonproject.pokemon;

import java.util.Objects;
import java.util.Random;

import fr.upem.dut.info.pokemonproject.Type;

public class Pokemon {
	private final int number;
	protected final String name ;
	private final String path ;
	private final int height ;
	private final int weight ;
	private final Type type;
	private final Type type2;
	
	public Pokemon(int number, String name, String path, int height, int weight, Type type) {
		this(number,name,path,height,weight,type,null);
	}
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
		
	}  ;
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
		return name+" est mort ";
	}
	public Type getType() {
		return type;
	}
	public Type getType2() {
		return type2;
	}
	private int random(int borneInf, int borneSup) {
	   Random random = new Random();
	   int nb;
	   nb = borneInf+random.nextInt(borneSup-borneInf);
	   return nb;
	}
	public PokemonFight createPokemon() {
		return new PokemonFight(number, name, path, height, weight, type, type2, 0, random(100,300), random(30,180), random(30,180), random(10, 200), random(10, 200), random(0,180));
	}
	
}
