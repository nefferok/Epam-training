package by.gsu.epamlab.preferenses;

import java.util.Formatter;

import by.Constants;
import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.beans.PurchasesList;


public abstract class Utilit {
	private static StringBuilder printTitle(String [] title) {
		StringBuilder table = new StringBuilder();
		Formatter f = new Formatter();
		f.format(Format.formFullFormat(), title);
		table.append(f);
		return table;
	}
	
	private static StringBuilder printFinal(PurchasesList purchases) {
		StringBuilder table = new StringBuilder();
		Formatter f = new Formatter();
		f.format(Constants.FINAL_PATTERN, purchases.getTotalCost());
		table.append(f);
		return table;		
	}
	
	public static String printTable(String [] title, PurchasesList purchases) {
		StringBuilder table = printTitle(title);
		table.append(purchases.toTable());
		table.append(printFinal(purchases));
		return table.toString();
	}
	
	public static void  printSerchingResult(int index, Purchase required) {
		if (index < 0) {
			System.out.printf(Constants.ISNT_FOUND, required);
		} else
			System.out.printf(Constants.FOUND, required, index);
	}
}
