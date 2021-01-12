package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.ifaces.ConferenceDao;
import by.gsu.epamlab.model.beans.Conference;
import by.gsu.epamlab.model.beans.Event;
import by.gsu.epamlab.model.factories.ActivityFactory;
import by.gsu.epamlab.model.factories.ConferenceFactory;

/**
 * Servlet implementation class ConfsController
 */
@WebServlet(
		urlPatterns = {"/confs"}, 
		initParams = { 
			@WebInitParam(name = "propsName", value = "resources.confs")
		}, 
		loadOnStartup = 1
	)
public class ConfsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<Integer, Conference> conferences;
	
	public static Map<Integer, Conference> getConferences() {
		return conferences;
	}
       
	@Override
	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
		try {
			String propsName = sc.getInitParameter("propsName");
			ResourceBundle rb = ResourceBundle.getBundle(propsName);
			ConferenceFactory.init(rb);
			ConferenceDao conferenceDao = ConferenceFactory.getClassFromFactory();
			conferences = conferenceDao.getConferences();
			if(conferences.isEmpty()) {
				throw new InitException("No conferences is found...");
			}
			ActivityFactory.init(rb);
		} catch (InitException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		String strIdConf = request.getParameter(Constants.KEY_ID_CONF);
		if(strIdConf == null) {
			String jsonConfs = Utilities.getJsonConfs(conferences);
			out.print(jsonConfs);
		} else {
			int idConf = Integer.parseInt(strIdConf);
	    	HttpSession session = request.getSession();
			session.setAttribute(Constants.KEY_ID_CONF, idConf);
			ConferenceDao conferenceDao = ConferenceFactory.getClassFromFactory();
			try {
				String jsonConf = Utilities.getJsonConfById(conferences, idConf);
				List<Event> events =  conferenceDao.getEventsById(idConf);
				String jsonEvents = Utilities.getJsonEvents(events);
				String jsonConfEvents = "{\"conf\": " + jsonConf + ", " 
						+ "\"events\": " + jsonEvents + "}"; 
				out.print(jsonConfEvents);
			} catch (DaoException e) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Data source is failed...");
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventName = request.getParameter(Constants.KEY_NAME_EVENT);
		String eventTime = request.getParameter(Constants.KEY_TIME_EVENT);
    	HttpSession session = request.getSession();
		int idConf = (int) session.getAttribute(Constants.KEY_ID_CONF);
		ConferenceDao conferenceDao = ConferenceFactory.getClassFromFactory();
		conferenceDao.addEvent(idConf, eventName, eventTime);
		response.sendRedirect(request.getContextPath() + "/index.html?" 
				+ Constants.KEY_ID_CONF + "=" + idConf);
	}

}
