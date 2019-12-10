package fr.upem.dut.info.pokemonproject;

public class CapacityPhysic extends AbstractCapacity{

    public CapacityPhysic(String name, int power, int precision, int limit, Type type) {
        super(name, power, precision, limit, type);
    }

    public void damage(PokemonFight p) {
    	super.damage(p);
    }
}

