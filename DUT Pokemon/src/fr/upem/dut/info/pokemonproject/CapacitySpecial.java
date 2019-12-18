package fr.upem.dut.info.pokemonproject;

public class CapacitySpecial extends AbstractCapacity{

    public CapacitySpecial(String name, int power, int precision, int limit, Type type) {
        super(name, power, precision, limit, type);
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
}

