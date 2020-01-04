package fr.upem.dut.info.pokemonproject.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class PokeCapacity extends AbstractLoad implements Serializable{
	HashMap<String, CapacityDamage> capacities = new HashMap<String,CapacityDamage>();
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/moves.csv";
	public PokeCapacity  () throws IOException {
		
		create(this.fileName);
	}
	public HashMap<String, CapacityDamage> getCapacities() {
		return capacities;
	}
	public void create(String fileName) throws IOException{
		super.create(fileName);
	}
	public void add(String[] line) {
		if(line[3].equals("")) {line[3] = "0";}
		if(line[5].equals("")) {line[5] = "0";}
		capacities.put(line[1], Objects.requireNonNull(new CapacityDamage(Integer.parseInt(line[0]), line[1], Type.getType((line[2])), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6])));
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for( int i=1; i <= capacities.size(); i++ ) {	
			str.append(capacities.get(i).toString());
			str.append("\n");
		}
		return str.toString();
	}

	public String toStringCanChoosePokemon(PokemonFight pf) {
		StringBuilder str = new StringBuilder();
		for( int i=1; i <= capacities.size(); i++ ) {
			if (capacities.get(i).canChooseCapacity(pf)) {
			str.append(capacities.get(i).toString());
			str.append("\n");
			}
		}
		return str.toString();
	}
}
