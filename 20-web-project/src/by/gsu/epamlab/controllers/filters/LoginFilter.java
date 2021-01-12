package by.gsu.epamlab.controllers.filters;

import by.gsu.epamlab.models.beans.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.gsu.epamlab.constants.ConstantsController.*;


@WebFilter(filterName = LOGIN_FILTER, value = {ADD_TASK_URL, OPERATION_URL, MAIN_URL})
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
            httpResponse.sendRedirect(LOGIN_PAGE);
            return;
        }
        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {

    }
}
