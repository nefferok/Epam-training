package by.gsu.epamlab.connector;

import java.sql.*;
import java.util.*;

import static by.Constants.*;

public class DBHandler {

    private static final Connection connection;

    private DBHandler() {
    }

    static {
        Connection con = null;
        try {
            ResourceBundle resource = ResourceBundle.getBundle(PROPERTIES_FILE);
            String url = resource.getString(PROPERIES_DB_URL);
            String user = resource.getString(PROPERIES_USER_NAME);
            String pass = resource.getString(PROPERTIES_PASSWORD);
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println(EXCEPTION_CREATE_CONNECTION + e);
        }
        connection = con;
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection(Connection resourse) {
        if (resourse != null) {
            try {
                resourse.close();
            } catch (SQLException e) {
                System.err.println(EXCEPTION_CLOSE_CONNECTION + e);
            }
        }
    }

    public static void closeResultSet(ResultSet resourse) {
        if (resourse != null) {
            try {
                resourse.close();
            } catch (SQLException e) {
                System.err.println(EXCEPTION_CLOSE_RESULT_SET+ e);
            }
        }
    }

    public static void closeStatement(Statement resourse) {
        if (resourse != null) {
            try {
                resourse.close();
            } catch (SQLException e) {
                System.err.println(EXCEPTION_CLOSE_STATEMENT + e);
            }
        }
    }
}
