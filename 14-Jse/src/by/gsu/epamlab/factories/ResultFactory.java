package by.gsu.epamlab.factories;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.exception.ReaderException;
import by.gsu.epamlab.intrefaces.CsvReader;
import by.gsu.epamlab.intrefaces.IResultDAO;

import java.sql.Date;

import static by.Constants.*;

public class ResultFactory {

    public Result getResultFromFacory(String ...elements){
        return new Result(elements[NAME_IND], elements[TEST_IND], elements[DATE_IND], elements[MARK_IND]);
    }

    public Result getResultFromFacory(String name, String test, Date date, int mark){
        return new Result(name, test, date, mark);
    }

    public IResultDAO getImplementation(String file) throws ReaderException {
        return new CsvReader(file, this);
    }

    public String getMainMark(double value){
        return String.format(OUT_PATTERN, value);
    }

}
