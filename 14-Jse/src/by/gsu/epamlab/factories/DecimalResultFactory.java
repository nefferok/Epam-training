package by.gsu.epamlab.factories;

import by.gsu.epamlab.beans.DecimalResult;
import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.exception.ReaderException;
import by.gsu.epamlab.intrefaces.IResultDAO;
import by.gsu.epamlab.intrefaces.XmlReader;

import java.sql.Date;

import static by.Constants.*;

public class DecimalResultFactory extends ResultFactory{

    private static final int MULTIPLIER =10;

    @Override
    public Result getResultFromFacory(String... elements){
        return new DecimalResult(elements[NAME_IND], elements[TEST_IND], elements[DATE_IND], elements[MARK_IND]);
    }

    @Override
    public Result getResultFromFacory(String name, String test, Date date, int mark){
        return new DecimalResult(name, test, date, mark);
    }

    @Override
    public IResultDAO getImplementation(String file) throws ReaderException {
        return new XmlReader(file, this);
    }

    @Override
    public String getMainMark(double value){
        return String.format(OUT_PATTERN, value/MULTIPLIER);
    }
}
