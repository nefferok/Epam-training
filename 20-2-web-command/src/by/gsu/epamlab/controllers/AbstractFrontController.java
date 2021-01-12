package by.gsu.epamlab.controllers;

import by.gsu.epamlab.command.ActionCommand;
import by.gsu.epamlab.command.factory.CommandEnum;
import by.gsu.epamlab.command.page.AbstractPage;
import by.gsu.epamlab.command.page.ErrorPage;
import by.gsu.epamlab.exceptions.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFrontController extends HttpServlet {

    protected void processedRequest(HttpServletRequest request,
                                    HttpServletResponse response) throws ServletException, IOException {
        try {
            ActionCommand command = CommandEnum.getCommand(request.getRequestURI());
            AbstractPage page = command.execute(request);
            page.finishRequest(request, response);
        } catch (DaoException e) {
            writeToLog(this.getClass(), e);
            new ErrorPage(e).finishRequest(request, response);
        }
    }

    protected void processError(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws IOException {
        new ErrorPage(e).finishRequest(request, response);
    }

    protected static void writeToLog(Class<?> className, Exception e) {
        final Logger LOGGER = Logger.getLogger(className.getName());
        LOGGER.log(Level.SEVERE, e.getMessage(), e);
    }
}