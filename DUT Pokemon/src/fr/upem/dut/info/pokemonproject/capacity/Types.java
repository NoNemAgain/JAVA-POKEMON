package fr.upem.dut.info.pokemonproject.capacity;

import fr.upem.dut.info.pokemonproject.Type;
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
		System.out.println("blabla" +type1);
		System.out.println("blabladdzd"+type2);
		if (type1.equals(pf.getType())&&type2.equals(pf.getType2())){
			return true ;
		}
		return false;
	}
	
	
}
