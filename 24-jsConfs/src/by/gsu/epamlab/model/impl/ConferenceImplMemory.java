package by.gsu.epamlab.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.ConferenceDao;
import by.gsu.epamlab.model.beans.Conference;
import by.gsu.epamlab.model.beans.Event;

public class ConferenceImplMemory implements ConferenceDao {

	private static int id = 1;
	private static Map<Integer, Conference> confs = getInitialConferences();
	private static Map<Integer, List<Event>> events = getInitialEvents();
			
	private static Map<Integer, Conference> getInitialConferences() {
		confs = new HashMap<>();
		confs.put(1,  new Conference("IT Planet", "Physics and IT", "25.11"));
		confs.put(2,  new Conference("Math readings", "Math and PT", "10.12"));
		confs.put(3,  new Conference("Live Issues of Physics", "Physics and IT", "15.12"));
		confs.put(4,  new Conference("New Materials", "Physics and IT", "23.12"));
		return confs;
	}
		
	private static Map<Integer, List<Event>> getInitialEvents() {	
		events = new HashMap<>();
		
		events.put(1, new ArrayList<>());
		Collections.addAll(events.get(1),
				new Event(id++, "Arrival", "8:00"),
				new Event(id++, "Opening", "10:00"),
				new Event(id++, "Plenary session", "10:15"),
				new Event(id++, "Dinner", "13:00"),
				new Event(id++, "Sections", "14:00"),
				new Event(id++, "Discussion", "17:00"),
				new Event(id++, "Party", "18:00")
		);
		events.put(2, new ArrayList<>());
		Collections.addAll(events.get(2),
				new Event(id++, "Arrival", "9:30"),
				new Event(id++, "Opening", "10:00"),
				new Event(id++, "Plenary session", "11:00"),
				new Event(id++, "Discussion", "13:00"),
				new Event(id++, "Closing", "14:00")
		);
		events.put(3, new ArrayList<>());
		Collections.addAll(events.get(3),
				new Event(id++, "Opening", "14:00"),
				new Event(id++, "Sections", "14:30"),
				new Event(id++, "Party", "18:00")
		);
		events.put(4, new ArrayList<>());
		return events;
	}
	
	public Map<Integer, Conference> getConferences(){
		return confs;
	}

	public List<Event> getEventsById(int idConf) throws DaoException {
		if(idConf == 3) {
			throw new DaoException("Error simulation...");
		}
		return events.get(idConf);
	}

	public void addEvent(int idConf, String name, String time) {
		List<Event> eventsById = events.get(idConf);
		eventsById.add(new Event(id++, name, time));
	}

}
