package by.gsu.asoilab.beans;

import by.gsu.asoilab.interfases.Priceable;
import by.Constants;

public class Product implements Priceable{
	
	private String name;
	private Byn price;
	
	public Product() {
		name = Constants.EMPTY_STRING;
		price = new Byn();
	}
	
	public Product(String name, Byn price) {
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, int price) {
		this(name, new Byn(price));
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Byn getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return name + Constants.DELIMITER + price;
	}
}
