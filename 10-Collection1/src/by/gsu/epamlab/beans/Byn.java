package by.gsu.epamlab.beans;

import by.Constants;

import static by.Constants.COINS_IN_RUB;

public final class Byn implements Comparable <Byn> {
	
	private final int value;
	
	public Byn() {
		value = 0;
	}
	
	public Byn(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		} else this.value = value;
	}
	
	public Byn(int rubs, int coins) {
		this (rubs * COINS_IN_RUB + coins);
	}
	
	public Byn(Byn byn) {
		this(byn.value);
	}
	
	public int getRubs() {
		return value / COINS_IN_RUB;
	}
	
	public int getCoins() {
		return value % COINS_IN_RUB;
	}
	
	public Byn add(Byn byn) {
		return new Byn(value + byn.value);
	}
	
	public Byn sub(Byn byn) {
		return new Byn(value - byn.value);
	}
	
	public Byn mul(int k) {
		return new Byn(value * k);
	}
	
	@Override
	public int hashCode() {
		final int prime = Constants.PRIME_COLLISION;
		int result = Constants.START_HASH_RES;
		result = prime * result + value;
		return result;
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
		return String.format(Constants.PRINT_PATTERN, getRubs(), getCoins());
	}
}
