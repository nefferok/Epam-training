package by.gsu.epamlab.preferenses;

import by.Constants;

public enum Format {
	NAME(Constants.NAME_FORMAT),
	PRICE(Constants.PRICE_FORMAT),
	NUMBER(Constants.NUMBER_FORMAT),
	DISCOUNT(Constants.DISCOUNT_FORMAT),
	COST(Constants.COST_FORMAT);
	
	private String format;
	
	private Format(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return format;
	}
	
	public static String formFullFormat() {
		StringBuilder fullFormat = new StringBuilder();
		for (int i = 0; i < values().length; i++) {
			fullFormat.append(values()[i].format);
		}
		return fullFormat.toString();
	}
	
	public static String purchaseFieldsFormat() {
		StringBuilder format = new StringBuilder();
			format.append(NAME.format).append(PRICE.format).append(NUMBER.format);
		return format.toString();
	}
	
	public static String additionalFieldsFormat() {
		StringBuilder format = new StringBuilder();
			format.append(DISCOUNT.format).append(COST.format);
		return format.toString();
	}
}
