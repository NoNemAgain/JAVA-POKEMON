package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public class Pokemon {
	private final int number;
	private final String name ;
	private final String path ;
	private final int height ;
	private final int weight ;
	private final Type type;
	private final Type type2;
	private static int id = 0;
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
		this.type2 = Objects.requireNonNull(type2);
		id++;
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
}
