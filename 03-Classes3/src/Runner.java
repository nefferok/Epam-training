import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.WeekDay;

import static by.gsu.epamlab.Utilit.convertToRuble;

public class Runner {
	public static void main(String[] args) {

		Scanner scanner = null;
		final String FILE_PATH = "src/in.txt";

		try {
			scanner = new Scanner(new File(FILE_PATH));
			scanner.useLocale(Locale.ENGLISH);

			//1 create an array			
			final int PURCHASES_NUMBER = scanner.nextInt();
			Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

			//2 Initialize array
			for (int i = 0; i < PURCHASES_NUMBER; i++) {
				int number = scanner.nextInt();
				double percent = scanner.nextDouble();
				int weeksDay = scanner.nextInt();
				purchases[i] = new Purchase(number, percent, weeksDay);
			}

			//3 Output the array
			printPurchases(purchases);

			//4 Calculate the mean cost, total cost on Monday, maximum cost
			double totalCost = 0;
			int costOnMonday = 0;
			WeekDay maxCostDay = null;
			int maxCost = 0;
			
			for (Purchase purchase : purchases) {
				int cost = purchase.getCost();
				totalCost += cost; // Sum of all costs
				if (purchase.getWeekDay()==WeekDay.MONDAY) { // Sum of all costs for Monday
					costOnMonday += cost;
				}
				if (cost > maxCost) { // Max cost day
					maxCost = cost;
					maxCostDay = purchase.getWeekDay();
				}
			}
			if (purchases.length > 0) {
				totalCost = totalCost / (purchases.length * 100);
			}			
			System.out.println("\nMeanCost = " + String.format(Locale.ENGLISH, "%.3f", totalCost) +
					"\nThe total cost on Monday = " + convertToRuble(costOnMonday) +
					"\nThe day with the maximum cost purchase is " + maxCostDay +"\n");

			//5 array sorting
			Arrays.sort(purchases);

			//6 Output sorted array
			printPurchases(purchases);

			//7 Search for element with number equaled 5
			Purchase required= new Purchase (5, 0, 0);
			int requiredElement = Arrays.binarySearch(purchases, required);
			if (requiredElement >= 0) {
				System.out.println("\nThe required purchase: " + purchases[requiredElement]);
			} else {
				System.out.println("Required purchase is not found");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Input file is not found");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
	private static void printPurchases(Purchase [] purchases) {
		System.out.println("Product: " + Purchase.PRODUCT_NAME + "; Price: " + convertToRuble(Purchase.PRICE));
		for (Purchase purchase : purchases) {
				System.out.println(purchase);
		}	
	}
}
