package fr.upem.dut.info.pokemonproject;

public class CapacityStatus extends AbstractCapacity{
	private final int stat ;
	private  int round ;
    public CapacityStatus(String name, int power, int precision, int limit, Type type, Type type2,int stat,int round ) {
        super(name, power, precision,limit, type, type2);
    	if (stat<0||round<0) {
    		throw new IllegalArgumentException();
    	}
        this.stat =stat;
        this.round=round;
    }
    public CapacityStatus(String name, int power, int precision,int limit, Type type,int stat,int round) {
        this(name,power,precision,limit, type, null,stat,round);
    }
    


}