package by.gsu.epamlab.controller.implementation;

import by.gsu.epamlab.controller.ConstantsJSP;
import by.gsu.epamlab.controller.interfaces.NumberDAO;
import by.gsu.epamlab.exceptions.InitException;

import javax.servlet.ServletConfig;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class NumberImplCsv implements NumberDAO {
    private final String csvName;

    public NumberImplCsv(String params, ServletConfig sc) {
        this.csvName = sc.getServletContext().getRealPath(ConstantsJSP.REAL_PATH) + params;
    }

    @Override
    public List<Double> getNumbers()  throws InitException{
        try (Scanner sc = new Scanner(new FileReader(csvName))) {
            String csvLine = sc.next();
            return Arrays.stream(csvLine.split(ConstantsJSP.SPLITTER))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new InitException(ConstantsJSP.EXCEPTION_READ_CSV + csvName);
        }

    }
}