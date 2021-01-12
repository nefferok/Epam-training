package by.gsu.epamlab.exceptions;

public class DaoException extends Exception {

	private static final long serialVersionUID = -5620149109631105508L;

	public DaoException(Exception exception) {
		super(exception);
	}

	public DaoException(String arg0) {
		super(arg0);
	}

	public String toString() {
		return getMessage();
	}
}
