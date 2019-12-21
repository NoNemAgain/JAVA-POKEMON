package fr.upem.dut.info.pokemonproject.capacity;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class CapacityDamage extends AbstractCapacity{

    public CapacityDamage(int id ,String name, Type type, int power,int pp,int precision,String capacityType) {
        super(id,name, type,pp, power, precision,capacityType);
    }

    public void damage(PokemonFight p) {
    	super.damage(p);
    }
    public Type getType() {
  		return super.getType();
  	}
    public boolean canChooseCapacity(PokemonFight p) {
    	return super.canChooseCapacity(p);
    }
    @Override
	public String toString() {
    	return super.toString();
    }
  
    
}

