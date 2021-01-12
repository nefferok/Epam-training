package by.gsu.epamlab.controllers.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static by.gsu.epamlab.constants.ConstantsController.PROPERTIES_NAME;
import static by.gsu.epamlab.constants.ConstantsController.PROPERTIES_VALUE;
import static by.gsu.epamlab.constants.ConstantsListener.CONTEXT_DESTROYED;
import static by.gsu.epamlab.constants.ConstantsListener.CONTEXT_INITIALIZED;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    public void contextInitialized(ServletContextEvent ev) {
        ServletContext context = ev.getServletContext();
        System.out.println(CONTEXT_INITIALIZED);
        context.setAttribute(PROPERTIES_NAME, PROPERTIES_VALUE);
    }

    public void contextDestroyed(ServletContextEvent ev) {
        System.out.println(CONTEXT_DESTROYED);
    }
}
