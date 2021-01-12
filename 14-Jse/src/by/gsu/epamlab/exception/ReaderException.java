package by.gsu.epamlab.exception;

import by.Constants;

public class ReaderException extends Exception{
    private String cause;

    public ReaderException(String cause, Exception e){
        super(e);
        this.cause =cause;
    }

    @Override
    public String toString(){
        return cause + Constants.EXCEPTION_DB_BODY + getMessage();
    }
}
