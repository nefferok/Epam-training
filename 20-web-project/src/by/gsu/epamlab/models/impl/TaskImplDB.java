package by.gsu.epamlab.models.impl;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.models.beans.Task;
import by.gsu.epamlab.models.factories.OperationFactory;
import by.gsu.epamlab.models.factories.ViewsFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static by.gsu.epamlab.constants.ConstantsError.*;
import static by.gsu.epamlab.constants.ConstantsSQL.INSERT_NEW_TASK;
import static by.gsu.epamlab.constants.ConstantsSQL.SELECT_TASKS;

public class TaskImplDB implements TaskDAO {
    private final static Logger LOGGER = Logger.getLogger(TaskImplDB.class.getName());

    @Override
    public List<Task> getTasks(int usrId, String view) throws DaoException {
        try (Connection cn = ServiceDB.getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_TASKS + ViewsFactory.getReqVersion(view))) {

            List<Task> tasks = new ArrayList<>();

            final int USER_ID_INDEX = 1;
            final int TASK_ID_INDEX = 1;
            final int TASK_DESCRIPTION_INDEX = 2;
            final int TASK_DATE_INDEX = 3;

            ps.setInt(USER_ID_INDEX, usrId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tasks.add(new Task(rs.getInt(TASK_ID_INDEX), rs.getString(TASK_DESCRIPTION_INDEX), rs.getDate(TASK_DATE_INDEX)));
                }
            }
            return tasks;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new DaoException(ERR_DATA_SOURCE);
        }
    }

    @Override
    public void addTask(int usrId, String description, String date) throws DaoException {
        synchronized (this) {
            try (Connection cn = ServiceDB.getConnection();
                 PreparedStatement ps = cn.prepareStatement(INSERT_NEW_TASK)) {

                final int USER_ID_INDEX = 1;
                final int TASK_DESCRIPTION_INDEX = 2;
                final int TASK_DATE_INDEX = 3;

                ps.setInt(USER_ID_INDEX, usrId);
                ps.setString(TASK_DESCRIPTION_INDEX, description);
                ps.setDate(TASK_DATE_INDEX, Date.valueOf(date));

                ps.executeUpdate();

            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, e.toString(), e);
                throw new DaoException(ERR_DATA_SOURCE);
            }
        }
    }

    @Override
    public void operateTask(String operation, int[] events) throws DaoException {
        try (Connection cn = ServiceDB.getConnection()) {
            cn.setAutoCommit(false);

            synchronized (this) {
                try (PreparedStatement ps = cn.prepareStatement(OperationFactory.getOperationRequest(operation))) {
                    final int EVENT_INDEX = 1;
                    for (int event : events) {
                        ps.setInt(EVENT_INDEX, event);
                        ps.addBatch();
                    }
                    ps.executeBatch();
                    cn.commit();

                } catch (SQLException e1) {
                    try {
                        if (cn != null) {
                            cn.rollback();
                        }
                    } catch (SQLException e2) {
                        LOGGER.log(Level.WARNING, ERR_ROLLBACK, e2);
                    }
                    LOGGER.log(Level.SEVERE, e1.toString(), e1);
                    throw new DaoException(ERR_OPERATION + operation);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new DaoException(ERR_DATA_SOURCE);
        }
    }
}
