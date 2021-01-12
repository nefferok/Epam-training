package by.gsu.epamlab.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static by.gsu.epamlab.constants.ConstantsController.*;

public class AbstractController extends HttpServlet {

    protected void forwardToUrl(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    protected void forwardToUrlWithErrMsg(HttpServletRequest req, HttpServletResponse resp, String path, Exception e) throws ServletException, IOException {
        writeToLog(this.getClass(), e);
        req.setAttribute(ERROR_MESSAGE, e.getMessage());
        RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    protected void forwardWithErrMsgExclLog(HttpServletRequest req, HttpServletResponse resp, String path, Exception e) throws ServletException, IOException {
        req.setAttribute(ERROR_MESSAGE, e.getMessage());
        RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    protected void redirectTo(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException {
        resp.sendRedirect(req.getContextPath() + path);
    }

    private static void writeToLog(Class<? extends AbstractController> className, Exception e){
        final Logger LOGGER = Logger.getLogger(className.getName());
        LOGGER.log(Level.SEVERE, e.toString(), e);
    }



}
