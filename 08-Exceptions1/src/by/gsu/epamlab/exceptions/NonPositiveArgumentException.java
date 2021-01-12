package by.gsu.epamlab.exceptions;

import by.Constants;

@SuppressWarnings("serial")
public class NonPositiveArgumentException extends IllegalArgumentException {

	private NumField kind;
	private int argument;

	public NonPositiveArgumentException(NumField position, int wrongParam) {
		super();
		this.kind = position;
		this.argument = wrongParam;
	}
	
	public NonPositiveArgumentException(int argument) {
		super();
		this.argument = argument;
	}
	
	public void setField(NumField position) {
		kind = position;
	}
	
	public NumField getKind() {
		return kind;
	}

	public int getArgument() {
		return argument;
	}

	public String fieldsToString() {
		return argument + Constants.IN + kind.name().toLowerCase();
	}
	
	@Override
	public String toString() {
		return Constants.NEGATIVE_VALUE + fieldsToString();	
	}
}
