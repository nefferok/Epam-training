package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.ValidationException;
import by.gsu.epamlab.ifaces.UserDAO;
import by.gsu.epamlab.models.beans.User;
import by.gsu.epamlab.models.factories.UserFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static by.gsu.epamlab.constants.ConstantsController.*;
import static by.gsu.epamlab.constants.ConstantsError.ERR_USER_EXISTS;

@WebServlet(name = REG_CONTROLLER, value = REG_URL)
public class RegController extends AbstractController{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession session = req.getSession();
            String login = req.getParameter(USERNAME_PARAM);
            String password = req.getParameter(PASSWORD_PARAM);

            UserDAO userDAO = UserFactory.getClassFromFactory();
            Optional<User> opUser = userDAO.addAndGetUser(login, password);
            User user = opUser.orElseThrow(() -> new ValidationException(login + ERR_USER_EXISTS));

            session.setAttribute(USERNAME_PARAM, user.getName());
            session.setAttribute(USER_ID_PARAM, user.getId());
            session.setAttribute(USER_PARAM, user);

            redirectTo(req, resp, MAIN_VIEW_TODAY_URL);

        } catch (ValidationException e) {
            forwardWithErrMsgExclLog(req, resp, REGISTRATE_PAGE, e);

        } catch (DaoException e) {
            forwardToUrlWithErrMsg(req, resp, INDEX_PAGE, e);
        }
    }
}
