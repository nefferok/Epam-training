package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.ActivityDao;
import by.gsu.epamlab.model.factories.ActivityFactory;

@WebServlet("/reg")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	HttpSession session = request.getSession();
		int idConf = (int) session.getAttribute(Constants.KEY_ID_CONF);
    	String nameConf = ConfsController.getConferences().get(idConf).getName();
		String account = request.getParameter(Constants.KEY_ACCOUNT);
		String[] strEvents = request.getParameterValues(Constants.KEY_ID_EVENT);
		int[] idEvents = Arrays.stream(strEvents).mapToInt(Integer::parseInt).toArray();
		ActivityDao activityDao = ActivityFactory.getClassFromFactory();
		String error = "";
		try {
			activityDao.addParticipant(account, idConf, idEvents);
		} catch (DaoException e) {
			error = "&error=yes";
		}
		response.sendRedirect(request.getContextPath() + "/confirm.html" 
				+ "?" + Constants.KEY_ACCOUNT + "=" + account 
				+ "&" + Constants.KEY_NAME_CONF + "=" + nameConf 
				+ error);
	}

}
