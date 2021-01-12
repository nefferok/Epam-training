package by.gsu.epamlab.command;

import by.gsu.epamlab.command.page.AbstractPage;
import by.gsu.epamlab.command.page.RedirectPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public class LogoutCommand implements ActionCommand {
    @Override
    public AbstractPage execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        return new RedirectPage(PAGE_INDEX_JSP);
    }
}