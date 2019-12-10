package fr.upem.dut.info.pokemonproject;

public enum Type {
	normal, 
	grass, 
	poison, 
	fire, 
	flying, 
	water, 
	bug, 
	electric, 
	ground, 
	fairy, 
	psychic, 
	rock, 
	steel, 
	ice, 
	ghost, 
	dragon, 
	dark ,
	fighting ;
	
	public static Type getType(String str) {
		if(str.equals("normal")) {
			return Type.normal;
		}
		if(str.equals("grass")) {
			return Type.grass;
		}
		if(str.equals("poison")) {
			return Type.poison;
		}
		if(str.equals("fire")) {
			return Type.fire;
		}
		if(str.equals("flying")) {
			return Type.flying;
		}
		if(str.equals("water")) {
			return Type.water;
		}
		if(str.equals("bug")) {
			return Type.bug;
		}
		if(str.equals("electric")) {
			return Type.electric;
		}
		if(str.equals("ground")) {
			return Type.ground;
		}
		if(str.equals("fairy")) {
			return Type.fairy;
		}
		if(str.equals("psychic")) {
			return Type.psychic;
		}
		if(str.equals("rock")) {
			return Type.rock;
		}
		if(str.equals("steel")) {
			return Type.steel;
		}
		if(str.equals("ice")) {
			return Type.ice;
		}
		if(str.equals("ghost")) {
			return Type.ghost;
		}
		if(str.equals("dragon")) {
			return Type.dragon;
		}
		if(str.equals("dark")) {
			return Type.dark;
		}
		if(str.equals("fighting")) {
			return Type.fighting;
		}
		else {
			return null;
		}
			
		
	}
}
