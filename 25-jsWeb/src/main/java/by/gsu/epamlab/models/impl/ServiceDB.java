package by.gsu.epamlab.models.impl;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceDB {

    private static ServiceDB serviceDB = null;
    private static MysqlDataSource mysqlDataSource;

    private ServiceDB(String dbName, String user, String password) {
        final String JDBC_URL = "jdbc:mysql://localhost:3306/";
        final String SERVER_TIMEZONE = "?serverTimezone=Europe/Minsk";

        mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(JDBC_URL + dbName + SERVER_TIMEZONE);
        mysqlDataSource.setUser(user);
        mysqlDataSource.setPassword(password);
    }

    public static void init(String dbName, String user, String password) {
        if (serviceDB != null) {
            return;
        }
        serviceDB = new ServiceDB(dbName, user, password);
    }

    public static Connection getConnection() throws SQLException {
        return mysqlDataSource.getConnection();
    }
}
