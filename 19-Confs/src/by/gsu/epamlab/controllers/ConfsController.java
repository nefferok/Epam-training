package by.gsu.epamlab.controllers;

import by.gsu.epamlab.constants.ConstantsException;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.exceptions.InitRuntimeException;
import by.gsu.epamlab.ifaces.ConferenceDAO;
import by.gsu.epamlab.model.beans.Conference;
import by.gsu.epamlab.model.factory.ActivityFactory;
import by.gsu.epamlab.model.factory.ConferenceFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Map;
import java.util.ResourceBundle;

import static by.gsu.epamlab.constants.ConstantsJSP.*;

@WebServlet(
        name = "ConfsController",
        urlPatterns = {"/confs"},
        initParams = {
                @WebInitParam(name = PROP_NAME, value = PROP_VALUE)
        },
        loadOnStartup = 1
)
public class ConfsController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try{
            String propertiesName = config.getInitParameter(PROP_NAME);
            ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
            ConferenceFactory.init(rb);
            ConferenceDAO conferenceDAO = ConferenceFactory.getClassFromFactory();
            Map<Integer, Conference> conferences = conferenceDAO.getConferences();
            if (conferences.isEmpty()){
                throw new InitException(ConstantsException.EXCEPTION_WEB_INIT);
            }
            getServletContext().setAttribute(CONF_ATR_PARAM, conferences);
            ActivityFactory.init(rb, config);
        }catch (InitException| InitRuntimeException e){
            throw new ServletException(e);
        }
    }


}
