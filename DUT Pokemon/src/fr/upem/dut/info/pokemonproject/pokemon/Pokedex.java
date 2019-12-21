package fr.upem.dut.info.pokemonproject.pokemon;

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

public class Pokedex {
	private HashMap<Integer,Pokemon> pokedex;
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/pokedex.csv";
	private final int version;
	public Pokedex () throws IOException {
		Path file = Paths.get(fileName);
		Charset charset = StandardCharsets.UTF_8;
		HashMap<Integer,Pokemon> pokedex = new HashMap<Integer,Pokemon>();
		int i = 0;
		try (BufferedReader reader = Files.newBufferedReader(file, charset)){
			String line1;
			while ((line1 = reader.readLine()) != null) {
				String[] line = line1.split(",");
				if(i !=0) {
					if (line.length == 7) {
						pokedex.put(Integer.parseInt(line[0]), Objects.requireNonNull(new Pokemon(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]),  Type.getType((line[5])), Type.getType((line[6])))));
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

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for( int i=1; i <= pokedex.size(); i++ ) {
			str.append(pokedex.get(i).toString());
			str.append("\n");
		}
		return str.toString();
	}
}
