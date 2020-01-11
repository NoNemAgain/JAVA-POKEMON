package fr.upem.dut.info.pokemonproject;

public enum Type {
	normal, grass, poison, fire, flying, water, bug, electric, ground, fairy, psychic, rock, steel, ice, ghost, dragon,
	dark, fighting;

	// recognize the String
	public static Type getType(String str) {
		if (str.equals("normal")) {
			return Type.normal;
		}
		if (str.equals("grass")) {
			return Type.grass;
		}
		if (str.equals("poison")) {
			return Type.poison;
		}
		if (str.equals("fire")) {
			return Type.fire;
		}
		if (str.equals("flying")) {
			return Type.flying;
		}
		if (str.equals("water")) {
			return Type.water;
		}
		if (str.equals("bug")) {
			return Type.bug;
		}
		if (str.equals("electric")) {
			return Type.electric;
		}
		if (str.equals("ground")) {
			return Type.ground;
		}
		if (str.equals("fairy")) {
			return Type.fairy;
		}
		if (str.equals("psychic")) {
			return Type.psychic;
		}
		if (str.equals("rock")) {
			return Type.rock;
		}
		if (str.equals("steel")) {
			return Type.steel;
		}
		if (str.equals("ice")) {
			return Type.ice;
		}
		if (str.equals("ghost")) {
			return Type.ghost;
		}
		if (str.equals("dragon")) {
			return Type.dragon;
		}
		if (str.equals("dark")) {
			return Type.dark;
		}
		if (str.equals("fighting")) {
			return Type.fighting;
		} else {
			return null;
		}
	}

	public static Type getRecognizeType(Type type) {
		if (type.equals(normal)) {
			return Type.normal;
		}
		if (type.equals(grass)) {
			return Type.grass;
		}
		if (type.equals(poison)) {
			return Type.poison;
		}
		if (type.equals(fire)) {
			return Type.fire;
		}
		if (type.equals(flying)) {
			return Type.flying;
		}
		if (type.equals(water)) {
			return Type.water;
		}
		if (type.equals(bug)) {
			return Type.bug;
		}
		if (type.equals(electric)) {
			return Type.electric;
		}
		if (type.equals(ground)) {
			return Type.ground;
		}
		if (type.equals(fairy)) {
			return Type.fairy;
		}
		if (type.equals(psychic)) {
			return Type.psychic;
		}
		if (type.equals(rock)) {
			return Type.rock;
		}
		if (type.equals(steel)) {
			return Type.steel;
		}
		if (type.equals(ice)) {
			return Type.ice;
		}
		if (type.equals(ghost)) {
			return Type.ghost;
		}
		if (type.equals(dragon)) {
			return Type.dragon;
		}
		if (type.equals(dark)) {
			return Type.dark;
		}
		if (type.equals(fighting)) {
			return Type.fighting;
		} else {
			return null;
		}
	}
}
