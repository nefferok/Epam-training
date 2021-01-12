package by.gsu.asoilab.beans;

import static by.Constants.DELIMITER;

public class DiscountProduct extends Product{

	private Byn discount;
	
	public DiscountProduct() {
		discount = new Byn();
	}

	public DiscountProduct(String name, Byn price, Byn discount) {
		super(name, price);
		this.discount = discount;	
	}
	
	public DiscountProduct(String name, int price, int discount) {
		super(name, price);
		this.discount = new Byn(discount);	
	}
	
	public Byn getDiscount() {
		return discount;
	}

	@Override
	public Byn getPrice() {
		return super.getPrice().sub(discount);
	}
	
	@Override
	public String toString() {
		return super.toString() + DELIMITER + discount;
	}
}
