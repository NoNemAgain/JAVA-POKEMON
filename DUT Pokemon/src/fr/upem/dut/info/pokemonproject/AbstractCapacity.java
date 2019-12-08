package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public abstract class AbstractCapacity {
	private final String name ; 
	private final int power ;
	private final int precision ;
	private final Type type ;
	
	public AbstractCapacity(String name, int power, int precision, Type type) {
		if (power<0|| precision<0) {
			throw new IllegalArgumentException();
		}
		this.name = Objects.requireNonNull(name);
		this.power = power;
		this.precision = precision;
		this.type = Objects.requireNonNull(type);
	}
	
	
	

}
