package by.gsu.epamlab.model.factories;

import java.util.ResourceBundle;

import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.ifaces.ConferenceDao;
import by.gsu.epamlab.model.impl.ConferenceImplMemory;

public class ConferenceFactory {
	private enum Source {
		MEMORY {
			@Override
			ConferenceDao getImpl(ResourceBundle rb) {
				return new ConferenceImplMemory();
			}
		};
		
		abstract ConferenceDao getImpl(ResourceBundle rb) throws InitException;
	};

	private static ConferenceDao conferenceImpl;
	
	public static void init(ResourceBundle rb) throws InitException {
		Source source = Source.valueOf(rb.getString("factory.conf").toUpperCase()); 
		conferenceImpl = source.getImpl(rb);
	}
	
	public static ConferenceDao getClassFromFactory() {
		return conferenceImpl;
	}
}
