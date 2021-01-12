package by.gsu.epamlab.command;

import by.gsu.epamlab.command.page.AbstractPage;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.model.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public interface ActionCommand {
    default void putUserToSession(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_PARAM, user);
        session.setAttribute(LOGIN, user.getLogin());
        session.setAttribute(ID_USER, user.getId());
    }

    AbstractPage execute(HttpServletRequest request) throws DaoException;
}