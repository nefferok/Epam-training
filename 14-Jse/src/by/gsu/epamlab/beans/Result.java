package by.gsu.epamlab.beans;

import by.gsu.epamlab.exception.DataException;

import java.sql.Date;

import static by.Constants.*;

public class Result {
    private final static String PATTERN = "[1-9]|10";
    protected final static String EXCEPTION_MARK_MESSAGE = "value mismatch the required pattern";

    private String login;
    private String test;
    private Date date;
    private int mark;

    public Result (String login, String test, Date date, int mark){
        this.login = login;
        this.test = test;
        this.date = date;
        this.setMark(mark);
    }

    public Result (String login, String test, String date, String mark){
        this.login = login;
        this.test = test;
        this.setDate(date);
        this.setMark(mark);
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        try {
            this.date = Date.valueOf(date);
        } catch (IllegalArgumentException e) {
            throw new DataException(date, e);
        }
    }

    public int getMark() {
        return mark;
    }

    protected void setMark(int mark) {
        this.mark = mark;
    }

    public void setMark (String mark){
        if (!mark.matches(PATTERN)){
            throw new DataException(mark, EXCEPTION_MARK_MESSAGE);
        }
        try{
            int figure = Integer.parseInt(mark);
            this.setMark(figure);
        } catch (NumberFormatException e){
            throw new DataException(mark, e);
        }
    }

    protected String markToString(){
        return String.valueOf(mark);
    }

    @Override
    public String toString(){
        return login + DELIMITER + test + DELIMITER + date + DELIMITER + markToString();
    }
}
