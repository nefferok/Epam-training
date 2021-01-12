import java.util.Arrays;

import by.gsu.epamlab.AbstractPurchase;
import by.gsu.epamlab.Byn;
import by.gsu.epamlab.PercentDiscountPurchase;
import by.gsu.epamlab.PriceDiscountPurchase;
import by.gsu.epamlab.Product;
import by.gsu.epamlab.TransportExpensesPurchase;

public class Runner {	
	
	public static void main(String[] args) {
		final String UNSORTED = "Unsorted array";
		final String SORTED = "\nSorted array";
		final String FOUND = "\nThe required purchase: ";
		final String NOT_FOUND = "Required purchase is not found";
		final String MIN = "\nMinimum cost = ";
		
		//1. Creating an unique product
		final Product UNIQUE_PRODUCT = new Product("milk", 100);
		
		//2. Creating an array
		AbstractPurchase [] purchases = {
				new PriceDiscountPurchase(UNIQUE_PRODUCT, 6, 0),
				new PriceDiscountPurchase(UNIQUE_PRODUCT, 6, 0),
				new PercentDiscountPurchase(UNIQUE_PRODUCT, 6, 0),
				new PercentDiscountPurchase(UNIQUE_PRODUCT, 6, 0),
				new TransportExpensesPurchase(UNIQUE_PRODUCT, 6, 0),
				new TransportExpensesPurchase(UNIQUE_PRODUCT, 6, 0)				
		};
		
		//3. print unsorted array
		printPurchases(purchases, UNSORTED);
		
		//4. Sorting array
		Arrays.sort(purchases);
	
		//5.print sorted array
		printPurchases(purchases, SORTED);
		
		//6. The element with minimum cost
		System.out.println(MIN + purchases[purchases.length-1].getCost());
		
		//7. Searching element using binarySearch
		AbstractPurchase required = new PriceDiscountPurchase("", 500, 1, 0);
		int requiredElement = Arrays.binarySearch(purchases, required);
		if (requiredElement >= 0) {
			System.out.println(FOUND + purchases[requiredElement]);
		} else {
			System.out.println(NOT_FOUND);
		}
		//8. bonus
		AbstractPurchase artificialPurchase = new AbstractPurchase() {
			   @Override
			   public Byn getCost() {
			       return getFinalCost(new Byn());
			   }

			   @Override
			   protected Byn getFinalCost(Byn baseCost) {
			       return new Byn(501);
			   }
			};
			
			int startIndex = Arrays.binarySearch(purchases, artificialPurchase);		
			startIndex = Math.abs(startIndex + 1);
			boolean condition = true;
			
			if  (startIndex == 0 && purchases[startIndex].getCost().compareTo(new Byn(500)) == 0) {
				System.out.println("Found " + purchases[startIndex]);
				startIndex++;
			} else if (startIndex == 0 && purchases[startIndex].getCost().compareTo(new Byn(500)) != 0) {
				System.out.println("Not Found");
			}

			
			if (startIndex <= purchases.length - 1) {
				while (condition) {

					if (purchases[startIndex].getCost().compareTo(new Byn(500)) == 0) {
						System.out.println("Found " + purchases[startIndex]);
						startIndex++;
						if (startIndex == purchases.length) {
							condition = false;
						}
					} else {
						condition = false;
					}
				}			   
			} else {
				System.out.println("Not Found");
			}
	}

		//var1
		/*AbstractPurchase artificialPurchase = new AbstractPurchase() {
		       @Override
		       public Byn getCost() {
		           return getFinalCost(new Byn());
		       }

		       @Override
		       protected Byn getFinalCost(Byn baseCost) {
		           return new Byn(501);
		       }
		       
		   };*/
	/*	
		AbstractPurchase start = new AbstractPurchase() {
            @Override
            protected Byn getFinalCost(Byn baseCost) {
                return new Byn(600);
            }
        };
        AbstractPurchase finish = new AbstractPurchase() {
            @Override
            protected Byn getFinalCost(Byn baseCost) {
                return new Byn(400);
            }
        };

        int startIndex = Arrays.binarySearch(purchases, start);
        int finishIndex = Arrays.binarySearch(purchases, finish);

        startIndex = startIndex < 0 ? Math.abs(startIndex + 1) : startIndex + 1;
        finishIndex = finishIndex < 0 ? Math.abs(finishIndex + 1) : finishIndex;
        
        while (startIndex <= finishIndex) {
            if (purchases[startIndex].getCost().toString().equals("5.00")) {
                System.out.println(purchases[startIndex]);
                startIndex++;
            } else {
                startIndex++;
            }
        }
	}
		   
		   
		   //var2
		  /* int startIndex = Arrays.binarySearch(purchases, artificialPurchase);
		   System.out.println(startIndex);
		   startIndex = Math.abs(startIndex+1);
		   System.out.println(startIndex);
		   boolean condition = true;
		    do{
		       if(purchases[startIndex].getCost().compareTo(new Byn(500)) != 0) {
		           System.out.println("Not found");
		           condition = false;
		       }else if (){
		           System.out.println(""+ purchases[startIndex]);
		           startIndex++;
		           condition = true;
		       }
		   }while (condition);

		}*/

		
		
		/*var 3
		AbstractPurchase start = new PriceDiscountPurchase("", 600, 1 , 0);
		AbstractPurchase finish = new PriceDiscountPurchase("", 400, 1 , 0);
		
		int startIndex = Arrays.binarySearch(purchases, start);
		int finishIndex = Arrays.binarySearch(purchases, finish);
			
		startIndex = startIndex < 0 ? Math.abs(startIndex+1) : startIndex+1;
		finishIndex = finishIndex < 0 ? Math.abs(finishIndex+1) : finishIndex;
			
		if (startIndex != finishIndex) {
				
			boolean startCondition = false;
			boolean finishCondition = false;
				
			System.out.println("\nAll the required purchases:");
				
			do{
				startCondition = Arrays.binarySearch(purchases, startIndex, finishIndex, start)>0;
				if (startCondition) startIndex++;
				
				finishCondition = Arrays.binarySearch(purchases, startIndex, finishIndex, finish)>0;
				if (finishCondition) finishIndex--;
					
			} while (startCondition || finishCondition);
				
			for (int i = startIndex; i < finishIndex; i++) {
					System.out.println(purchases[i]);			
			}
		} else {
			System.out.println(NOT_FOUND);
		}
	}*/
	
	private static void printPurchases(AbstractPurchase [] purchases, String title) {
		System.out.println(title);
		for (AbstractPurchase purchase : purchases) {
				System.out.println(purchase);
		}
	}
}
