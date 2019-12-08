package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public abstract class AbstractPokemon implements Pokemon {
	private final int number;
	private  final String name ;
	private final String path ;
	private final int height ;
	private final int weight ;
	private final Type type;
	private final Type type2;
	public AbstractPokemon(int number, String name, String path, int height, int weight, Type type) {
		this(number,name,path,height,weight,type,null);
	}
	public AbstractPokemon(int number, String name, String path, int height, int weight, Type type,Type type2) {
		if (number<0 || height <0 ||weight <0) {
			throw new IllegalArgumentException();
		}
		this.number = number;
		this.name = Objects.requireNonNull(name);
		this.path = Objects.requireNonNull(path);
		this.height = height;
		this.weight = weight;
		this.type = Objects.requireNonNull(type);
		this.type2 = Objects.requireNonNull(type2);
	}  ;
}
