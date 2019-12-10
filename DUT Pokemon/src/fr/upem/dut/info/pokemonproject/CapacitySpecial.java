package fr.upem.dut.info.pokemonproject;

public class CapacitySpecial extends AbstractCapacity{

    public CapacitySpecial(String name, int power, int precision, int limit, Type type, Type type2) {
        super(name, power, precision, limit, type, type2);
    }
    public CapacitySpecial(String name, int power, int precision,int limit, Type type) {
        this(name,power,precision,limit, type, null);
    }
    public void damage(PokemonFight p) {
    	super.damage(p);
    }
}

