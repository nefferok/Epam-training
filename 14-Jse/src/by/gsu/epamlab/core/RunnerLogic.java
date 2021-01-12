package by.gsu.epamlab.core;

import by.Constants;
import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.connector.DBHandler;
import by.gsu.epamlab.connector.ResultsLoader;
import by.gsu.epamlab.exception.DataBaseException;
import by.gsu.epamlab.exception.ReaderException;
import by.gsu.epamlab.factories.ResultFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static by.Constants.*;

public class RunnerLogic {
    public static void performTask(ResultFactory factory, String path){
         try{
            ResultsLoader.loadResults(factory.getImplementation(path));
            printMainMarks(factory);
            loadToListAndPrint(factory);
        } catch (DataBaseException | ReaderException e) {
            System.err.println(e);
        } finally {
            DBHandler.closeConnection(DBHandler.getConnection());
         }
    }

    public static void printMainMarks(ResultFactory factory){
        try(Statement st = DBHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_MEAN_MARK)) {
            while (rs.next()) {
                System.out.println(rs.getString(INDEX_NAME_COLUMN) + ARROW + factory.getMainMark(rs.getDouble(INDEX_MEAN_COLUMN)));
            }
        } catch (SQLException e){
            System.err.println(EXCEPTION_SEARC_MEAN);
        }
    }

    public static void loadToListAndPrint(ResultFactory factory) throws DataBaseException{
        try(Statement st = DBHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_SORT_MARK_IN_MONTH)) {
            List<Result> list = new LinkedList<>();
            while (rs.next()) {
                Result current = factory.getResultFromFacory(rs.getString(INDEX_NAME_COLUMN), rs.getString(INDEX_TEST_COLUMN), rs.getDate(INDEX_DATE_COLUMN), rs.getInt(INDEX_MARK_COLUMN));
                System.out.println(current);
                list.add(current);
            }
            System.out.println();
            if (!list.isEmpty()) {
                ListIterator<Result> it = list.listIterator(list.size());
                Result last = it.previous();
                System.out.println(last);
                while (it.hasPrevious()) {
                    Result prev = it.previous();
                    if (last.getDate().equals(prev.getDate())) {
                        System.out.println(prev);
                    } else break;
                }
            } else System.out.println(Constants.NOT_FOUND_ELEMENT);
        } catch (SQLException e){
            throw new DataBaseException(EXCEPTION_LOAD_LIST, e);
        }
    }
}
