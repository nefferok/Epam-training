package by.gsu.epamlab;

public class PriceDiscountPurchase extends AbstractPurchase{
	private Byn discount;

	public PriceDiscountPurchase() {
		super();
		this.discount = new Byn();
	}

	public PriceDiscountPurchase(Product product, int number, Byn discount) {
		super(product, number);
		this.discount = discount;
	}
	
	public PriceDiscountPurchase(String name, Byn byn, int number, Byn discount) {
		super(name, byn, number);
		this.discount = discount;	
	}
	
	public PriceDiscountPurchase(String name, int byn, int number, Byn discount) {
		super(name, byn, number);
		this.discount = discount;	
	}
	
	public PriceDiscountPurchase(Product product, int number, int discount) {
		super(product, number);
		this.discount = new Byn (discount);
	}
	
	public PriceDiscountPurchase(String name, Byn byn, int number, int discount) {
		super(name, byn, number);
		this.discount = new Byn (discount);	
	}
	
	public PriceDiscountPurchase(String name, int byn, int number, int discount) {
		super(name, byn, number);
		this.discount = new Byn (discount);	
	}

	public Byn getDiscount() {
		return discount;
	}

	public void setDiscount(Byn discount) {
		this.discount = discount;
	}
	
	public void setDiscount(int discount) {
		this.discount = new Byn(discount);
	}
	
	@Override
	protected Byn getFinalCost(Byn baseCost) {	
		return baseCost.sub(discount.mul(getNumber()));
	}
	
	@Override
	protected String fieldsToString() {
		return 	super.fieldsToString() + ";" + discount;
	}

}
