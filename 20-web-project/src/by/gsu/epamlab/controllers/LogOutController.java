package by.gsu.epamlab.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.gsu.epamlab.constants.ConstantsController.LOGOUT_CONTROLLER;
import static by.gsu.epamlab.constants.ConstantsController.LOGOUT_URL;

@WebServlet(name = LOGOUT_CONTROLLER, value = LOGOUT_URL)
public class LogOutController extends AbstractController{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null) {
            req.logout();
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath());
    }
}
