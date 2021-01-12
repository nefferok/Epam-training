package by.gsu.epamlab;

public class TransportExpensesPurchase extends AbstractPurchase{
	
	private Byn expenses;
	
	public TransportExpensesPurchase() {
		super();
		this.expenses = new Byn();
	}
	
	public TransportExpensesPurchase(Product product, int number, Byn expenses) {
		super(product, number);
		this.expenses = expenses;
	}
	
	public TransportExpensesPurchase(String name, Byn byn, int number, Byn expenses) {
		super(name, byn, number);
		this.expenses = expenses;
	}
	
	public TransportExpensesPurchase(String name, int byn, int number, Byn expenses) {
		super(name, byn, number);
		this.expenses = expenses;	
	}
	
	public TransportExpensesPurchase(Product product, int number, int expenses) {
		super(product, number);
		this.expenses = new Byn (expenses);
	}
	
	public TransportExpensesPurchase(String name, Byn byn, int number, int expenses) {
		super(name, byn, number);
		this.expenses = new Byn (expenses);
	}
	
	public TransportExpensesPurchase(String name, int byn, int number, int expenses) {
		super(name, byn, number);
		this.expenses = new Byn (expenses);
	}

	public Byn getExpenses() {
		return expenses;
	}

	public void setExpenses(Byn expenses) {
		this.expenses = expenses;
	}
	
	public void setExpenses(int expenses) {
		this.expenses = new Byn(expenses);
	}
	
	@Override
	protected Byn getFinalCost(Byn baseCost) {
		return baseCost.add(expenses);
	}

	@Override
	protected String fieldsToString() {
		return 	super.fieldsToString() + ";" + expenses;
	}
	
	

}
