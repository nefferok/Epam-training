package by.gsu.epamlab.exceptions;

public class InitException extends Exception {

	private static final long serialVersionUID = 1437181560745338776L;

	public InitException() {
		super();
	}
	
	public InitException(String message) {
		super(message);
	}

	public InitException(Exception exception) {
		super(exception);
	}

	public String toString() {
		return getMessage();
	}

}
