package by.gsu.epamlab.exceptions;

import by.Constants;

@SuppressWarnings("serial")
public class NegativeArgumentExceprion extends NonPositiveArgumentException {
	
	public NegativeArgumentExceprion(NumField position, int argument) {
		super(position, argument);
	}
	
	public NegativeArgumentExceprion(int argument) {
		super(argument);
	}
	
	@Override
	public String toString() {
		return Constants.NEGATIVE_VALUE + super.fieldsToString();	
	}
	
}
