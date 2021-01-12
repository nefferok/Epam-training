import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import static by.Constants.*;
import by.gsu.epamlab.beans.Byn;
import by.gsu.epamlab.beans.PricePurchase;
import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.factory.PurchasesFactory;
import by.gsu.epamlab.interfaces.EntryChecker;
import by.gsu.epamlab.enums.Weekday;

public class Runner {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(new FileReader(FILE_PATH))) {

			Map<Purchase, Weekday> lastPurchaseMap = new HashMap<>();
			Map<Purchase, Weekday> firstPurchaseMap = new HashMap<>();
			List<PricePurchase> pricePurchase = new ArrayList<>();
			Map<Weekday, List<Purchase>> dayPurchasesMap = new EnumMap<>(Weekday.class);

			while (sc.hasNextLine()) {
				Purchase pur = PurchasesFactory.getPurchaseFromFactory(sc.nextLine());
				Weekday day = Weekday.valueOf(sc.nextLine());

				// 1.load data into the map where a purchase is a key and a weekday of last
				// purchase is a value;
				lastPurchaseMap.put(pur, day);

				// 3. load data into the map where a purchase is a key and a weekday of first
				// purchase is a value;
				if (!firstPurchaseMap.containsKey(pur)) {
					firstPurchaseMap.put(pur, day);
				}

				// 10. load instances of the subclass PricePurchase into the list;
				if (pur instanceof PricePurchase) {
					pricePurchase.add((PricePurchase) pur);
				}

				// 12. load the data into the enumerated map where a weekday is a key and
				// purchases list for this weekday is a value;
				List<Purchase> purchases = dayPurchasesMap.get(day);
				if (purchases == null)
					dayPurchasesMap.put(day, purchases = new ArrayList<Purchase>());
				purchases.add(pur);
			}

			// 2. 4. print both map by for–each cycle;
			printMap(firstPurchaseMap, FIRST_PUR_TITLE);
			printMap(lastPurchaseMap, LAST_PUR_TITLE);

			// 5. find the first and the last weekdays for bread with price 1.55;
			Purchase required = new Purchase(REQ_PUR_NAME, REQ_PUR_PRICE_1, REQ_PUR_AMOUNT);
			findAndShow(firstPurchaseMap, required, FIRST_DAY);
			findAndShow(lastPurchaseMap, required, LAST_DAY);

			// 6. find the first weekday for bread with price 1.70;
			required = new Purchase(REQ_PUR_NAME, REQ_PUR_PRICE_2, REQ_PUR_AMOUNT);
			findAndShow(firstPurchaseMap, required, FIRST_DAY);

			// 7. remove all entries from the first map where the purchase name is meat;
			removeEntries(lastPurchaseMap, new EntryChecker<Purchase, Weekday>() {
				@Override
				public boolean check(Entry<Purchase, Weekday> entry) {
					return entry.getKey().getName().equals(REQ_PUR_NAME_2);
				}
			});

			// 8. remove all entries from the second map on FRIDAY;
			removeEntries(firstPurchaseMap, new EntryChecker<Purchase, Weekday>() {
				@Override
				public boolean check(Entry<Purchase, Weekday> entry) {
					return entry.getValue() == Weekday.FRIDAY;
				}
			});

			// 9. print maps by for–each cycle;
			printMap(firstPurchaseMap, FIRST_PUR_CHANGED_TITLE);
			printMap(lastPurchaseMap, LAST_PUR_CHANGED_TITLE);

			// 11. print the total cost of these purchases;
			System.out.println(LIST_TOTAL_COST + getTotalCost(pricePurchase));

			// 13. print the map by for–each cycle;
			printMap(dayPurchasesMap, ENUM_MAP_TITLE);

			// 14. print the total cost of all purchases for each weekday;
			System.out.println(TOTAL_COST_TITLE);
			for (Entry<Weekday, List<Purchase>> entry : dayPurchasesMap.entrySet()) {
				System.out.println(entry.getKey() + TOTAL_COST + getTotalCost(entry.getValue()));
			}
			
			//15. find all purchases on MONDAY.
			findAndShow(dayPurchasesMap, Weekday.MONDAY, ALL_PURCHASES_TITLE);

			// 16. BONUS remove all entries from the enumerated map where the purchase name
			// is milk;
			removeEntries(dayPurchasesMap, new EntryChecker<Weekday, List<Purchase>>() {
				@Override
				public boolean check(Entry<Weekday, List<Purchase>> entry) {
					boolean result = false;
					for (Purchase pur : entry.getValue()) {
						if (pur.getName().equals(REQ_PUR_NAME_3)) {
							result = true;
							break;
						}
					}
					return result;
				}
			});

			// 17. print the map by for–each cycle;
			printMap(dayPurchasesMap, ENUM_MAP_CHNG_TITLE);

		} catch (FileNotFoundException e) {
			System.err.println(FILE_NOT_FOUND);
		}
	}

	private static <K, V> void printMap(Map<K, V> map, String headline) {
		System.out.println(headline);
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ARRAW + entry.getValue());
		}
	}

	private static <K, V> void findAndShow(Map<K, V> map, K searchKey, String headline) {
		V entry = map.get(searchKey);
		System.out.println(entry != null ? headline + entry : NOT_FOUND);
	}

	private static <K, V> void removeEntries(Map<K, V> map, EntryChecker<K, V> checker) {
		for (Iterator<Map.Entry<K, V>> it = map.entrySet().iterator(); it.hasNext();)
			if (checker.check(it.next()))
				it.remove();
	}

	private static Byn getTotalCost(List<? extends Purchase> list) {
		Byn totalCost = new Byn();
		for (Purchase e : list) {
			totalCost = totalCost.add(e.getCost());
		}
		return totalCost;
	}
}
