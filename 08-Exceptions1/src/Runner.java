import by.Constants;
import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.beans.PurchasesList;
import by.gsu.epamlab.preferenses.Utilit;

public class Runner {
	
	private static final String WRONG_NUMBER_OF_ARGUMENT = "usage: java Runner NameOfMainFail NameOfAddonFile ComparatorVersion";
	private static final String AFTER_CREATION = "\nAfter creation\n\n";
	private static final String BEFORE_SORTING = "\nBefore sorting\n\n";
	private static final String AFTER_SORTING = "\nAfter sorting\n\n";
	
	public static void main(String[] args){
		
		if (args.length !=3) {
			System.err.println(WRONG_NUMBER_OF_ARGUMENT);
	         return;
		}

		// Read arguments
		final String FILE_NAME = args[Constants.MAIN_FAIL_POSITION];
		final String ADDON_NAME = args[Constants.ADDON_POSITION];
		final String COMPARATOR_VERSION = args[Constants.COMPARATOR_POSITION];

		// Create main PurchseList
		PurchasesList main = new PurchasesList(FILE_NAME);
		
		main.buildPurchaseComparator(COMPARATOR_VERSION);
		
		// Print the collection
		System.out.println(AFTER_CREATION + Utilit.printTable(Constants.TITLE, main));

		// Create addon PurchasseList
		PurchasesList addon = new PurchasesList(ADDON_NAME);

		//Add the last element of the addon at the 0 position
		main.addPurchase(addon.get(addon.size() - 1), 0);
		//Add the initial element of the addon at the position 1000
		main.addPurchase(addon.get(0), 1000);
		//Add the element with index 2 of the addon at the position 2
		main.addPurchase(addon.get(2), 2);

		//delete elements with index 3, 10 and -5
		main.deletePurchase(3);
		main.deletePurchase(10);
		main.deletePurchase(-5);
		
		// Print the collection
		System.out.println(BEFORE_SORTING + Utilit.printTable(Constants.TITLE, main));

		// Sort the collection
		main.sort();

		// Print the collection
		System.out.println(AFTER_SORTING + Utilit.printTable(Constants.TITLE, main));
		
		// Searching of the necessary element
		Purchase required = addon.get(1);
		int index = main.searchPurchase(required);
		Utilit.printSerchingResult(index, required);
		
		required = addon.get(3);
		index = main.searchPurchase(required);
		Utilit.printSerchingResult(index, required);		
	}
}
