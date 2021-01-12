package by.gsu.epamlab.model.implementation;

import by.gsu.epamlab.model.interfaces.NumberDAO;
import by.gsu.epamlab.exceptions.InitException;

import javax.servlet.ServletConfig;
import java.util.List;

public class NumberImplMemory implements NumberDAO {

    public NumberImplMemory(String params) {
    }

    @Override
    public List<Double> getNumbers() throws InitException {
        return List.of(15.47, 20.48, 15.78, 20.41, 15.00, 13.27, 21.14, 10.00, 18.12, 10.4, 10.5, 18.00, 17.48, 11.11);
    }
}
