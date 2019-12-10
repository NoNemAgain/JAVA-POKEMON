package fr.upem.dut.info.pokemonproject;

public class CapacityPhysic extends AbstractCapacity{
	public CapacityPhysic(String name, int power, int precision, int limit, Type type, Type type2) {
		super(name, power, precision, limit, type, type2);
	}
	public CapacityPhysic(String name, int power, int precision,int limit, Type type) {
		this(name,power,precision,limit, type, null);
	}
}
