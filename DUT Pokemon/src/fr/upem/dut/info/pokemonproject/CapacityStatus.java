package fr.upem.dut.info.pokemonproject;

public class CapacityStatus extends AbstractCapacity{
	public CapacityStatus(String name, int power, int precision, int limit, Type type, Type type2) {
		super(name, power, precision,limit, type, type2);
	}
	public CapacityStatus(String name, int power, int precision,int limit, Type type) {
		this(name,power,precision,limit, type, null);
	}

}
