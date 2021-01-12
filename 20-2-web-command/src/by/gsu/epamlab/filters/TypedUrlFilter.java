package by.gsu.epamlab.filters;

import by.gsu.epamlab.command.page.RedirectPage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;


@WebFilter(filterName = NAME_FILTER, value = {PAGE_MAIN_JSP, ADD_TASK_JSP, MAIN_URL, LOGIN_URL,
        REGISTRATION_URL, LOGOUT_URL, OPERATIONS_URL, ADD_URL, PAGE_ERR_CODE, PAGE_ERR_EXCEPTION})
public class TypedUrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String referer = httpRequest.getHeader(REFERER);
        if (referer == null) {
//            new RedirectPage().finishRequest(httpRequest, httpResponse);
            httpResponse.sendRedirect(httpRequest.getContextPath());
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}