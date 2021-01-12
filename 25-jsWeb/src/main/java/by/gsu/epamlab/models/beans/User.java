package by.gsu.epamlab.models.beans;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import java.io.Serializable;

import static by.gsu.epamlab.constants.ConstantsController.USERNAME_PARAM;
import static by.gsu.epamlab.constants.ConstantsController.USER_PARAM;
import static by.gsu.epamlab.constants.ConstantsListener.*;

public class User implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent ev) {
        System.out.printf(VALUE_BOUND + DESCRIPTION_SESSION_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(), ev.getSession().getId(),
                ev.getName(), ev.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent ev) {
        System.out.printf(VALUE_UNBOUND + DESCRIPTION_SESSION_ATTRIBUTE,
                ev.getClass().getSimpleName(), ev.getSource().getClass().getName(), ev.getSession().getId(),
                ev.getName(), ev.getValue());
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        HttpSession sessionEvent = se.getSession();
        System.out.printf(SESSION_PASSIVATED + DESCRIPTION_MIGRATING_SESSION, se.getClass().getSimpleName(),
                se.getSource().getClass().getName(), se.getSession().getId(), sessionEvent.getAttribute(USER_PARAM));
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        HttpSession sessionEvent = se.getSession();
        System.out.printf(ACTIVATED_SESSION + DESCRIPTION_MIGRATING_SESSION, se.getClass().getSimpleName(),
                se.getSource().getClass().getName(), se.getSession().getId(), sessionEvent.getAttribute(USER_PARAM));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
