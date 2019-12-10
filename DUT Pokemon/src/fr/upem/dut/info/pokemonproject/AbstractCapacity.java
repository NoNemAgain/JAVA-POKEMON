package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public abstract class AbstractCapacity implements Capacity {
	private final String name ; 
	private final int power ;
	private final int precision ;
	private int limit;
	private final Type type ;
	
	
	public AbstractCapacity(String name, int power, int precision,int limit, Type type) {
		if (power<15 &&power>300|| precision<0 && precision>100||limit<0) {
			throw new IllegalArgumentException();
		}
		this.name = Objects.requireNonNull(name);
		this.power = power;
		this.precision = precision;
		this.limit=limit;
		this.type = Objects.requireNonNull(type);

	}

	public void damage(PokemonFight p) {
		float random= (float) (Math.random() * ( 100 - 0 ));
		if (precision> random) {
			p.getDamaged(power);
		}
		
	}
	
	
	

}
 
