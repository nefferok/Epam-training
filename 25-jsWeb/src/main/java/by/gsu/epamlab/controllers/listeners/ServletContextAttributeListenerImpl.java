package by.gsu.epamlab.controllers.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import static by.gsu.epamlab.constants.ConstantsListener.*;

@WebListener
public class ServletContextAttributeListenerImpl implements ServletContextAttributeListener {
    public void attributeRemoved(ServletContextAttributeEvent ev) {
        System.out.printf(REMOVED_SERVLET_CONTEXT_ATTRIBUTE + DESCRIPTION_SERVLET_CONTEXT_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(), ev.getName(),ev.getValue());
    }

    public void attributeAdded(ServletContextAttributeEvent ev) {
        System.out.printf(ADDED_SERVLET_CONTEXT_ATTRIBUTE + DESCRIPTION_SERVLET_CONTEXT_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(), ev.getName(),ev.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent ev) {
        System.out.printf(REPLACED_SERVLET_CONTEXT_ATTRIBUTE + DESCRIPTION_SERVLET_CONTEXT_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(), ev.getName(),ev.getValue());
    }
}
