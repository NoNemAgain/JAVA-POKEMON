package fr.upem.dut.info.pokemonproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

public class PokeCapacity {
	private HashMap<String,Pokemon> pokedex;
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/move.csv";
	private final int version;
	public PokeCapacity  () throws IOException {
		Path file = Paths.get(fileName);
		Charset charset = StandardCharsets.UTF_8;
		HashMap<String,Pokemon> pokedex = new HashMap<String,Pokemon>();
		int i = 0;
		try (BufferedReader reader = Files.newBufferedReader(file, charset)){
			String line1;
			while ((line1 = reader.readLine()) != null) {
				String[] line = line1.split(",");
				if(i !=0) {
					if (line.length == 7) {
						pokedex.put(line[0], Objects.requireNonNull(new CapacityDamage(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]),  Type.getType((line[5])), Type.getType((line[6])))));
					}
					else {
						pokedex.put(Integer.parseInt(line[0]), Objects.requireNonNull(new Pokemon(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]),  Type.getType((line[5])))));
					}
				}
				i++;
			}
		}
		this.pokedex = pokedex;
		this.version=0;
	}
	public HashMap<Integer, Pokemon> getPokedex() {
		return pokedex;
	}

    
}
