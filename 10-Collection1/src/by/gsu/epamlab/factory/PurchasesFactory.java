package by.gsu.epamlab.factory;

import static by.Constants.DISCOUNT_POSITION;
import static by.Constants.NAME_POSITION;
import static by.Constants.NUMBER_POSITION;
import static by.Constants.PRICE_POSITION;

import by.Constants;
import by.gsu.epamlab.beans.*;

public class PurchasesFactory {
	
	private final static int PURCHASE_FIELDS_NUMBER = Purchase.class.getDeclaredFields().length;

	public static Purchase getPurchaseFromFactory(String line){ // Factory for the valid file
		String[] elements = line.split(Constants.DELIMITER);
		
		String name = elements[NAME_POSITION];
		int priceInt = Integer.parseInt(elements[PRICE_POSITION]);
		int units = Integer.parseInt(elements[NUMBER_POSITION]);
		
			if (elements.length == PURCHASE_FIELDS_NUMBER) {
				return new Purchase(name, priceInt, units);
			} else {
				int discountInt = Integer.parseInt(elements[DISCOUNT_POSITION]);
				return new PricePurchase(name, priceInt, units, discountInt);
			}
	}
}
