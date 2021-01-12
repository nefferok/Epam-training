package by.gsu.epamlab.controllers.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import static by.gsu.epamlab.constants.ConstantsListener.*;

@WebListener
public class HttpSessionAttributeListenerImpl implements HttpSessionAttributeListener {

    public void attributeRemoved(HttpSessionBindingEvent ev) {
        System.out.printf(REMOVED_SESSION_ATTRIBUTE + DESCRIPTION_SESSION_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(), ev.getSession().getId(),
                ev.getName(), ev.getValue());
    }

    public void attributeAdded(HttpSessionBindingEvent ev) {
        System.out.printf(ADDED_SESSION_ATTRIBUTE + DESCRIPTION_SESSION_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(), ev.getSession().getId(),
                ev.getName(), ev.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent ev) {
        System.out.printf(REPLACED_SESSION_ATTRIBUTE + DESCRIPTION_SESSION_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(), ev.getSession().getId(),
                ev.getName(), ev.getValue());
    }
}
