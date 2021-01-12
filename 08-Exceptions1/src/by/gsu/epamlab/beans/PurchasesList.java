package by.gsu.epamlab.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import by.Constants;
import by.gsu.epamlab.exceptions.CsvLineException;
import by.gsu.epamlab.facory.PurchasesFactory;
import by.gsu.epamlab.preferenses.SortCriterion;

public class PurchasesList {
	private static final String COMPARATOR_PATH = "by.gsu.epamlab.SortCriterion$";

	private List<Purchase> purchases;
	private boolean isSorted;
	private static Comparator<Purchase> comp;

	public PurchasesList() {
		purchases = createEmptyList();
	}

	public PurchasesList(String fileName) {
		this();
		isSorted = false;
		final String PATH = "src/";
		final String FILE_TYPE = ".csv";
		Scanner scanner = null;
		
		try {
			
			scanner = new Scanner(new File(PATH + fileName + FILE_TYPE));
			scanner.useLocale(Locale.ENGLISH);
			
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				try {
					purchases.add(PurchasesFactory.getPurchaseFromFactory(line));
				} 
				catch (CsvLineException e) {
					System.err.println(e.toString());
				}	
			}
		} catch (FileNotFoundException e) {
			purchases = createEmptyList();
			System.err.printf(Constants.FILE_NOT_FOUND, fileName);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
	public ArrayList<Purchase> createEmptyList() {
		isSorted = true;
		return new ArrayList<Purchase>();
	}

	public List<Purchase> getPurchases(){
		List<Purchase> clone =  new ArrayList<Purchase>();
		for (Purchase purchase:purchases) {
			Purchase clonePurchase = purchase.getCopy();
			clone.add(clonePurchase);
		}
		return clone;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	public boolean isIndexCorrect(int index) {
		return (index < purchases.size() && index >= 0);
	}

	public Purchase get(int index) {
		if (!purchases.isEmpty()) {
			return purchases.get(index).getCopy();
		} else throw new RuntimeException();
	}

	public int size() {
		return purchases.size();
	}

	public void addPurchase(Purchase purchase, int position) {
		if (purchase != null) {
			if (position >= purchases.size()) {
				purchases.add(purchase);
			} else if (position < 0) {
				purchases.add(0, purchase);
			} else {
				purchases.add(position, purchase);
			}
			isSorted = false;
		} 
	}

	public void deletePurchase(int position) {
		if (isIndexCorrect(position)) {
			purchases.remove(position);
		}
	}

	public Byn getTotalCost() {
		Byn totalCost = new Byn(); 
		for (Purchase purchase : purchases) {
			totalCost = totalCost.add(purchase.getCost());
		}
		return totalCost;
	}

	public StringBuilder toTable() {
		StringBuilder table = new StringBuilder();
		if (!purchases.isEmpty()) {
			for (Purchase purchase : purchases) {
				table.append(purchase.toTable());
			}
		}
		return table;
	}
	
	@SuppressWarnings("unchecked")
	public final void buildPurchaseComparator(String version) {
		if (comp != null) {
			return;
		}	
		try {
			Class <?> compClass = Class.forName(COMPARATOR_PATH + version);
			comp = (Comparator<Purchase>) compClass.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			comp = new SortCriterion.PurchaseComparatorV1();
		}
	}

	public void sort() {
			Collections.sort(purchases, comp);
			isSorted =true;
	}

	public int searchPurchase(Purchase required) {
		if (isSorted == true) {
			return Collections.binarySearch(purchases, required, comp);
		} else {
			Collections.sort(purchases, comp);
			isSorted =true;
			return Collections.binarySearch(purchases, required, comp);
		}
	}
}
