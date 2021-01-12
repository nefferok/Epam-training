package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.model.beans.Conference;
import by.gsu.epamlab.model.beans.Event;

import java.util.List;
import java.util.Map;

public interface ConferenceDAO {

    Map<Integer, Conference> getConferences() throws InitException;

    List<Event> getEventsById(int id) throws DaoException;
}
