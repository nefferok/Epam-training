package by.gsu.epamlab.filters;

import by.gsu.epamlab.command.page.RedirectPage;
import by.gsu.epamlab.model.beans.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;


@WebFilter(filterName = LOGIN_FILTER, value = {ADD_TASK_JSP, PAGE_MAIN_JSP,
        MAIN_URL, LOGOUT_URL, OPERATIONS_URL, ADD_URL})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute(USER_PARAM);
        if (user == null) {
            session.invalidate();
            HttpServletResponse httpResponse =
                    (HttpServletResponse) response;
            new RedirectPage(PAGE_LOGIN_IN_JSP)
                    .finishRequest(httpRequest, httpResponse);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}