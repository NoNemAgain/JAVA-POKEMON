package fr.upem.dut.info.pokemonproject.capacity;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class Types {
	/**
	 *Use in {@link TypesMultiplicators} and permit to store both types of the Pokemon to return the multiplicator correctly 
	 */
	private final Type type1;
	private final Type type2;

	public Types(Type type1, Type type2) {
		this.type1 = type1;
		this.type2 = type2;
	}
	public Types(Type type1) {
		this(type1, null);
	}
	public boolean sameType(PokemonFight pf) {
		if (type1 != null && type1.equals(pf.getType()) && type2 == null) {
			return true;
		}
		if (type1 != null && type1.equals(pf.getType()) && type2.equals(pf.getType2())) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Types [type1=" + type1 + ", type2=" + type2 + "]";
	}
}
