package fr.upem.dut.info.pokemonproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Pokedex {
	private HashMap<Integer,Pokemon> pokedex;
	private static final String fileName = "src/fr/upem/dut/info/source/pokedex.csv";
	private final int version ;
	public Pokedex () throws IOException {
		Path file = Paths.get(fileName);
		Charset charset = StandardCharsets.UTF_8;
		HashMap<Integer,Pokemon> pokedex = new HashMap<Integer,Pokemon>();
		int i = 0;
		try (BufferedReader reader = Files.newBufferedReader(file, charset)){
			String[] line;
			while ((line = reader.readLine().split(",")) != null) {
				if(i !=0) {
					pokedex.put(Integer.parseInt(line[0]), new Pokemon(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]),  Type.getType((line[5]))));
				}
				i++;
			}
		}
		this.version=0;
	}

	
}
