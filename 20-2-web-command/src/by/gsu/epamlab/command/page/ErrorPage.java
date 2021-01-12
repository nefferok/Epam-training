package by.gsu.epamlab.command.page;

import by.gsu.epamlab.exceptions.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

public class ErrorPage extends AbstractPage {
    private final Exception exception;
    private final int code;

    public ErrorPage(Exception exception) {
        this.exception = exception;
        code = exception instanceof DaoException ? SC_INTERNAL_SERVER_ERROR : SC_BAD_REQUEST;
    }

    @Override
    public void finishRequest(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        response.sendError(code, exception.getMessage());
    }
}