package by.gsu.epamlab.connector;

import by.Constants;
import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.exception.DataBaseException;
import by.gsu.epamlab.intrefaces.IResultDAO;

import static by.Constants.*;

import java.sql.*;

public class ResultsLoader {

    public static void loadResults(IResultDAO source) throws DataBaseException {
        Connection cn = DBHandler.getConnection();
        try (PreparedStatement psSelectLogin = cn.prepareStatement(SQL_SELECT_ID_LOGIN);
             PreparedStatement psSelectTest = cn.prepareStatement(SQL_SELECT_ID_TEST);
             PreparedStatement psLogins = cn.prepareStatement(SQL_INSERT_LOGINS);
             PreparedStatement psTests = cn.prepareStatement(SQL_INSERT_TESTS);
             PreparedStatement psResults = cn.prepareStatement(SQL_INSERT_RESULTS)) {

            clearBase(SQL_DELETE_RESULTS);
            clearBase(SQL_DELETE_TESTS);
            clearBase(SQL_DELETE_LOGINS);

            while (source.hasResult()) {
                Result result = source.nextResult();

               int nameId = getId(result.getLogin(), psSelectLogin, psLogins);
               int testId = getId(result.getTest(), psSelectTest, psTests);

                psResults.setInt(INDEX_NAME_COLUMN, nameId);
                psResults.setInt(INDEX_TEST_COLUMN, testId);
                psResults.setDate(INDEX_DATE_COLUMN, result.getDate());
                psResults.setInt(INDEX_MARK_COLUMN, result.getMark());
                psResults.addBatch();
            }
            psResults.executeBatch();
            source.closeReader();
        } catch (SQLException e) {
            throw new DataBaseException(EXCEPTION_LOAD_BASE, e);
        }
    }

    private static int getId(String name, PreparedStatement psSelectQuery, PreparedStatement psInsertQuery) throws SQLException {
        final int DIRECTORY_ELEMENT_INDEX = 1;

        ResultSet rs = null;
        try{
            psSelectQuery.setString(DIRECTORY_ELEMENT_INDEX, name);
            rs = psSelectQuery.executeQuery();
            if (!rs.next()){
                psInsertQuery.setString(DIRECTORY_ELEMENT_INDEX, name);
                psInsertQuery.executeUpdate();
                rs = psSelectQuery.executeQuery();
                rs.next();
            }
            return rs.getInt(ID_INDEX);
        } finally {
            DBHandler.closeResultSet(rs);
        }
    }

    private static void clearBase(String closeQuery) throws SQLException {
        Statement st = null;
        try {
            st = DBHandler.getConnection().createStatement();
            st.execute(closeQuery);
        } finally {
            DBHandler.closeStatement(st);
        }
    }
}
