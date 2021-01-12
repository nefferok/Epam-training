package by.gsu.epamlab.exceptions;

import by.Constants;

@SuppressWarnings("serial")
public class CsvLineException extends Exception{
	
	private String line;

	public CsvLineException(String line, Exception exc) {
		super(exc);
		this.line = line;
	}
	
	public CsvLineException() {
		super();
	}

	public CsvLineException(String line, String reason) {
		super(reason);
		this.line = line;
	}
	
	@Override
	public String toString() {
		return line + Constants.ARROW + getMessage();
	}

}
