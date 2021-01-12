package by;

public class Constants {
	public static final int NAME_POSITION;
	public static final int PRICE_POSITION;
	public static final int NUMBER_POSITION;
	public static final int DISCOUNT_POSITION;
	
	public static final int COINS_IN_RUB = 100;
	public static final String PRINT_PATTERN  = "%d.%02d";
	public static final String DELIMITER = ";";
	public static final int PRIME_COLLISION = 31;
	public static final int START_HASH_RES = 1;
	
	public static final String EMPTY_STRING = "";
	public static final String ARRAW = "=>";
	public static final String NEW_STRING = "\n";
	public static final String TOTAL_COST = " total cost = ";
	public static final String FILE_PATH = "src/in.csv";
	public static final String FILE_NOT_FOUND = "Input file is not found";
		
	public static final String FIRST_PUR_TITLE = "\tFirst purchase map:";
	public static final String LAST_PUR_TITLE = "\n\tLast purchase map:";
	public static final String ENUM_MAP_TITLE = "\n\tEnumerated map:";
	public static final String ENUM_MAP_CHNG_TITLE = "\n\tChanged enumerated map:";
	public static final String FIRST_PUR_CHANGED_TITLE = "\n\tFirst purchase changed map:";
	public static final String LAST_PUR_CHANGED_TITLE = "\n\tLast purchase changed map:";
	public static final String FIRST_DAY = "\nThe first day for required purchase: ";
	public static final String LAST_DAY = "The last day for required purchase: ";
	public static final String TOTAL_COST_TITLE = "\n\tThe total cost for each weekday:";
	public static final String LIST_TOTAL_COST = "\nThe total cost for list: ";
	public static final String ALL_PURCHASES_TITLE = "\n\tAll purchases on MONDAY:\n";
	
	public static final String REQ_PUR_NAME = "bread";
	public static final String REQ_PUR_NAME_2 = "meat";
	public static final String REQ_PUR_NAME_3 = "milk";
	public static final int REQ_PUR_PRICE_1 = 155;
	public static final int REQ_PUR_PRICE_2 = 170;
	public static final int REQ_PUR_AMOUNT = 0;
	
	public static final String MEAT = "meat";
	public static final String NOT_FOUND = "The required purchase is not found";
	
	static {	
		NAME_POSITION = 0;
		PRICE_POSITION = 1;
		NUMBER_POSITION = 2;
		DISCOUNT_POSITION = 3;
	}
}
