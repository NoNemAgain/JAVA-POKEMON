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
    
    static Type getType(String str) {//
        if(str == "normal") {
            return Type.normal;
        }
        else {
            return Type.bug;
        }
            
        
    }
}