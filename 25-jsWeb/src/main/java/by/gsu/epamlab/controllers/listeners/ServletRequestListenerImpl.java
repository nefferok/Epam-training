package by.gsu.epamlab.controllers.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static by.gsu.epamlab.constants.ConstantsListener.*;

@WebListener
public class ServletRequestListenerImpl implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent ev) {
        HttpServletRequest request = (HttpServletRequest) ev.getServletRequest();
        String refererValue = request.getHeader(HEADER_NAME_REFERER);
        System.out.printf(DESCRIPTION_INITIALIZED_REQUEST, ev.getClass().getSimpleName(),
                request.getRequestURI(), (refererValue == null) ? EMPTY_REFERER : refererValue,
                request.getRequestedSessionId(), request.getRemoteAddr(), request.getMethod(),
                request.getQueryString());
        printRequestParameters(request);
    }

    private void printRequestParameters(HttpServletRequest request) {
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        System.out.println((requestParameterMap.isEmpty()) ?
                REQUEST_WITHOUT_PARAMETERS : REQUEST_WITH_PARAMETERS);
        requestParameterMap.forEach((name, values) ->
                System.out.println(name + KEY_VALUE_DELIMITER + ((values.length != 1) ?
                        Arrays.toString(requestParameterMap.get(name)) : values[0])));
    }

    public void requestDestroyed(ServletRequestEvent ev) {
        HttpServletRequest request = (HttpServletRequest) ev.getServletRequest();
        System.out.printf(REQUEST_DESTROYED,request.getRequestURI());
    }
}
