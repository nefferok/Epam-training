package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.model.beans.Task;
import by.gsu.epamlab.model.factories.OperationEnum;
import by.gsu.epamlab.model.factories.TypeTableEnum;

import java.util.List;

public interface TaskDao {
    List<Task> getTasks(int id, TypeTableEnum typeTable) throws DaoException;

    void performOperation(int[] idTasks, OperationEnum operation) throws DaoException;

    void addTask(int idUser, Task task) throws DaoException;

}