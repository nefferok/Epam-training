package by.gsu.epamlab;

public class Utilit {

	public static String convertToRuble (int coins) {
		return String.format("%d.%02d", coins / 100, coins % 100);
	}
}
