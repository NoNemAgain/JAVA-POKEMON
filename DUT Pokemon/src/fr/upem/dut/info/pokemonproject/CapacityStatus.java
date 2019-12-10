package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public class CapacityStatus extends AbstractCapacity{
	private final int stat ;
	private int round ;
	private final Stat statName ;
    public CapacityStatus(String name, int power, int precision, int limit, Type type, Type type2,int stat,int round ,Stat statName) {
        super(name, power, precision,limit, type, type2);
    	if (round<0) {
    		throw new IllegalArgumentException();
    	}
        this.stat =stat;
        this.round=round;
        this.statName=Objects.requireNonNull(statName);
    }
    public CapacityStatus(String name, int power, int precision,int limit, Type type,int stat,int round,Stat statName) {
        this(name,power,precision,limit, type, null,stat,round,statName);
    }
    public boolean malus() {
    	if (stat<0) {
    		return true;
    	}
    	return false;
    }
    public void status(PokemonFight p) {
    	if (malus()) {
    		p.getMalus(this.stat,this.statName);
    	}
    	p.getBonus(this.stat);
    	
    }
    public void damage(PokemonFight p) {
    	super.damage(p);
    }


}