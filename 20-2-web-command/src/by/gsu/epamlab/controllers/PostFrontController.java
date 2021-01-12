package by.gsu.epamlab.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

@WebServlet(urlPatterns = {LOGIN_URL, REGISTRATION_URL, LOGOUT_URL, OPERATIONS_URL, ADD_URL})
public class PostFrontController extends AbstractFrontController {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processError(request, response, new ServletException(ERR_GET + request.getRequestURI()));
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processedRequest(request, response);
    }
}