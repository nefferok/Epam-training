package by.gsu.epamlab.exceptions;

import by.Constants;

public enum NumField {
	
	NAME(Constants.NAME_POSITION),
	PRICE(Constants.PRICE_POSITION),
	NUMBER(Constants.NUMBER_POSITION),
	DISCOUNT(Constants.DISCOUNT_POSITION),
	COST(Constants.COST_POSITION);
	
	private int position;

	private NumField(int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
}
