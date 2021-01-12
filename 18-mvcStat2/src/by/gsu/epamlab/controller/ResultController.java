package by.gsu.epamlab.controller;

import by.gsu.epamlab.model.Operation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ResultController", value = "/result")
public class ResultController extends HttpServlet {

	private static final long serialVersionUID = 2L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//get strOperation and strNumbers from the corresponding request parameters;
		String strOperation = request.getParameter(ConstantsJSP.OPERATION_NAME);
		String [] strNumbers = request.getParameterValues(ConstantsJSP.STAT_NAME);
		List<Double> numbers = (List<Double>) getServletContext().getAttribute(ConstantsJSP.NUMBERS_NAME);

		//convert strNumbers to double numbers;

		double [] figures = Arrays.stream(strNumbers)
				.mapToInt(Integer::parseInt)
				.mapToDouble(numbers::get)
				.toArray();

		//convert strOperation to the operation - an item of the enum Operation;
		Operation operation = Operation.valueOf(strOperation.toUpperCase());

		//get result
		double result = operation.getResult(figures);

		//set attributes for the next page;
		request.setAttribute(ConstantsJSP.RESULT_NAME, result);
		request.setAttribute(ConstantsJSP.STAT_NAME, figures);
		request.setAttribute(ConstantsJSP.OPERATION_NAME, strOperation);

		//forward
		RequestDispatcher rd = getServletContext().getRequestDispatcher(ConstantsJSP.RESULT_PAGE_URL);
		rd.forward(request, response);
	}
}