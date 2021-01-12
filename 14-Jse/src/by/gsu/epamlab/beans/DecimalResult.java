package by.gsu.epamlab.beans;

import by.Constants;
import by.gsu.epamlab.exception.DataException;

import java.sql.Date;

public class DecimalResult extends Result{
    private final static String PATTERN = "\\d\\.\\d|10\\.0" ;
    private final static int MULTIPLIER = 10;
    private final static int DECIMAL_PART_IND = 1;
    private final static String MARK_DELIMITER =".";

    public DecimalResult(String login, String test, Date date, int mark) {
        super(login, test, date, mark);
    }

    public DecimalResult(String login, String test, String date, String mark) {
        super(login, test, date, mark);
    }

    @Override
    public void setMark(String mark){
        if (!mark.matches(PATTERN)){
            throw new DataException(mark ,Result.EXCEPTION_MARK_MESSAGE);
        }
        String [] parts = mark.split(Constants.SPLITTER);
        try {
            int value = Integer.parseInt(parts[HalfResult.WHOLE_PART_IND]) * MULTIPLIER + Integer.parseInt(parts[DECIMAL_PART_IND]);
            setMark(value);
        } catch (NumberFormatException e){
            throw new DataException(mark, e);
        }
    }

    @Override
    protected String markToString(){
        return getMark() / MULTIPLIER + MARK_DELIMITER + getMark() % MULTIPLIER;
    }
}
