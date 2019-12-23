package fr.upem.dut.info.pokemonproject.capacity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.AbstractLoad;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class TypesMultiplicators extends AbstractLoad{
	HashMap<Types, TypeMultiplicator> typesMultiplicators = new HashMap<Types,TypeMultiplicator>();
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/grid_types.csv";
public TypesMultiplicators () throws IOException {
		
		create(this.fileName);
	}
	public HashMap<Types, TypeMultiplicator> getTypesMultiplicators() {
		return typesMultiplicators;
	}
	public void create(String fileName) throws IOException{
		super.create(fileName);
	}
	public void add(String[] line) {
		if(line[3].equals("")) {line[3] = null;}
		/*	typesMultiplicators.put( new Types (Type.getType((line[0]))), Objects.requireNonNull(new TypeMultiplicator(Type.getType((line[0])), Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), 
					Integer.parseInt(line[6]), Integer.parseInt(line[7]), Integer.parseInt(line[8]),Integer.parseInt(line[9]),Integer.parseInt(line[10]), Integer.parseInt(line[11]), Integer.parseInt(line[12]), Integer.parseInt(line[13]), Integer.parseInt(line[14]), Integer.parseInt(line[15]), Integer.parseInt(line[16]), Integer.parseInt(line[17]))));
		}
		else {*/
		typesMultiplicators.put( new Types (Type.getType((line[0])),Type.getType((line[1]))), Objects.requireNonNull(new TypeMultiplicator(Type.getType((line[0])), Type.getType((line[1])), Float.parseFloat(line[2]), Float.parseFloat(line[3]), Float.parseFloat(line[4]), Float.parseFloat(line[5]), Float.parseFloat(line[6]), 
				Float.parseFloat(line[7]), Float.parseFloat(line[8]), Float.parseFloat(line[9]),Float.parseFloat(line[10]),Float.parseFloat(line[11]), Float.parseFloat(line[12]), Float.parseFloat(line[13]), Float.parseFloat(line[14]), Float.parseFloat(line[15]), Float.parseFloat(line[16]), Float.parseFloat(line[17]), Float.parseFloat(line[18]))));
		
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Types t:typesMultiplicators.keySet()) {
			str.append(typesMultiplicators.get(t).toString());
			str.append("\n");
		}
		return str.toString();
	}

	
}


