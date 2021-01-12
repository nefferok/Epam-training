package by.gsu.epamlab.exceptions;

import java.sql.SQLException;

public class DaoException extends Exception {

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Exception exception) {
        super(exception);
    }

    public DaoException(String ex, SQLException e) {
        super(ex, e);
    }

    public String toString() {
        return getMessage();
    }
}