package by.gsu.epamlab;

import static by.gsu.epamlab.RoundMethod.ROUND;

public class PercentDiscountPurchase extends AbstractPurchase{
	
	private double percent;
	private static final int MINIMAL_AMOUNT = 10;
	
	public PercentDiscountPurchase() {
		super();
		this.percent = 0.0;
	}
	
	public PercentDiscountPurchase(Product product, int number, double percent) {
		super(product, number);
		this.percent = percent;
	}

	public PercentDiscountPurchase(String name, Byn byn, int number, double percent) {
		super(name, byn, number);
		this.percent = percent;	
	}
	
	public PercentDiscountPurchase(String name, int byn, int number, double percent) {
		super(name, byn, number);
		this.percent = percent;	
	}
	
	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	@Override
	protected Byn getFinalCost(Byn baseCost) {
 		if (getNumber() > MINIMAL_AMOUNT) {
 			baseCost = baseCost.mul(1 - percent / 100, ROUND, 0);
		}
		return baseCost;
	}

	@Override 
	protected String fieldsToString() {
		return 	super.fieldsToString() + ";" + percent;
	}	
}
