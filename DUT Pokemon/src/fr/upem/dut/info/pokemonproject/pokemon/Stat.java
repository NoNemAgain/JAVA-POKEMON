package fr.upem.dut.info.pokemonproject.pokemon;

public enum Stat {
	attack,
	defense,
	attackSpe,
	defenseSpe,
	speed;
	public static boolean isAttack(Stat sn) {
		if (attack == sn) {
			return true;
		}
		return false;
	}
	public static boolean isDefense(Stat sn) {
		if (defense == sn) {
			return true;
		}
		return false;
	}
	public static boolean isAttackSpe(Stat sn) {
		if (attackSpe == sn) {
			return true;
		}
		return false;
	}
	
	public static boolean isDefenseSpe(Stat sn) {
		if (defenseSpe == sn) {
			return true;
		}
		return false;
	}
	public static boolean isSpeed(Stat sn) {
		if (speed == sn) {
			return true;
		}
		return false;
	}
	
	
}

