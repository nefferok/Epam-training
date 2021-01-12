package by.gsu.epamlab.model.impl;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.exceptions.InitRuntimeException;
import by.gsu.epamlab.ifaces.ConferenceDAO;
import by.gsu.epamlab.model.beans.Conference;
import by.gsu.epamlab.model.beans.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static by.gsu.epamlab.constants.ConstantMain.*;
import static by.gsu.epamlab.constants.ConstantsException.*;

public class ConferenceImplDb implements ConferenceDAO {

    public ConferenceImplDb(ResourceBundle rb) {
        try {
            String dbUrl = rb.getString(PROPERTIES_DB_NAME);
            String user = rb.getString(PROPERTIES_DB_USER);
            String password = rb.getString(PROPERTIES_DB_PASS);
            ServiceDb.init(dbUrl, user, password);
        } catch (InitException e) {
            throw new InitRuntimeException(EXCEPTION_INIT_DB + e);
        }
    }


    @Override
    public Map<Integer, Conference> getConferences() throws InitException {

        final String COL_ID = "idConf";
        final String COL_NAME = "name";
        final String COL_FACULTY = "faculty";
        final String COL_DATE = "date";
        final String SQL_SELECT_CONF = "select idConf, name, faculty, date from conferences";

        Map<Integer, Conference> confs = new HashMap<>();
        try (Connection cn = ServiceDb.getConnection();
             ResultSet rs = cn.createStatement().executeQuery(SQL_SELECT_CONF)) {
            while (rs.next()) {
                confs.put(rs.getInt(COL_ID), new Conference(rs.getString(COL_NAME), rs.getString((COL_FACULTY)), rs.getString(COL_DATE)));
            }
            return confs;
        } catch (SQLException e) {
            throw new InitException(EXCEPTION_DB_READ_CONF + e);
        }
    }


    @Override
    public List<Event> getEventsById(int id) throws DaoException {

        final String SQL_SELECT_EVENT = "select idEvent, name, time from events where confId = ";
        final String COL_ID = "idEvent";
        final String COL_NAME = "name";
        final String COL_TIME = "time";

        List<Event> events = new ArrayList<>();
        try (Connection cn = ServiceDb.getConnection();
             ResultSet rs = cn.createStatement().executeQuery(SQL_SELECT_EVENT + id)) {
            while (rs.next()) {
                events.add(new Event(rs.getInt(COL_ID),
                        rs.getString(COL_NAME),
                        rs.getString(COL_TIME)));
            }
            return events;
        } catch (SQLException e) {
            throw new DaoException(EXCEPTION_DB_READ_EVENT + e);
        }
    }
}

