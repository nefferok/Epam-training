import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		final String NOT_FOUND = "Input file is not found";
		Scanner scanner = null;
				
		try {
			final String FILE_PATH = "src/in.csv";		
			final String SPLITTER =";";
			final String MINUS = " - ";
			final String PLUS = " + ";
			final String START = "result(";
			final String END = ") = ";
			final String ERRORS = "\nerror-lines = ";

			StringBuilder result = new StringBuilder();
			
            scanner = new Scanner(new File(FILE_PATH));     
            scanner.useLocale(Locale.ENGLISH);
            
           
            int counter = 0;
            double sum = 0.0;
            
            while (scanner.hasNext()) {
            	
                String line = scanner.nextLine();
                                
                String [] elements = line.split(SPLITTER);

                try{
                	// parse and check data
					int zeroElement = Integer.parseInt(elements[0]);
					double current = Double.parseDouble(elements[zeroElement]);
					
					sum += current;
					
					// form  the middle part of string
					if (current<0) {
						result.append(MINUS).append(Math.abs(current));
					} else if (result.length()==0) {
						result.append(current);
					} else result.append(PLUS).append(current);
					
            	} catch (NumberFormatException | IndexOutOfBoundsException e) {
					counter++;				
				}	
            }
 
            // is the first element negative
            if (result.indexOf(MINUS) == 0) {
            	result.deleteCharAt(0).deleteCharAt(1);
            }
            
            // form final version of string
            result.insert(0, START).append(END).append(sum).append(ERRORS).append(counter);
            
            // output
            System.out.println(result.toString());

		} catch (FileNotFoundException e) {
			System.err.println(NOT_FOUND);
		} finally {
  			if (scanner != null) {
  				scanner.close();
  			}		
		}
	}
}

