package by.gsu.asoilab.utilites;

import by.gsu.asoilab.beans.Byn;

import by.gsu.asoilab.beans.Purchase;
import by.gsu.asoilab.interfases.Priceable;

import static by.Constants.*;

public class PurchaseUtils <T extends Priceable, N extends Number>{

	private Purchase<T, N>  purchase;

	public PurchaseUtils(Purchase <T, N> purchase) {
		this.purchase = purchase;
	}

	public Purchase <T, N> getPurchase() {
		return purchase;
	}

	public void printPurchase() {
		System.out.println(purchase);
	}

	public void printCost() {
		System.out.println(COST + purchase.getCost() + BYN);
	}

	public void printCostDiff(Purchase<? extends Priceable, ? extends Number> pur) {
		StringBuilder str = new StringBuilder();		
		Byn greaterCost = purchase.getCost();
		Byn lesserCost = pur.getCost();	
		int compRes = greaterCost.compareTo(lesserCost);
		if (compRes < 0) {
			greaterCost = pur.getCost();
			lesserCost = purchase.getCost();
			str.append(NEGATIVE);
		} else if (compRes > 0) str.append(POSITIVE);
		Byn costDiff = greaterCost.sub(lesserCost);
		System.out.println(str + DIFF + costDiff + BYN);
	}

	@SuppressWarnings("unchecked")
	public void printIsSameCost(Purchase <? extends Priceable, ? extends Number> ... purchases) {
		boolean result = false;
		for (Purchase<? extends Priceable, ? extends Number> pur : purchases) {
			if (purchase.getCost().equals(pur.getCost())) {
				result = true;
				break;
			}
		}
		System.out.println(result ? CONTAIN : NOT_CONTAIN);
	}
}
