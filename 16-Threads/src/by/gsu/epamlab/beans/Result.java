package by.gsu.epamlab.beans;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import static by.Constants.*;

public class Result{
    private final static String PATTERN = "[1-9]|10";
    private static final SimpleDateFormat IN_FORMATTER = new SimpleDateFormat(IN_FORMAT);
    private static final SimpleDateFormat OUT_FORMATTER = new SimpleDateFormat(OUT_FORMAT);
    private static final int MIN_MARK = 1;
    private static final int MAX_MARK = 10;
    private static final int INDEX_NAME = 0;
    private static final int INDEX_TEST = 1;
    private static final int INDEX_DATE = 2;
    private static final int INDEX_MARK = 3;

    private String login;
    private String test;
    private Date date;
    private int mark;

    public Result(String login, String test, String date, String mark) {
            this.login = login;
            this.test = test;
            setDate(date);
            setMark(mark);
    }

    public Result(String...elements) {
        this(elements[INDEX_NAME],elements[INDEX_TEST],elements[INDEX_DATE],elements[INDEX_MARK]);
    }

    public Result() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        try {
            this.date = IN_FORMATTER.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark < MIN_MARK || mark > MAX_MARK){
            throw new IllegalArgumentException(EXCEPTION_INCORRECT_MARK + mark);
        }
        this.mark = mark;
    }

    public void setMark (String mark){
        if (!mark.matches(PATTERN)){
            throw new IllegalArgumentException(EXCEPTION_INCORRECT_MARK + mark);
        }
        int figure = Integer.parseInt(mark);
        this.setMark(figure);
    }

    private String getStringDate() {
        return OUT_FORMATTER.format(date);
    }

    @Override
    public String toString() {
        return login + DELIMITER + test + DELIMITER + getStringDate() + DELIMITER + mark;
    }
}
