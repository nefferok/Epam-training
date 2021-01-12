package by.gsu.asoilab.beans;

import by.Constants;
import by.gsu.asoilab.enums.RoundMethod;

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
		this (rubs * Constants.COINS_IN_RUB + coins);
	}
	
	public Byn(Byn byn) {
		this(byn.value);
	}
	
	public int getRubs() {
		return value / Constants.COINS_IN_RUB;
	}
	
	public int getCoins() {
		return value % Constants.COINS_IN_RUB;
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
	
	public Byn mul(Number k, RoundMethod roundMethod, int d) {
		return new Byn(roundMethod.round(value * k.doubleValue(), d));
	}
	
	public Byn mul(Number k) {
		return mul(k, RoundMethod.ROUND, 0);
	}
	
	public Byn mul(double k){
		return mul(k, RoundMethod.ROUND, 0);
	}
	
	public Byn mul(double k, RoundMethod roundMethod, int d){
		return new Byn(roundMethod.round(value * k, d));
	}
	
	public Byn div(int k, RoundMethod roundMethod, int d) {
		return new Byn(roundMethod.round((double) value/k, d));
	}
	
	public Byn div(double k, RoundMethod roundMethod, int d) {
		return new Byn(roundMethod.round(value/k, d));
	}
	
	public Byn div(double k) {
		return div(k, RoundMethod.CEIL, 0);
	}
	
	public Byn div(int k) {
		return div(k, RoundMethod.CEIL, 0);
	}
	
	public Byn round(RoundMethod roundMethod, int d) {
		return new Byn (roundMethod.round(value, d));
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
