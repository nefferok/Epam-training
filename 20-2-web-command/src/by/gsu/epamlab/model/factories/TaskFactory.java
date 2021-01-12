package by.gsu.epamlab.model.factories;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.ifaces.TaskDao;
import by.gsu.epamlab.model.impl.TaskImplDB;
import java.util.ResourceBundle;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public class TaskFactory {
    private enum Source {
        MYSQL {
            @Override
            TaskDao getImpl(ResourceBundle rb) {
                PoolConnection.init(rb.getString(DB_NAME),
                        rb.getString(DB_USER), rb.getString(DB_PASSWORD));
                return new TaskImplDB();
            }
        };

        abstract TaskDao getImpl(ResourceBundle rb) throws InitException;

    }

    private static TaskDao taskImpl;

    public static void init(ResourceBundle rb) throws InitException {
        String sourceType = rb.getString(WEB_TASK);
        Source source = Source.valueOf(sourceType.toUpperCase());
        taskImpl = source.getImpl(rb);
    }

    public static TaskDao getInstanceFromFactory() throws DaoException {
        if(taskImpl == null){
            throw new DaoException(ERR_DB_CON_PROP);
        }
        return  taskImpl;
    }
}