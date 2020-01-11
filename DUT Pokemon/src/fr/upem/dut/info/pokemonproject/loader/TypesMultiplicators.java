package fr.upem.dut.info.pokemonproject.loader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.capacity.AbstractCapacity;
import fr.upem.dut.info.pokemonproject.capacity.TypeMultiplicator;
import fr.upem.dut.info.pokemonproject.capacity.Types;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public class TypesMultiplicators extends AbstractLoad {
	/**
	 * This class permit to load the TM wich is use in Fight
	 */
	HashMap<Types, TypeMultiplicator> typesMultiplicators = new HashMap<Types, TypeMultiplicator>();
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/grid_types.csv";

	public TypesMultiplicators() throws IOException {

		create(TypesMultiplicators.fileName);
	}

	public HashMap<Types, TypeMultiplicator> getTypesMultiplicators() {
		return typesMultiplicators;
	}

	public void create(String fileName) throws IOException {
		super.create(fileName);
	}

	public void add(String[] line) {
		if (line[3].equals("")) {
			line[3] = null;
		}
		typesMultiplicators.put(new Types(Type.getType((line[0])), Type.getType((line[1]))),
				Objects.requireNonNull(new TypeMultiplicator(Type.getType((line[0])), Type.getType((line[1])),
						Float.parseFloat(line[2]), Float.parseFloat(line[3]), Float.parseFloat(line[4]),
						Float.parseFloat(line[5]), Float.parseFloat(line[6]), Float.parseFloat(line[7]),
						Float.parseFloat(line[8]), Float.parseFloat(line[9]), Float.parseFloat(line[10]),
						Float.parseFloat(line[11]), Float.parseFloat(line[12]), Float.parseFloat(line[13]),
						Float.parseFloat(line[14]), Float.parseFloat(line[15]), Float.parseFloat(line[16]),
						Float.parseFloat(line[17]), Float.parseFloat(line[18]), Float.parseFloat(line[19]))));

	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		typesMultiplicators.keySet().stream().forEach(t -> str.append(typesMultiplicators.get(t).toString() + "\n"));
		return str.toString();
	}

	public float weakness(PokemonFight pf, AbstractCapacity abstractCapacity) {
		float multiplicator = 0.0F;
		for (Types t : typesMultiplicators.keySet()) {
			if (t.sameType(pf)) {
				multiplicator = typesMultiplicators.get(t).multiplicatorTypes(abstractCapacity.getType());
				break;

			}
		}
		return multiplicator;
		// Tentative d'utiliation des streams mais bug avec NoSuchElementException par
		// fois
		/*
		 * float multiplicator = 0.0F ; Predicate<Types> pre = (t)-> t.sameType(pf);
		 * Types t =
		 * typesMultiplicators.keySet().parallelStream().filter(pre).findFirst().get();
		 * multiplicator =
		 * typesMultiplicators.get(t).multiplicatorTypes(abstractCapacity.getType());
		 * return multiplicator;
		 */
	}
}