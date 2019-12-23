package fr.upem.dut.info.pokemonproject.capacity;

import java.util.ArrayList;
import java.util.Objects;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class Types {
	private final Type type1;
	private final Type type2;
	public Types(Type type1, Type type2) {
		this.type1=type1;
		this.type2=type2;
	}
	public Types(Type type1) {
		this(type1,null);
		
	}
	public boolean sameType(PokemonFight pf) {
		if (type1.equals(pf.getType())&&type2.equals(pf.getType2())){
			return true ;
		}
		return false;
	}
	
	
}
