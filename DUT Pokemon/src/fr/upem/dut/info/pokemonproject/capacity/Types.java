package fr.upem.dut.info.pokemonproject.capacity;

import java.util.ArrayList;

import fr.upem.dut.info.pokemonproject.Type;

public class Types {
	private ArrayList<Type> types = new ArrayList <>(); 
	public Types(Type type1, Type type2) {
		types.add(type1);
		types.add(type2);
	}
	public Types(Type type1) {
		types.add(type1);
		
	}
}
