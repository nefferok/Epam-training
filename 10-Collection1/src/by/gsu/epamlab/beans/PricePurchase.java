package by.gsu.epamlab.beans;

import by.Constants;

public class PricePurchase extends Purchase{
	
	private Byn discount;
	
	public PricePurchase() {
	}

	public PricePurchase(String name, Byn byn, int number, int discount) {
		super(name, byn, number);
		this.discount = new Byn (discount);	
	}
	
	public PricePurchase(String name, int byn, int number, int discount) {
		this(name, new Byn(byn), number, discount);	
	}
	
	public Byn getDiscount() {
		return discount;
	}

	public void setDiscount(Byn discount) {
		this.discount = discount;
	}

	@Override
	public Byn getCost() {
		return super.getCost().sub(discount.mul(getNumber()));
	}
	
	@Override
	protected String fieldsToString() {
		return 	super.fieldsToString() + Constants.DELIMITER + discount;
	}

}
