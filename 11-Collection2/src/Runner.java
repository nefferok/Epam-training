import static by.Constants.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import by.Constants;
import by.gsu.epamlab.comparator.ValueMapComparator;

public class Runner {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(new FileReader(FILE_PATH))) {

			sc.useLocale(Locale.ENGLISH);
			Map <Integer, Integer> map =new HashMap<>();

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] elements = line.split(SPLIT_PATTERN);

				double xDiff = Double.parseDouble(elements[X1_POSITION]) - Double.parseDouble(elements[X2_POSITION]);
				double yDiff = Double.parseDouble(elements[Y1_POSITION]) - Double.parseDouble(elements[Y2_POSITION]);

				Integer len = (int) Math.round(Math.sqrt(xDiff*xDiff +yDiff*yDiff));
				Integer value = map.get(len);
				if (value == null) {
					value = 0;
				}
				map.put(len, value+1);
			}
			
			SortedMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(new ValueMapComparator(map));
			sortedMap.putAll(map);
			
			printCollection(sortedMap.entrySet());

		} catch (FileNotFoundException e) {
			System.err.println(FILE_NOT_FOUND);
		}
	}
	
	private static void printCollection(Collection<Entry<Integer, Integer>> entrySet) {
		for(Entry<Integer, Integer> pair: entrySet) {
			System.out.println(pair.getKey() + Constants.DELIMITER + pair.getValue());
		}
	}
}
