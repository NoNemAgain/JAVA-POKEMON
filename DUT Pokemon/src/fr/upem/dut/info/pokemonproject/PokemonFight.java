package fr.upem.dut.info.pokemonproject;

import java.util.ArrayList;
import java.util.Objects;

public class PokemonFight extends Pokemon{
        private static int id = 0;
        private float exp ;
        private int hp ;
        private int attack;
        private int attackSpe;
        private int defense;
        private int defenseSpe;
        private int speed;
        private final Capacity[] capacities ;
        
    public PokemonFight(int number, String name, String path, int height, int weight,Type type,Type type2,int exp,int hp,int attack,int attackSpe,int defense,int defenseSpe,int speed,Capacity... capacities) throws IllegalAccessException {
        super(number, name, path, height, weight, type);
        if (exp<0||hp<0||attack<0||attackSpe<0||defense<0||defenseSpe<0||speed<0 || capacities[0] == null || capacities[4] != null ) {
            throw new IllegalAccessException();
        }
        for ( Capacity c:capacities) {
        	if (!c.canChooseCapacity(this)) {
        		throw new IllegalArgumentException();        	
        		}
        }
        id++;
        this.exp=exp;
        this.hp=hp;
        this.attack=attack;
        this.attackSpe=attackSpe;
        this.defense=defense;
        this.defenseSpe=defenseSpe;
        this.speed=speed;
        this.capacities=capacities;
     ;
       
    }
    @Override 
	public boolean equals(Object o ) {
		if(!(o instanceof PokemonFight)) {
			return false; 
		}
		PokemonFight p  = (PokemonFight) o;
		return super.equals(p)&&capacities.equals(p.capacities);
		}
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(),capacities);
		} 
   public boolean isdead() {
	   if (hp==0){
		   return true ;
	   }
	   return false; 
   }
   public Type getType() {
	   return super.getType();
   }
   public String toString() {
	  return super.toString();
   }
   @Override
   public String dead() {
	   return super.dead();
   }
   public void getDamaged(int damage) {
	   hp-=damage;//
   }
   public void getStat(int stat,Stat statName,int round) {
		   if (Stat.isAttack(statName)) {
			   attack+= stat;
		   }
		   if (Stat.isDefense(statName)) {
			   defense+= stat;
		   }
		   if (Stat.isAttackSpe(statName)) {
			   attackSpe+= stat;
		   }
		   if (Stat.isDefenseSpe(statName)) {
			   defenseSpe+= stat;
		   }
		   if (Stat.isSpeed(statName)) {
			   speed+= stat;
		   }
		  
   }
   /*
   public boolean dissapear(int round) {
	   if (round==0) {
		   return true;
	   }
	   return false;
   }*/
   
   
  

}