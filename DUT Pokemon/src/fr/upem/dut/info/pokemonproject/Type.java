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
		if(str == "normal") {
			return Type.normal;
		}
		if(str == "grass") {
			return Type.grass;
		}
		if(str == "poison") {
			return Type.poison;
		}
		if(str == "fire") {
			return Type.fire;
		}
		if(str == "flying") {
			return Type.flying;
		}
		if(str == "water") {
			return Type.water;
		}
		if(str == "bug") {
			return Type.bug;
		}
		if(str == "electric") {
			return Type.electric;
		}
		if(str == "ground") {
			return Type.ground;
		}
		if(str == "fairy") {
			return Type.fairy;
		}
		if(str == "psychic") {
			return Type.psychic;
		}
		if(str == "rock") {
			return Type.rock;
		}
		if(str == "steel") {
			return Type.steel;
		}
		if(str == "ice") {
			return Type.ice;
		}
		if(str == "ghost") {
			return Type.ghost;
		}
		if(str == "dragon") {
			return Type.dragon;
		}
		if(str == "dark") {
			return Type.dark;
		}
		if(str == "fighting") {
			return Type.fighting;
		}
		else {
			return null;
		}
			
		
	}
}
