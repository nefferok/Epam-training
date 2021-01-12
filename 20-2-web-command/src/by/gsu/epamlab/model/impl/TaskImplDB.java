package by.gsu.epamlab.model.impl;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDao;
import by.gsu.epamlab.model.beans.Task;
import by.gsu.epamlab.model.factories.OperationEnum;
import by.gsu.epamlab.model.factories.PoolConnection;
import by.gsu.epamlab.model.factories.TypeTableEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;
import static by.gsu.epamlab.model.impl.ConstantsSql.*;

public class TaskImplDB implements TaskDao {
    private static final String SQL_HEADING_REQUEST = "SELECT idtask,task,date FROM tasks WHERE iduser = ? ";

    @Override
    public List<Task> getTasks(int idUser, TypeTableEnum typeTable) throws DaoException {
        try (Connection connection = PoolConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_HEADING_REQUEST
                     + typeTable.getRequestSQL())) {
            List<Task> tasks = new ArrayList<>();
            ps.setInt(COLUMN_INDEX_FIRST, idUser);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tasks.add(new Task(rs.getInt(COLUMN_INDEX_FIRST),
                            rs.getString(COLUMN_INDEX_SECOND), rs.getDate(COLUMN_INDEX_THIRD)));
                }
            }
            return tasks;
        } catch (SQLException e) {
            throw new DaoException(ERR_DB, e);
        }
    }

    public void performOperation(int[] idTasks, OperationEnum operation) throws DaoException {
        try (Connection connection = PoolConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(operation.getRequestSQL())) {
            connection.setAutoCommit(false);
            try {
                for (int idTask : idTasks) {
                    ps.setInt(COLUMN_INDEX_FIRST, idTask);
                    ps.executeUpdate();
                }
                connection.commit();
            } catch (SQLException e) {
                try {
                    if (connection != null) {
                        connection.rollback();
                    }
                } catch (Exception exception) {
                    throw new SQLException(exception);
                }
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            throw new DaoException(ERR_DB, e);
        }
    }

    public void addTask(int idUser, Task task) throws DaoException {
        try (Connection connection = PoolConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_ADD_TASK)) {
            ps.setInt(COLUMN_INDEX_FIRST, idUser);
            ps.setString(COLUMN_INDEX_SECOND, task.getTask());
            ps.setDate(COLUMN_INDEX_THIRD, task.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(ERR_DB, e);
        }
    }
}