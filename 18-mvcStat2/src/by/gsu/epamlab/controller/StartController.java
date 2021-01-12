package by.gsu.epamlab.controller;

import by.gsu.epamlab.controller.interfaces.NumberDAO;
import by.gsu.epamlab.controller.factory.NumberFactory;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.exceptions.InitRuntimeException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.gsu.epamlab.controller.ConstantsJSP.*;

@WebServlet(
		urlPatterns = {"/start"},
		name = "StartController",
		initParams = {
				@WebInitParam(name = CONTROLLER_MIN_SIZE, value = CONTROLLER_MIN_VALUE),
				@WebInitParam(name = CONTROLLER_FACTORY, value = CONTROLLER_DB_PARAM)
		}
)
public class StartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
		try{
			final int MIN_SIZE = Integer.parseInt(sc.getInitParameter(CONTROLLER_MIN_SIZE));
			NumberFactory.init(sc);

			NumberDAO numberDAO = NumberFactory.getClassFromFactory();

			List<Double> numbers = numberDAO.getNumbers().stream()
					.filter(NumberDAO::isInLimits)
					.collect(Collectors.toList());

			if (numbers.size() < MIN_SIZE){
				throw new InitException(EXCEPTION_FEW_NUMBER);
			}
			getServletContext().setAttribute(ConstantsJSP.NUMBERS_NAME, numbers);
			getServletContext().setAttribute(ConstantsJSP.MAX_VALUE_NAME, numbers.size());

		} catch (InitException | InitRuntimeException e){
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {

		//get statsNumber from the request parameter ConstantsJSP.NUMBER_NAME;
		int statsNumber = Integer.parseInt(request.getParameter(ConstantsJSP.NUMBER_NAME));

		//set attribute ConstantsJSP.NUMBER_NAME;
		request.setAttribute(ConstantsJSP.NUMBER_NAME, statsNumber);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(ConstantsJSP.START_PAGE_URL);
		rd.forward(request, response);
	}

}