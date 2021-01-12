package by.gsu.epamlab;

import static by.gsu.epamlab.Utilit.convertToRuble;

import java.io.File;
import java.util.Scanner;

public class Purchase implements Comparable <Purchase>{


	public static final String PRODUCT_NAME;
	public static final int PRICE;
	public static final String FILE_NAME = "src/by/gsu/epamlab/constants.txt";
	private static final String DEFAULT_PRODUCT_NAME = "milk";
	private static final int DEFAULT_PRICE = 120;
	
	private int number;
	private double discountPercent;
	private WeekDay weekDay;

	static {
		Scanner scanner = null;
		String name = null;
		int cost = 0;
		try {		
			scanner = new Scanner(new File(FILE_NAME));
			name = scanner.nextLine();
			cost = scanner.nextInt();
			
		} catch (Exception e) {
			name = DEFAULT_PRODUCT_NAME;
			cost = DEFAULT_PRICE;
		} finally {
			PRODUCT_NAME = name;
			PRICE = cost;
			
			if (scanner != null) {
				scanner.close();
			}
		}	
	}
	
	public Purchase(int number, double discountPersent, WeekDay weekDay) {		
		this.number = number;
		this.discountPercent = discountPersent;
		this.weekDay = weekDay;
	}
	
	public Purchase(int number, double discountPersent, int day) {	
		this(number, discountPersent, WeekDay.values()[day]);
	}
	
	public Purchase() {		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getDiscountPersent() {
		return discountPercent;
	}

	public void setDiscountPersent(int discountPersent) {
		this.discountPercent = discountPersent;
	}

	public WeekDay getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
	}
	
	public int getCost() {		
		return (int) Math.round(PRICE*number*(100-discountPercent)/10000)*100;
	}
	
	@Override
	public String toString() {
		return 	number + ";"	+
				discountPercent + ";" +
				weekDay + ";" +
				convertToRuble(getCost());
	}
	
	public int compareTo(Purchase purchase) {
		return number - purchase.number;
	}
}
