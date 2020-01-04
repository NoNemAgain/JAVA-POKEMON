package fr.upem.dut.info.pokemonproject.capacity;

import java.io.Serializable;
import java.util.Objects;

import fr.upem.dut.info.pokemonproject.Type;
import fr.upem.dut.info.pokemonproject.pokemon.PokemonFight;

public abstract class AbstractCapacity implements Capacity,Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6362766374528595134L;
	private final int id;
	protected final String name ; 
	protected final Type type ;
	protected final int power ;
	protected int pp;
	protected final int precision ;
	protected final String capacityType;

	
	public AbstractCapacity(int id ,String name, Type type, int power,int pp,int precision,String capacityType) {
		if (pp<0 ||power<15 &&power>300|| precision<0 && precision>100||pp<0 || (capacityType.equals("statut")&&capacityType.equals("physical")&&capacityType.equals("special"))) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name = Objects.requireNonNull(name);
		this.type = Objects.requireNonNull(type);
		this.power = power;
		this.precision = precision;
		this.pp=pp;
		this.capacityType=Objects.requireNonNull(capacityType);
	}
	
	public Type getType() {
		return type;
	}
	public boolean canChooseCapacity(PokemonFight p) {
		if (type.equals(p.getType())){
			return true;
		}
		if (type.equals(p.getType2())){
			return true;
		}
		if (type.equals(Type.normal)){
			return true;
		}
		return false;
	}
	public boolean isPhysical() {
		if (capacityType.equals("physical")){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Capacity ID : "+id+", Capcity name : "+name + ", CapacityType : "+capacityType+", Type : "+type;
	}
	
    @Override 
	public boolean equals(Object o ) {
		if(!(o instanceof AbstractCapacity)) {
			return false; 
		}
		AbstractCapacity p  = (AbstractCapacity) o;
		return id == p.id && name.equals(p.name) && type.equals(p.type) && power == p.power && pp == p.pp && precision == p.precision && capacityType.equals(capacityType);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id,name,type,power,pp,precision,capacityType);
	}
	
	public String getName() {
		return name;
	}

}
 
