package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.model.factories.TaskFactory;
import by.gsu.epamlab.model.factories.UserFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import java.util.ResourceBundle;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

@WebServlet(
        loadOnStartup = 1,
        urlPatterns = {START_URL},
        initParams = {
                @WebInitParam(name = KEY_PROPS_NAME, value = PROPERTIES_VALUE_RESOURCES_CONFS)
        }
)
public class StartController extends AbstractFrontController {

    @Override
    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
        try {
            String propsName = sc.getInitParameter(ConstantsJsp.KEY_PROPS_NAME);
            ResourceBundle rb = ResourceBundle.getBundle(propsName);
            UserFactory.init(rb);
            TaskFactory.init(rb);
        } catch (InitException e) {
            writeToLog(this.getClass(), e);
            throw new ServletException(e);
        }
    }
}