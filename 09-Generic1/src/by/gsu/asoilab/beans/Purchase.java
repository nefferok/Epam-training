package by.gsu.asoilab.beans;

import by.gsu.asoilab.interfases.Priceable;
import static by.Constants.DELIMITER;

public class Purchase <T extends Priceable, N extends Number>{

	
	private T item;
	private N quantity;

	public Purchase(T item, N quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public Purchase(Purchase <T, N> purchase) {
		this(purchase.item, purchase.quantity);
	}
	

	public T getItem() {
		return item;
	}

	public N getQuantity() {
		return quantity;
	}

	public Byn getCost() {
		return item.getPrice().mul(quantity);
	}

	@Override
	public String toString() {
		return item + DELIMITER + quantity + DELIMITER + getCost();
	}
}
