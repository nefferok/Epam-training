package by.gsu.epamlab.ifaces;

import java.util.List;
import java.util.Map;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.model.beans.Conference;
import by.gsu.epamlab.model.beans.Event;

public interface ConferenceDao {
	Map<Integer, Conference> getConferences() throws InitException;
	List<Event> getEventsById(int idConf) throws DaoException;
	void addEvent(int idConf, String name, String time);
}
