package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscontPurchase extends Purchase{
	
	private Byn discount;
	
	public PriceDiscontPurchase() {
		super();
	}

	public PriceDiscontPurchase(String name, Byn byn, int number, int discount) {
		super(name, byn, number);
		this.discount = new Byn (discount);	
	}
	
	public PriceDiscontPurchase(Scanner scanner) {
		super(scanner);
		this.discount = new Byn(scanner);
	}
	
	public Byn getDiscount() {
		return discount;
	}

	public void setDiscount(Byn discount) {
		this.discount = discount;
	}

	@Override
	public Byn getCost() {
		return super.getCost().sub(new Byn(discount).mul(getNumber()));
	}
	
	@Override
	protected String fieldsToString() {
		return 	super.fieldsToString() + ";" + discount;
	}

}
