package fr.upem.dut.info.pokemonproject.loader;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.pokemon.Pokemon;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class PokeCapacity extends AbstractLoad implements Serializable {
	/**
	 *  This class permit to load the {@link PokeCapacity} to initalize {@link PokemonFight} capacities
	 */
	private static final long serialVersionUID = -3032856954583949261L;
	HashMap<String, CapacityDamage> capacities = new HashMap<String, CapacityDamage>();
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/moves.csv";

	public PokeCapacity() throws IOException {

		create(PokeCapacity.fileName);
	}

	public HashMap<String, CapacityDamage> getCapacities() {
		return capacities;
	}

	public void create(String fileName) throws IOException {
		super.create(fileName);
	}

	public void add(String[] line) {
		if (line[3].equals("")) {
			line[3] = "0";
		}
		if (line[5].equals("")) {
			line[5] = "0";
		}
		capacities.put(line[1],
				Objects.requireNonNull(new CapacityDamage(Integer.parseInt(line[0]), line[1], Type.getType((line[2])),
						Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6])));
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		capacities.keySet().stream().forEach((capaName) -> {
			str.append(capacities.get(capaName));
			str.append("\n");
		});
		return str.toString();
	}

	public String toStringCanChoosePokemon(PokemonFight pf) {
		StringBuilder str = new StringBuilder();
		capacities.keySet().parallelStream().filter(capaName -> capacities.get(capaName).canChooseCapacity(pf))
				.forEach((capaName) -> {
					str.append(capacities.get(capaName));
					str.append("\n");
				});
		return str.toString();
	}

	public CapacityDamage randomCapacityDamage() {
		int random = Pokemon.random(1, 728);
		return capacities.get(capacities.keySet().parallelStream()
				.filter(capaName -> capacities.get(capaName).getId() == random).findFirst().get());
	}
}
