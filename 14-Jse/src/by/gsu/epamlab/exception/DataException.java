package by.gsu.epamlab.exception;

import by.Constants;

public class DataException extends IllegalArgumentException{

    private String value;

    public DataException(String wrongMark, String message){
        super(message);
        this.value = wrongMark;
    }

    public DataException(String value, RuntimeException e){
        super(e);
        this.value = value;
    }

    @Override
    public String toString(){
        return Constants.EXCEPTION_DATA_HEAD + value + Constants.EXCEPTION_DATA_BODY + getMessage();
    }

}
