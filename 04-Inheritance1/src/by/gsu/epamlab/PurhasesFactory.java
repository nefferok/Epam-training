package by.gsu.epamlab;

import java.util.Scanner;

public class PurhasesFactory {
	private static enum PurchaseKind {
		GENERAL_PURCHASE{
			Purchase getPurchase(Scanner scanner) {
				return new Purchase (scanner);
			}
		},
		PRICE_DISCOUNT_PURCHASE{
			Purchase getPurchase(Scanner scanner) {
				return new PriceDiscontPurchase (scanner);
			}
		},
		PERCENT_DISCOUNT_PURCHASE{
			Purchase getPurchase(Scanner scanner) {
				return new PercentDiscontPurchase (scanner);
			}
		};
		abstract Purchase getPurchase(Scanner scanner);
	}
	
	public static Purchase getPurchaseFromFactory(Scanner scanner) {
		String id = scanner.next();
		return PurchaseKind.valueOf(id).getPurchase(scanner);
	}
}
