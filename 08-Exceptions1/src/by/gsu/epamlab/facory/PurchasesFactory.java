package by.gsu.epamlab.facory;

import static by.Constants.DISCOUNT_LENGTH;
import static by.Constants.DISCOUNT_POSITION;
import static by.Constants.NAME_POSITION;
import static by.Constants.NUMBER_POSITION;
import static by.Constants.PRICE_POSITION;
import static by.Constants.PURCHASE_LENGTH;

import by.Constants;
import by.gsu.epamlab.beans.PriceDiscontPurchase;
import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.exceptions.CsvLineException;

public class PurchasesFactory {

	public static Purchase getPurchaseFromFactory(String line) throws CsvLineException {
		String[] elements = line.split(Constants.SPLITTER);
		Purchase purchase = new Purchase();
		if (elements.length != PURCHASE_LENGTH && elements.length != DISCOUNT_LENGTH)
			throw new CsvLineException(line, Constants.ARGUMENT_QUANTITY);
		try {
			if (elements.length == PURCHASE_LENGTH) {
				purchase = new Purchase(elements[NAME_POSITION], Integer.parseInt(elements[PRICE_POSITION]),
						Integer.parseInt(elements[NUMBER_POSITION]));
			}
			if (elements.length == DISCOUNT_LENGTH) {
				purchase = new PriceDiscontPurchase(elements[NAME_POSITION], Integer.parseInt(elements[PRICE_POSITION]),
						Integer.parseInt(elements[NUMBER_POSITION]), Integer.parseInt(elements[DISCOUNT_POSITION]));
			}
			return purchase;
		} catch (NumberFormatException e) {
			throw new CsvLineException(line, Constants.WRONG_PARAMETR);
		} catch (RuntimeException e) {
			throw new CsvLineException(line, e);
		}
	}
}
