package by.gsu.epamlab.controllers.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import static by.gsu.epamlab.constants.ConstantsListener.*;

@WebListener
public class ServletRequestAttributeListenerImpl implements ServletRequestAttributeListener {

    public void attributeRemoved(ServletRequestAttributeEvent ev) {
        HttpServletRequest request = (HttpServletRequest) ev.getServletRequest();
        System.out.printf(REMOVED_SERVLET_REQUEST_ATTRIBUTE + DESCRIPTION_SERVLET_REQUEST_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(),request.getRequestedSessionId(),
                ev.getName(), ev.getValue());
    }

    public void attributeAdded(ServletRequestAttributeEvent ev) {
        HttpServletRequest request = (HttpServletRequest) ev.getServletRequest();
        System.out.printf(ADDED_SERVLET_REQUEST_ATTRIBUTE + DESCRIPTION_SERVLET_REQUEST_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(),request.getRequestedSessionId(),
                ev.getName(), ev.getValue());
    }

    public void attributeReplaced(ServletRequestAttributeEvent ev) {
        HttpServletRequest request = (HttpServletRequest) ev.getServletRequest();
        System.out.printf(REPLACED_SERVLET_REQUEST_ATTRIBUTE + DESCRIPTION_SERVLET_REQUEST_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(),request.getRequestedSessionId(),
                ev.getName(), ev.getValue());
    }
}
