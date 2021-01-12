import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
	public static void main(String[] args) {

		final String NOT_FOUND = "Input file is not found";

		try {
			final String FILE_NAME = "in";
			ResourceBundle rb = ResourceBundle.getBundle(FILE_NAME);
			Enumeration<String> keys = rb.getKeys();

			final String KEY_REG_EXP = "^index(.*)";
			final String NUM_REG_EXP = "^[1-9]\\d*";

			Pattern keyPattern = Pattern.compile(KEY_REG_EXP);
			Pattern numPattern = Pattern.compile(NUM_REG_EXP);

			final int TAIL_INDEX = 1;
			final String VALUE = "value";
			final String SUM = "sum = ";
			final String ERRORS = "\nerror-lines = ";

			int errorCounter = 0;
			double sum = 0;

			String key;

			while (keys.hasMoreElements()) {
				key = keys.nextElement();

				Matcher keyMatcher = keyPattern.matcher(key);

				if (keyMatcher.matches()) {

					String iStr = keyMatcher.group(TAIL_INDEX);
					String jStr = rb.getString(key).trim();

					Matcher iMatcher = numPattern.matcher(iStr);
					Matcher jMatcher = numPattern.matcher(jStr);

					if (iMatcher.matches() && jMatcher.matches()) {

						StringBuilder valueIJ = new StringBuilder(VALUE);
						valueIJ.append(iStr).append(jStr);

						try {
							double element = Double.parseDouble(rb.getString(valueIJ.toString()));
							sum += element;
						} catch (NumberFormatException e) {
							errorCounter++;
						}
					} else {
						errorCounter++;
					}
				}
			}
			System.out.println(SUM + sum + ERRORS + errorCounter);
		} catch (MissingResourceException e) {
			System.err.println(NOT_FOUND);
		}
	}
}
