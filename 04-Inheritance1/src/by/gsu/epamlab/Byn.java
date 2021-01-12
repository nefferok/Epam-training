package by.gsu.epamlab;

import java.util.Scanner;

public class Byn implements Comparable <Byn> {
	private int value; 
	
	public Byn() {
		value =0;
	}
	
	public Byn(int value) {
		this.value = value;
	}
	
	public Byn(int rubs, int coins) {
		this (rubs*100 + coins);
	}
	
	public Byn(Byn byn) {
		this(byn.value);
	}
	
	public Byn(Scanner scanner) {
		this(scanner.nextInt());
	}
	
	public int getRubs() {
		return value / 100;
	}
	
	public int getCoins() {
		return value % 100;
	}
	
	public Byn add(Byn byn) {
		value += byn.value;
		return this;
	}
	
	public Byn sub(Byn byn) {
		value -= byn.value;
		return this;
	}
	
	public Byn mul(int k) {
		value *= k;
		return this;
	}
	
	public Byn mul(double k, RoundMethod roundMethod, int d){
		value = roundMethod.round(value * k, d);
		return this;
	}

	public Byn round(RoundMethod roundMethod, int d) {
		value = roundMethod.round(value, d);
		return this;
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
