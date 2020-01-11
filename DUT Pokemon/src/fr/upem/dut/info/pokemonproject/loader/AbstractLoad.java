package fr.upem.dut.info.pokemonproject.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

abstract class AbstractLoad {
	/**
	 *  This class permit to pass on the function Create to {@link PokeCapacity}, {@link Pokedex}, {@link TypesMultiplicators}
	 */
	public AbstractLoad() throws IOException {
	}

	// load the file
	protected void create(String fileName) throws IOException {
		Path file = Paths.get(fileName);
		Charset charset = StandardCharsets.UTF_8;
		int i = 0;
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line1;
			while ((line1 = reader.readLine()) != null) {
				String[] line = line1.split(",");
				if (i != 0) {
					add(line);
				}
				i++;
			}
		}

	}

	abstract void add(String[] line);

}
