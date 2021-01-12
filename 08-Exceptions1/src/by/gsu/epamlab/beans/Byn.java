package by.gsu.epamlab.beans;

import by.gsu.epamlab.exceptions.NegativeArgumentExceprion;

public class Byn implements Comparable <Byn> {

	private int value; 
	
	public Byn() {
		value =0;
	}
	
	public Byn(int value) throws NegativeArgumentExceprion{
		if (value < 0) {
			throw new NegativeArgumentExceprion(value);
		} else 
		this.value = value;		
	}
	
	public Byn(int rubs, int coins) {
		this(rubs*100+coins);
	}
	
	public Byn(Byn byn) {
		this(byn.value);
	}
	
	public int getRubs() {
		return value / 100;
	}
	
	public int getCoins() {
		return value % 100;
	}
	
	public final Byn add(Byn byn) {
		return new Byn (value + byn.value);
	}
	
	public final Byn sub(Byn byn) {
		return new Byn (value - byn.value);
	}
	
	public final Byn mul(int k) {
		return new Byn (value*k);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Byn other = (Byn) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	public int compareTo(Byn byn) {
		return value - byn.value;
	}
	
	@Override
	public String toString() {
		return String.format("%d.%02d", getRubs(), getCoins());
	}
}
