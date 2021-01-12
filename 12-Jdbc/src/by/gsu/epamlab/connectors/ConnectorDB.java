package by.gsu.epamlab.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static by.Constants.*;

public class ConnectorDB {
	public static Connection getConnection() throws SQLException {
		   ResourceBundle resource = ResourceBundle.getBundle(PROPERTIES_FILE);
		   String url = resource.getString(DB_URL_PROP);
		   String user = resource.getString(USER_PROP);
		   String pass = resource.getString(PASSWORD_PROP);
		   return DriverManager.getConnection(url, user, pass);	 
		}
}
