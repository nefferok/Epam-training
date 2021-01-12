package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.models.beans.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> getTasks(int usrId, String view) throws DaoException;
    void addTask(int usrId, String description, String date) throws DaoException;
    void operateTask(String operation, int[] events) throws DaoException;
}
