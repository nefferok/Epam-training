package by.gsu.epamlab.exceptions;

public class InitException extends Exception {

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