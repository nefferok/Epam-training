package by.gsu.epamlab.preferenses;

import java.util.Comparator;

import by.gsu.epamlab.beans.PriceDiscontPurchase;
import by.gsu.epamlab.beans.Purchase;

public abstract class SortCriterion {
	private static final int EQUAL = 0;
	private static final int MORE = 1;
	private static final int LESS = -1;

	public static class PurchaseComparatorV1 implements Comparator<Purchase> {
		@Override
		public int compare(Purchase o1, Purchase o2) {
			if (compareName(o1, o2) == EQUAL) {
				if (isDiscount(o1) && !(isDiscount(o2))) {
					return MORE;
				} else if (!(isDiscount(o1)) && isDiscount(o2)) {
					return LESS;
				} else
					return compareCost(o1, o2);
			} else
				return compareName(o1, o2);
		}
	}

	public static class PurchaseComparatorV2 implements Comparator<Purchase> {
		@Override
		public int compare(Purchase o1, Purchase o2) {
			if (compareName(o1, o2) == EQUAL) {
				if (compareClasses (o1, o2)) {
					return compareCost(o1, o2);
				} else if (o1.getClass() == Purchase.class && !(compareClasses(o1, o2)))
					return LESS;
				else
					return MORE;
			} else
				return compareName(o1, o2);
		}
	}
	
	private static int compareName(Purchase o1, Purchase o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
	private static int compareCost(Purchase o1, Purchase o2) {
		return o1.getCost().compareTo(o2.getCost());
	}
	
	private static boolean isDiscount(Purchase obj) {
		return obj instanceof PriceDiscontPurchase;
	}
	
	private static boolean compareClasses(Purchase o1, Purchase o2) {
		return o1.getClass() == o2.getClass();
	}

}
