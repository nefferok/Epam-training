package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscontPurchase extends Purchase{
	
	private double percent;
	public static final int MINIMAL_AMOUNT = 20;
	
	public PercentDiscontPurchase() {
		super();
	}

	public PercentDiscontPurchase(String name, Byn byn, int number, double percent) {
		super(name, byn, number);
		this.percent = percent;	
	}
	
	public PercentDiscontPurchase(Scanner scanner) {
		super(scanner);
		this.percent = scanner.nextDouble();
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	@Override
	public Byn getCost() {
		Byn cost = super.getCost();
		if (getNumber() > MINIMAL_AMOUNT) {
			cost.mul(1 - percent / 100, RoundMethod.ROUND, 0);
		} 
		return cost;
	}
	
	@Override 
	protected String fieldsToString() {
		return 	super.fieldsToString() + ";" + percent;
	}		
}
