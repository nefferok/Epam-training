package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.models.factories.TaskFactory;
import by.gsu.epamlab.models.factories.UserFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static by.gsu.epamlab.constants.ConstantsController.*;

@WebServlet(name = START_CONTROLLER, urlPatterns = {START_URL},
        initParams = {
                @WebInitParam(name = PROPERTIES_NAME, value = PROPERTIES_VALUE)
        },
        loadOnStartup = 1)

public class StartController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static Logger LOGGER = Logger.getLogger(StartController.class.getName());

    @Override
    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
        try {
            String propsName = sc.getInitParameter(PROPERTIES_NAME);
            ResourceBundle rb = ResourceBundle.getBundle(propsName);
            UserFactory.init(rb);
            TaskFactory.init(rb);
        } catch (InitException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new ServletException(e);
        }
    }
}
