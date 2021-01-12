package by.gsu.epamlab.beans;

import by.Constants;
import by.gsu.epamlab.exception.DataException;

import java.sql.Date;

public class HalfResult extends Result{
    private final static String PATTERN = "[1]?\\d(\\.5)?|20";
    private final static int MULTIPLIER = 2;
    private final static String HALF = ".5";
    private final static int HALF_PART_LNGTH = 2;
    protected final static int WHOLE_PART_IND = 0;

    public HalfResult(String login, String test, Date date, int mark) {
        super(login, test, date, mark);
    }

    public HalfResult(String login, String test, String date, String mark){
        super(login, test, date, mark);
    }

    @Override
    public void setMark(String mark){
        if (!mark.matches(PATTERN)){
            throw new DataException(mark ,Result.EXCEPTION_MARK_MESSAGE);
        }
        String [] parts = mark.split(Constants.SPLITTER);
        try {
            int value = Integer.parseInt(parts[WHOLE_PART_IND]) * MULTIPLIER;
            if (parts.length == HALF_PART_LNGTH) value += 1;
            setMark(value);
        } catch (NumberFormatException e){
            throw new DataException(mark, e);
        }
    }

    @Override
    protected String markToString(){
        int value = getMark();
        return value % MULTIPLIER == 0 ? String.valueOf(value/MULTIPLIER) : value/MULTIPLIER + HALF;
    }
}
