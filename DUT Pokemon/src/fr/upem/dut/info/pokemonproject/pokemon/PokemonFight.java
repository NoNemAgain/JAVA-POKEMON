package fr.upem.dut.info.pokemonproject.pokemon;

import java.util.Objects;
import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.capacity.Capacity;
import fr.upem.dut.info.pokemonproject.capacity.CapacityDamage;
import fr.upem.dut.info.pokemonproject.loader.TypesMultiplicators;

public class PokemonFight extends Pokemon {
	/**
	 * Pokemon who are fighting in Fight, they are generate by the Pokedex and Pokemon. 
	 * Compare to Pokemon, this class has stats such as attack, defense, speed etc and capacities who are used to fight 
	 */
	private static final long serialVersionUID = 6129822248125061027L;
	private static int id = 0;
	private float exp;
	private float hp;
	private int attack;
	private int attackSpe;
	private int defense;
	private int defenseSpe;
	private int speed;
	private CapacityDamage[] capacities;

	public PokemonFight(int number, String name, String path, int height, int weight, Type type, Type type2, int exp,
			int hp, int attack, int attackSpe, int defense, int defenseSpe, int speed, CapacityDamage... capacities) {
		super(number, name, path, height, weight, type);
		if (exp < 0 || hp < 0 || attack < 0 || attackSpe < 0 || defense < 0 || defenseSpe < 0 || speed < 0) {
			throw new IllegalArgumentException();
		}
		for (Capacity c : capacities) {
			if (!c.canChooseCapacity(this)) {
				throw new IllegalArgumentException();
			}
		}
		id++;
		this.exp = exp;
		this.hp = hp;
		this.attack = attack;
		this.attackSpe = attackSpe;
		this.defense = defense;
		this.defenseSpe = defenseSpe;
		this.speed = speed;
		this.capacities = capacities;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PokemonFight)) {
			return false;
		}
		PokemonFight p = (PokemonFight) o;
		return super.equals(p) && capacities.equals(p.capacities);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), capacities);
	}

	public boolean isDead() {
		if (hp <= 0) {
			System.out.println(dead());
			return true;
		}
		return false;
	}

	public Type getType() {
		return super.getType();
	}

	public Type getType2() {
		return super.getType2();
	}

	public String toString() {
		return super.toString();
	}

	@Override
	public String dead() {
		return super.dead();
	}

	public void getDamaged(float damage, boolean physic) {
		if (physic) {
			damage = (damage / (defense * 50)) + 2;
			hp -= damage;
		} else {
			damage = (damage / (defenseSpe * 50)) + 2;
			hp -= damage;
		}

		System.out.println(name + " a perdu " + damage + " pt de vies !\n");
	}

	public void setCapacities(CapacityDamage[] capacityDamages) {
		capacities = capacityDamages;
	}

	public CapacityDamage getCapacity(int number) {
		return capacities[number - 1];
	}

	public void attack(PokemonFight pokemonOPP, CapacityDamage capa, TypesMultiplicators tm) {
		/** Attack the active pokemon of the oppenent with a capacity **/
		boolean physic = true;
		float mul = 0;
		if (capa.isPhysical()) {
			mul = (float) ((exp * 0.4 + 2) * attack);
			physic = true;

		} else {
			mul = (float) ((exp * 0.4 + 2) * attackSpe);
			physic = false;
		}
		System.out.println(name + " attaque " + pokemonOPP.name + " avec " + capa.getName());
		capa.damage(pokemonOPP, tm, mul, physic);
	}

	public float getHp() {
		return hp;
	}

	public String getName() {
		return super.getName();
	}

	public String getCapacities() {
		StringBuilder str = new StringBuilder();
		for (Capacity capa : capacities) {
			if (capa != null) {
				str.append(capa);
				str.append(" | ");
			}
		}
		return str.toString();
	}

	public float getExp() {
		return exp;
	}

}