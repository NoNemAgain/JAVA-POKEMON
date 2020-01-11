package fr.upem.dut.info.pokemonproject.capacity;

import fr.upem.dut.info.pokemonproject.Type;

public class TypeMultiplicator {
	private final Type Type1;
	private final Type Type2;
	private final float steel;
	private final float fighting;
	private final float dragon;
	private final float water;
	private final float electric;
	private final float fairy;
	private final float fire;
	private final float ice;
	private final float bug;
	private final float Normal;
	private final float grass;
	private final float poison;
	private final float psychic;
	private final float rock;
	private final float ground;
	private final float ghost;
	private final float dark;
	private final float flying;

	public TypeMultiplicator(Type type1, Type type2, float steel, float fighting, float dragon, float water,
			float electric, float fairy, float fire, float ice, float bug, float normal, float grass, float poison,
			float psychic, float rock, float ground, float ghost, float dark, float flying) {

		this.Type1 = type1;
		this.Type2 = type2;
		this.steel = steel;
		this.fighting = fighting;
		this.dragon = dragon;
		this.water = water;
		this.electric = electric;
		this.fairy = fairy;
		this.fire = fire;
		this.ice = ice;
		this.bug = bug;
		this.Normal = normal;
		this.grass = grass;
		this.poison = poison;
		this.psychic = psychic;
		this.rock = rock;
		this.ground = ground;
		;
		this.ghost = ghost;
		this.dark = dark;
		this.flying = flying;
	}

	public TypeMultiplicator(Type type1, float steel, float fighting, float dragon, float water, float electric,
			float fairy, float fire, float ice, float bug, float normal, float grass, float poison, float psychic,
			float rock, float ground, float ghost, float dark, float flying) {
		this(type1, null, steel, fighting, dragon, water, electric, fairy, fire, ice, bug, normal, grass, poison,
				psychic, rock, ground, ghost, dark, flying);
	}

	@Override
	public String toString() {
		return "TypeMultiplicator [Type1=" + Type1 + ", Type2=" + Type2 + ", fighting=" + fighting + ", dragon="
				+ dragon + ", water=" + water + ", electric=" + electric + ", fairy=" + fairy + ", fire=" + fire
				+ ", ice=" + ice + ", bug=" + bug + ", Normal=" + Normal + ", grass=" + grass + ", poison=" + poison
				+ ", psychic=" + psychic + ", rock=" + rock + ", ground=" + ground + ", ghost=" + ghost + ", dark="
				+ dark + ", flying=" + flying + "]";
	}

	public float multiplicatorTypes(Type type) {
		if (type.equals(Type.normal)) {
			return Normal;
		}
		if (type.equals(Type.grass)) {
			return grass;
		}
		if (type.equals(Type.poison)) {
			return poison;
		}
		if (type.equals(Type.fire)) {
			return fire;
		}
		if (type.equals(Type.flying)) {
			return flying;
		}
		if (type.equals(Type.water)) {
			return water;
		}
		if (type.equals(Type.bug)) {
			return bug;
		}
		if (type.equals(Type.electric)) {
			return electric;
		}
		if (type.equals(Type.ground)) {
			return ground;
		}
		if (type.equals(Type.fairy)) {
			return fairy;
		}
		if (type.equals(Type.psychic)) {
			return psychic;
		}
		if (type.equals(Type.rock)) {
			return rock;
		}
		if (type.equals(Type.steel)) {
			return steel;
		}
		if (type.equals(Type.ice)) {
			return ice;
		}
		if (type.equals(Type.ghost)) {
			return ghost;
		}
		if (type.equals(Type.dragon)) {
			return dragon;
		}
		if (type.equals(Type.dark)) {
			return dark;
		} else {
			return fighting;
		}

	}
}
