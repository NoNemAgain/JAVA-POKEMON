package fr.upem.dut.info.pokemonproject.loader;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class Pokedex extends AbstractLoad implements Serializable {
	/**
	 *  This class permit to load the Pokedex  compose of {@link Pokemon} to generate {@link PokemonFight}
	 */
	private static final long serialVersionUID = -4972182653140422867L;
	HashMap<Integer, Pokemon> pokedex = new HashMap<Integer, Pokemon>();
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/pokedex.csv";
	private final int version;

	public Pokedex() throws IOException {
		create(Pokedex.fileName);
		this.version = 0;
	}

	public HashMap<Integer, Pokemon> getPokedex() {
		return pokedex;
	}

	public void create(String fileName) throws IOException {
		super.create(fileName);
	}

	public void add(String[] line) {
		if (line.length == 7) {
			pokedex.put(Integer.parseInt(line[0]),
					Objects.requireNonNull(
							new Pokemon(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3]),
									Integer.parseInt(line[4]), Type.getType((line[5])), Type.getType((line[6])))));
		} else {
			if (line.length == 6) {
				pokedex.put(Integer.parseInt(line[0]),
						Objects.requireNonNull(new Pokemon(Integer.parseInt(line[0]), line[1], line[2],
								Integer.parseInt(line[3]), Integer.parseInt(line[4]), Type.getType((line[5])))));
			} else {
				throw new IllegalArgumentException("Fichier non valide !");
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= pokedex.size(); i++) {
			str.append(pokedex.get(i).toString());
			str.append("\n");
		}
		return str.toString();
	}
}
