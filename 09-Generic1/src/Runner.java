
import by.gsu.asoilab.beans.DiscountProduct;
import by.gsu.asoilab.beans.Product;
import by.gsu.asoilab.beans.Purchase;
import by.gsu.asoilab.beans.Service;
import by.gsu.asoilab.utilites.PurchaseUtils;

import static by.Constants.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {	
		

		// Create the purchase of 20 packages of milk with the price 1.70 BYN.
		Purchase<Product, Integer> p1 = new Purchase<Product, Integer>(new Product(MILK, MILK_PRICE), MILK_QUNTITY);
		
		//Output p1 and its cost with the PurchaseUtils instance pu1. 
		PurchaseUtils <Product, Integer> pu1 = new PurchaseUtils <Product, Integer> (p1);
		pu1.printPurchase();
		pu1.printCost();
		
		//Create the purchase of 12.5 kg of sugar with the price 3.00 BYN.
		Purchase<Product, Double> p2 = new Purchase<Product, Double>(new Product(SUGAR, SUGAR_PRICE_1), KG_1);
		
		//Output the cost of p2 and the cost difference of p2 and p1.
		PurchaseUtils <Product, Double> pu2 = new PurchaseUtils <Product, Double> (p2);
		pu2.printCost();
		pu2.printCostDiff(p1);
			
		//Create the purchase of 60 kg of sugar with the price 2.80 BYN and the price discount 0.10 BYN.
		Purchase<DiscountProduct, Integer> p3 = new Purchase<DiscountProduct, Integer>(new DiscountProduct(SUGAR, SUGAR_PRICE_2, SUG_DIS), KG_2);
		
		//Without a Purchase instance create the PurchaseUtils instance pu4 for the gym workout for 2.25 months with the total cost 75.60 BYN and 5 participants.
		PurchaseUtils <Service, Double> pu4 = new PurchaseUtils<Service, Double>(new Purchase<Service, Double>(new Service(GYM, GYM_TOT_PR, GYM_USERS), MONTH));
		
		//Get an item instance from the last purchase with the PurchaseUtils instance pu4 and output it. 
		Service service = pu4.getPurchase().getItem();
		System.out.println(service);
		
		//Output the cost of the last purchase with a PurchaseUtils instance. 
		pu4.printCost();
		
		//Using a PurchaseUtils instance, output whether someone of p1, p3 or the last purchase has the same cost like p2 purchase.
		pu2.printIsSameCost(p1, p3, pu4.getPurchase());
		

	}
}
