package by;

public class Constants {
	
	public static final int MAIN_FAIL_POSITION;
	public static final int ADDON_POSITION;
	public static final int COMPARATOR_POSITION;
	
	public static final int NAME_POSITION;
	public static final int PRICE_POSITION;
	public static final int NUMBER_POSITION;
	public static final int DISCOUNT_POSITION;
	public static final int COST_POSITION;
	public static final int EMPTY_POSITION;
	
	public static final int PURCHASE_LENGTH;
	public static final int DISCOUNT_LENGTH;
	
	public static final String NAME_FORMAT;
	public static final String PRICE_FORMAT;
	public static final String NUMBER_FORMAT;
	public static final String DISCOUNT_FORMAT;
	public static final String COST_FORMAT;
	
	public static final String SPLITTER;
	
	public static final String[] TITLE = { "Name", "Price", "Number", "Discount", "Cost" };
	public static final String FINAL_PATTERN;
	
	public static final String ISNT_FOUND = "\nPurchase %s isn't found";
	public static final String FOUND = "\nPurchase %s is found at position %d";
	
	public static final String ARGUMENT_QUANTITY =  " wrong number of arguments";
	public static final String WRONG_PARAMETR = " wrong parameter";
	public static final String EMPTY_NAME = " empty name";
	public static final String ARROW = "\t -> ";
	public static final String NON_POSITIVE_MESSAGE= " non positive value ";
	public static final String IN= " in ";
	public static final String NEGATIVE_COST = " the discount is bigger then price";
	public static final int ZERO = 0;
	public static final String STUB = "-";
	public static final String NEGATIVE_VALUE = " negative value ";
	public static final String FILE_NOT_FOUND = "File %s.in is not found";
	
	static {
		MAIN_FAIL_POSITION = 0;
		ADDON_POSITION = 1;
		COMPARATOR_POSITION = 2;
		
		NAME_POSITION = 0;
		PRICE_POSITION = 1;
		NUMBER_POSITION = 2;
		DISCOUNT_POSITION = 3;
		COST_POSITION = 4;
		EMPTY_POSITION = -1;
		
		PURCHASE_LENGTH =3;
		DISCOUNT_LENGTH =4;
		
		NAME_FORMAT = "%-10.10s";
		PRICE_FORMAT = "%10s";
		NUMBER_FORMAT= "%10s";
		DISCOUNT_FORMAT= "%10s";
		COST_FORMAT= "%10s\n";
		FINAL_PATTERN = "Total cost%40s";
		
		SPLITTER = ";";
	}
}
