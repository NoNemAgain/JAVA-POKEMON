package fr.upem.dut.info.pokemonproject.capacity;
import fr.upem.dut.info.pokemonproject.Type;
public class TypeMultiplicator {
	private final Type Type1;
	private final Type Type2;
	private final float fighting;
	private final float dragon;
	private final float water;
	private final float electic;
	private final float fairy;
	private final float fire;
	private final float ice;
	private final float bug ;
	private final float Normal;
	private final float grass;
	private final float poison;
	private final float psychic;
	private final float rock;
	private final float ground;
	private final float ghost;
	private final float dark;
	private final float flying;
	public TypeMultiplicator(Type type1, Type type2, float fighting, float dragon, float water, float electic,
			float fairy, float fire, float ice, float bug, float normal, float grass, float poison, float psychic,
			float rock, float ground, float ghost, float dark, float flying) {
		
		this.Type1 = type1;
		this.Type2 = type2;
		this.fighting = fighting;
		this.dragon = dragon;
		this.water = water;
		this.electic = electic;
		this.fairy = fairy;
		this.fire = fire;
		this.ice = ice;
		this.bug = bug;
		this.Normal = normal;
		this.grass = grass;
		this.poison = poison;
		this.psychic = psychic;
		this.rock = rock;
		this.ground = ground;;
		this.ghost = ghost;
		this.dark = dark;
		this.flying = flying;
	}
	public TypeMultiplicator(Type type1, float fighting, float dragon, float water, float electic,
			float fairy, float fire, float ice, float bug, float normal, float grass, float poison, float psychic,
			float rock, float ground, float ghost, float dark, float flying) {
	this(type1,null,fighting,dragon,water,electic,fairy,fire,ice,bug,normal,grass,poison,psychic,rock,ground, ghost,dark,flying);
	}
	@Override
	public String toString() {
		return "TypeMultiplicator [Type1=" + Type1 + ", Type2=" + Type2 + ", fighting=" + fighting + ", dragon="
				+ dragon + ", water=" + water + ", electic=" + electic + ", fairy=" + fairy + ", fire=" + fire
				+ ", ice=" + ice + ", bug=" + bug + ", Normal=" + Normal + ", grass=" + grass + ", poison=" + poison
				+ ", psychic=" + psychic + ", rock=" + rock + ", ground=" + ground + ", ghost=" + ghost + ", dark="
				+ dark + ", flying=" + flying + "]";
	}
}
