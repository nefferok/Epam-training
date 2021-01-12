package by.gsu.epamlab.controllers;

import by.gsu.epamlab.constants.ConstantsException;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.ValidationException;
import by.gsu.epamlab.ifaces.ConferenceDAO;
import by.gsu.epamlab.model.beans.Conference;
import by.gsu.epamlab.model.beans.Event;
import by.gsu.epamlab.model.factory.ConferenceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static by.gsu.epamlab.constants.ConstantsJSP.*;

@WebServlet(
        name = "ProgController",
        urlPatterns = {"/prog"}
)
public class ProgController extends HttpServlet {

    private static final long serialVersionUID = 2L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strIdConf = req.getParameter(ID_ATR_PARAM);
        try {
            int idConf = getIdConf(strIdConf);
            HttpSession session = req.getSession();
            session.setAttribute(ID_ATR_PARAM, idConf);
            ConferenceDAO conferenceDAO = ConferenceFactory.getClassFromFactory();;
            List<Event> events = conferenceDAO.getEventsById(idConf);
            req.setAttribute(EVENTS_ATR_PARAM, events);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(PROG_PAGE);
            rd.forward(req, resp);
        } catch (ValidationException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, WRONG_CONF + strIdConf);
        } catch (DaoException e) {
            resp.sendRedirect(req.getContextPath() + INDEX_ERROR_REQ);
        }
    }

    private int getIdConf(String value) throws ValidationException {
        try{
            int id = Integer.parseInt(value);
            Map<Integer, Conference> conf = (Map<Integer, Conference>) getServletContext().getAttribute(CONF_ATR_PARAM);
            if ( !conf.containsKey(id)) {
                throw new ValidationException(ConstantsException.EXCEPTION_WRONG_ID_CONF+ value);
            }
            return id;
        } catch (NumberFormatException e){
            throw new ValidationException(e);
        }
    }
}
