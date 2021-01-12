package by.gsu.epamlab.controller.interfaces;

import by.gsu.epamlab.controller.ConstantsJSP;
import by.gsu.epamlab.exceptions.InitException;

import java.util.List;

public interface NumberDAO {

    List<Double> getNumbers() throws InitException;

    static boolean isInLimits(double number) {
        return number >= ConstantsJSP.MIN_NUMBER_VALUE && number <= ConstantsJSP.MAX_NUMBER_VALUE;
    }
}
