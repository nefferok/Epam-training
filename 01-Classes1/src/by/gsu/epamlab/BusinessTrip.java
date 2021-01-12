package by.gsu.epamlab;

public class BusinessTrip {

	private final static int DAILY_RATE = 700;
	private String account;
	private int expenses;
	private int daysNumber;
	
	public BusinessTrip() {
	}

	public BusinessTrip(String account, int expenses, int daysNumber) {
		this.account = account;
		this.expenses = expenses;
		this.daysNumber = daysNumber;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public int getTransport() {
		return expenses;
	}
	
	public void setTransport(int expenses) {
		this.expenses = expenses;
	}
	
	public int getDays() {
		return daysNumber;
	}
	
	public void setDays(int daysNumber) {
		this.daysNumber = daysNumber;;
	}
	
	public int getTotal() {
		return expenses + (DAILY_RATE * daysNumber);
	}
	
	private static String rubleConventor (int coins) {
		return String.format("%d.%02d", coins / 100, coins % 100);
	}

	public void show() {
		System.out.println("rate = " + rubleConventor(DAILY_RATE) + 
				"\naccaunt = " + account +
				"\ntranport = " + rubleConventor(expenses) + 
				"\ndays = " + daysNumber +
				"\ntotal = " + rubleConventor(getTotal())); 
	}
	
	@Override
    public String toString() {
		return String.format("%s;%s;%d;%s", account, 
				rubleConventor(expenses), 
				daysNumber, 
				rubleConventor(getTotal()));
	}
}
