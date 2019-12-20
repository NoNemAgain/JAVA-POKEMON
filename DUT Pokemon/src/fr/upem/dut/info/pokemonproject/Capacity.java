package fr.upem.dut.info.pokemonproject;

public interface Capacity {
	Type getType();
	void damage(PokemonFight p);
	boolean canChooseCapacity(PokemonFight p);
	//
}
