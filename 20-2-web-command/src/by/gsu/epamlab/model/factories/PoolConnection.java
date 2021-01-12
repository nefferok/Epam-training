package by.gsu.epamlab.model.factories;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnection {
    private static MysqlDataSource dataSource;
    private static PoolConnection poolConnection = null;
    private static final String URL_HEADER = "jdbc:mysql://127.0.0.1:3306/";
    private static final String URL_FOOTER = "?serverTimezone=Europe/Minsk";

    private PoolConnection(String dbName, String user, String password) {
        dataSource = new MysqlDataSource();
        dataSource.setURL(URL_HEADER + dbName + URL_FOOTER);
        dataSource.setUser(user);
        dataSource.setPassword(password);

    }

    public static void init(String dbName, String user, String password) {
        if (dataSource != null) {
            return;
        }
        poolConnection = new PoolConnection(dbName, user, password);

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}