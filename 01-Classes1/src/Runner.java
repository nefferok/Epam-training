import java.util.Scanner;

import by.gsu.epamlab.BusinessTrip;

public class Runner {	
	
	public static void main (String[] args) {
		
		//1.	
		BusinessTrip [] businessTrips = {new BusinessTrip("Anton Shumsky", 1620, 5),
				new BusinessTrip("Ivan Urgant", 5, 5), 
				null, 
				new BusinessTrip("Dmitry Pupkin", 1129, 10), 
				new BusinessTrip()};
		
		//2.
		BusinessTrip mostExpensive = businessTrips[0];
		for (BusinessTrip trip:businessTrips) {
			if (trip != null) {
			System.out.println("=============");
			trip.show();
				if (trip.getTotal() > mostExpensive.getTotal()) {
					mostExpensive = trip;
				}
			} else {System.out.println("=============\nnull");}	
		}
		System.out.println("=============\nThe most expensive trip > " + mostExpensive + "\n");
		
		//3.
		businessTrips[businessTrips.length-1].setTransport(755);
		
		//4.
		System.out.println("Duration = " + (businessTrips[0].getDays()+businessTrips[1].getDays()) + "\n");

		//5.
		for (BusinessTrip trip:businessTrips) {
				System.out.println(trip);
		}	
		
	}

}


