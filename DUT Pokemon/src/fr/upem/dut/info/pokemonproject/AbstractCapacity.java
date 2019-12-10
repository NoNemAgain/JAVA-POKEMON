package fr.upem.dut.info.pokemonproject;

import java.util.Objects;

public abstract class AbstractCapacity implements Capacity {
<<<<<<< Upstream, based on origin/master
	private final String name ; 
	private final int power ;
	private final int precision ;
	private int limit;
	private final Type type ;
	private final Type type2;
	
	
	public AbstractCapacity(String name, int power, int precision,int limit, Type type,Type type2) {
		if (power<0|| precision<0||limit<0) {
			throw new IllegalArgumentException();
		}
		this.name = Objects.requireNonNull(name);
		this.power = power;
		this.precision = precision;
		this.limit=limit;
		this.type = Objects.requireNonNull(type);
		this.type2 = type2;
	}
	public AbstractCapacity(String name, int power, int precision, int limit, Type type) {
		this(name,power,precision,limit,type,null);
	}
	
	
	
	
	

=======
    private final String name ; 
    private final int power ;
    private final int precision ;
    private int limit;
    private final Type type ;
    private final Type type2;
    
    
    public AbstractCapacity(String name, int power, int precision,int limit, Type type,Type type2) {
        if (power<0|| precision<0||limit<0) {
            throw new IllegalArgumentException();
        }
        this.name = Objects.requireNonNull(name);
        this.power = power;
        this.precision = precision;
        this.limit=limit;
        this.type = Objects.requireNonNull(type);
        this.type2 = type2;
    }
    public AbstractCapacity(String name, int power, int precision, int limit, Type type) {
        this(name,power,precision,limit,type,null);
    }
>>>>>>> f57f4e3 14:52
}
 
