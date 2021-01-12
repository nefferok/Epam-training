package by.gsu.epamlab.intrefaces;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.exception.ReaderException;
import by.gsu.epamlab.factories.ResultFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static by.Constants.DELIMITER;
import static by.Constants.EXCEPTION_SCANNER_CREATE;

public class CsvReader implements IResultDAO {
    private Scanner scanner = null;
    private ResultFactory factory;

    public CsvReader(String file, ResultFactory factory) throws ReaderException {
        try {
            scanner = new Scanner(new FileReader(file));
            this.factory = factory;
        } catch (FileNotFoundException e) {
            throw new ReaderException(EXCEPTION_SCANNER_CREATE, e);
        }
    }

    @Override
    public boolean hasResult() {
        return scanner.hasNextLine();
    }

    @Override
    public Result nextResult() {
        String [] elements = scanner.nextLine().split(DELIMITER);
        return factory.getResultFromFacory(elements);
    }

    @Override
    public void closeReader() {
        scanner.close();
    }
}
