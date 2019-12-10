package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public abstract class AbstractCapacity implements Capacity {
	private final String name ; 
	private final int power ;
	private final int precision ;
	private final Type type ;
	private final Type type2;
	private int limit;
	
	public AbstractCapacity(String name, int power, int precision,int limit, Type type,Type type2) {
		if (power<0|| precision<0||limit<0) {
			throw new IllegalArgumentException();
		}
		this.name = Objects.requireNonNull(name);
		this.power = power;
		this.precision = precision;
		this.type = Objects.requireNonNull(type);
		this.type2 = Objects.requireNonNull(type2);
		this.limit=limit;
	}
	public AbstractCapacity(String name, int power, int precision, Type type,int limit) {
		this.(name,power,precision,type,null,limit);
	}
	
	
	
	
	

}
