import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurhasesFactory;

public class Runner {
	public static void main(String[] args) {
		
		Scanner scanner = null;
		
		try {
			// create an array
			final int PURCHASES_NUMBER = 6;
			Purchase [] purchases = new Purchase [PURCHASES_NUMBER];
			
			//create a scanner
			final String FILE_PATH = "src/in.txt";
			scanner = new Scanner (new File(FILE_PATH));
			scanner.useLocale(Locale.ENGLISH);
			
			int maxIndex = 0; 
			boolean areEqual = true;
			
			//input data in array
			for (int i = 0; i < purchases.length; i++ ) {
				purchases [i] = PurhasesFactory.getPurchaseFromFactory(scanner);
				if(purchases[maxIndex].getCost().compareTo(purchases[i].getCost()) < 0){
					maxIndex = i; 
				}
				if (areEqual) { // check are all the elements equal
					areEqual = purchases[i].equals(purchases[0]);
				}
				System.out.println(purchases[i]);
			}
			
			System.out.println("\nThe purchase with maximum cost:\n" + purchases[maxIndex]);
			
			if (areEqual) {
				System.out.println("\nAll purchase are equal");
			} else {
				System.out.println("\nAll purchase are not equal");
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Input file is not found");
			
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
