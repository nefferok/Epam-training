package by.gsu.epamlab.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StartController",value = "/start")
public class StartController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//get statsNumber from the request parameter ConstantsJSP.NUMBER_NAME;
		 String statsNumber = request.getParameter(ConstantsJSP.NUMBER_NAME);

		//set attribute ConstantsJSP.NUMBER_NAME;
		request.setAttribute(ConstantsJSP.NUMBER_NAME, Integer.parseInt(statsNumber));
		RequestDispatcher rd = getServletContext().getRequestDispatcher(ConstantsJSP.START_PAGE_URL);
		rd.forward(request, response);
	}

}