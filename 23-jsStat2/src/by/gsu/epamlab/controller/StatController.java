package by.gsu.epamlab.controller;

import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.model.factory.NumberFactory;
import by.gsu.epamlab.model.interfaces.NumberDAO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.gsu.epamlab.controller.ConstantsJSP.*;

@WebServlet(
        urlPatterns = {STAT_URL},
        name = STAT_NAME,
        initParams = {
                @WebInitParam(name = CONTROLLER_MIN_SIZE, value = CONTROLLER_MIN_VALUE),
                @WebInitParam(name = CONTROLLER_FACTORY, value = CONTROLLER_MEMORY_PARAM)
        }
)
public class StatController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<Double> numbers;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try{
            final int MIN_SIZE = Integer.parseInt(config.getInitParameter(CONTROLLER_MIN_SIZE));
            NumberFactory.init(config.getInitParameter(ConstantsJSP.CONTROLLER_FACTORY));
            NumberDAO numberDAO = NumberFactory.getClassFromFactory();
            numbers = numberDAO.getNumbers();
            if (numbers.size() < MIN_SIZE){
                throw new InitException(EXCEPTION_FEW_NUMBER);
            }
        } catch (InitException e){
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletResponse response;

        final String INDS = "inds";
        String indexes = req.getParameter(INDS);
        PrintWriter writer = resp.getWriter();

        if (indexes==null) {
            writer.print(numbers.size());
        } else {
            String values = Stream.of(indexes.split(SPLITTER))
                    .mapToInt(Integer::parseInt)
                    .mapToDouble(numbers::get)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",","[","]"));
            writer.print(values);
        }
    }
}
