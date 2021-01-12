package by.gsu.epamlab.model.factories;

import java.util.ResourceBundle;

import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.ifaces.ActivityDao;
import by.gsu.epamlab.model.impl.ActivityImplCsv;

public class ActivityFactory {
	
	private enum Source {
		CSV {
			@Override
			ActivityDao getImpl(ResourceBundle rb) {
				return new ActivityImplCsv(rb.getString("activity.csv.name"));
			}
		};
		
		abstract ActivityDao getImpl(ResourceBundle rb) throws InitException;
	};

	
	private static ActivityDao activityImpl;
	
	public static void init(ResourceBundle rb) throws InitException {
		Source source = Source.valueOf(rb.getString("factory.activity").toUpperCase()); 
		activityImpl = source.getImpl(rb);
	}

	public static ActivityDao getClassFromFactory() {
		return activityImpl;
	}
}
