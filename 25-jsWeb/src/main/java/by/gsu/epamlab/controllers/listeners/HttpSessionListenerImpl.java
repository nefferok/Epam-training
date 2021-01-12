package by.gsu.epamlab.controllers.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

import static by.gsu.epamlab.constants.ConstantsListener.*;

@WebListener
public class HttpSessionListenerImpl implements HttpSessionListener {
    private int sessionCount;

    public HttpSessionListenerImpl() {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        //session.setMaxInactiveInterval(TIME_INTERVAL);
        System.out.printf(CREATED_SESSION + DESCRIPTION_CREATED_SESSION,
                se.getClass().getSimpleName(), new Date().toString(), session.getId(), ++sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.printf(DESTROYED_SESSION + DESCRIPTION_DESTROYED_SESSION,
                se.getClass().getSimpleName(), se.getSession().getId(), --sessionCount);
    }
}
