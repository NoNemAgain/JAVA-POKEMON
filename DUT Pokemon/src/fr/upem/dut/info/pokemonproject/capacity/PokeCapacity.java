package fr.upem.dut.info.pokemonproject.capacity;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class PokeCapacity {
	private HashMap<String, CapacityDamage> capacities;
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/moves.csv";
	public PokeCapacity  () throws IOException {
		
		this.capacities = create();
	}
	public HashMap<String, CapacityDamage> getCapacities() {
		return capacities;
	}
	public HashMap<String, CapacityDamage> create() throws IOException{
		Path file = Paths.get(fileName);
		Charset charset = StandardCharsets.UTF_8;
		HashMap<String, CapacityDamage> capacities = new HashMap<String,CapacityDamage>();
		int i = 0;
		try (BufferedReader reader = Files.newBufferedReader(file, charset)){
			String line1;
			while ((line1 = reader.readLine()) != null) {
				String[] line = line1.split(",");
				if(i !=0) {
					add(line,capacities);
				}
				i++;
			}
		}
		return capacities;
	}
	public void add(String[] line,HashMap<String, CapacityDamage> capacities) {
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
