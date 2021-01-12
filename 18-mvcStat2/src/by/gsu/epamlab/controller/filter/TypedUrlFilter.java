package by.gsu.epamlab.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName ="TypedUrlFilter", value ={"/start", "/result"})
public class TypedUrlFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest =(HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String refferer = httpRequest.getHeader("referer");
        if (refferer==null) {
            httpResponse.sendRedirect(httpRequest.getContextPath());
            return;
        }
        chain.doFilter(request,response);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
