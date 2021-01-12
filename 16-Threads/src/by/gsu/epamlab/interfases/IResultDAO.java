package by.gsu.epamlab.interfases;

import by.gsu.epamlab.beans.Result;

public interface IResultDAO {

    boolean hasResult();

    Result nextResult();
}
