package by.gsu.epamlab.intrefaces;

import by.gsu.epamlab.beans.Result;

public interface IResultDAO {

    boolean hasResult();

    Result nextResult();

    void closeReader();
}
