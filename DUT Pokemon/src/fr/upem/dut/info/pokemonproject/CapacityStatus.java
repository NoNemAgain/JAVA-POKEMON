package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public class CapacityStatus extends AbstractCapacity{
	private final int stat ;
	private int round ;
	private final Stat statName ;
    public CapacityStatus(String name, int precision, int limit, Type type,int stat,int round ,Stat statName) {
        super(name, 0, precision,limit, type);
    	if (round<0) {
    		throw new IllegalArgumentException();
    	}
        this.stat =stat;
        this.round=round;
        this.statName=Objects.requireNonNull(statName);
    }


    public void status(PokemonFight p, int round) {
    	p.getStat(stat, statName,round);
    	
    	
    }
    public void damage(PokemonFight p) {
    	super.damage(p);
    	status(p,round);
    }
    public Type getType() {
  		return super.getType();
  	}
    public boolean canChooseCapacity(PokemonFight p) {
    	return super.canChooseCapacity(p);
    }


}