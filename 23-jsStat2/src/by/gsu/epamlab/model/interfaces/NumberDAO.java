package by.gsu.epamlab.model.interfaces;

import by.gsu.epamlab.controller.ConstantsJSP;
import by.gsu.epamlab.exceptions.InitException;

import java.util.List;

public interface NumberDAO {

    List<Double> getNumbers() throws InitException;
}
