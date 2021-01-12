package by.gsu.epamlab.command;

import by.gsu.epamlab.command.page.AbstractPage;
import by.gsu.epamlab.command.page.ForwardPage;
import by.gsu.epamlab.command.page.RedirectPage;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.UserDao;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.factories.UserFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public class LoginCommand implements ActionCommand {
    public LoginCommand() {
    }

    @Override
    public AbstractPage execute(HttpServletRequest request) throws DaoException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        UserDao userDao = UserFactory.getInstanceFromFactory();
        Optional<User> user = userDao.getUser(login, password);
        if (user.isEmpty()) {
            request.setAttribute(ATT_ERR_MESSAGE, ERR_MESSAGE);
            return new ForwardPage(PAGE_LOGIN_IN_JSP);
        }
        putUserToSession(user.get(), request);
        return new RedirectPage(CON_MAIN);
    }
}