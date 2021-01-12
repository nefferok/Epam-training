package by.gsu.epamlab;

import static by.gsu.epamlab.RoundMethod.FLOOR;

public abstract class AbstractPurchase implements Comparable <AbstractPurchase>{
	
	private final Product product;
	private int number;
	
	public AbstractPurchase() {
		this (new Product(), 0);
	}
	
	public AbstractPurchase(Product product, int number) {
		this.product = product;
		this.number = number;
	}
	
	public AbstractPurchase(String name, Byn byn, int number) {
		this.product = new Product(name, byn);
		this.number = number;
	}
	
	public AbstractPurchase(String name, int byn, int number) {
		this.product = new Product(name, byn);
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	protected abstract Byn getFinalCost(Byn baseCost);
	
	public Byn getCost() {
			Byn baseCost = product.getPrice().mul(number);
			Byn finalCost = getFinalCost(baseCost);
			return finalCost.round(FLOOR, 2);
	}

	protected String fieldsToString() {
		return 	product + ";" +
				number;
	}
	
	@Override
	public String toString() {
		return fieldsToString() + ";" + getCost();
	}
	
	@Override
	public int compareTo(AbstractPurchase purchase) {
		return purchase.getCost().compareTo(getCost());
	}
}
