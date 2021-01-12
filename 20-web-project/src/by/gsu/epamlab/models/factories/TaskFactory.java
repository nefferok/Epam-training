package by.gsu.epamlab.models.factories;

import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.models.impl.ServiceDB;
import by.gsu.epamlab.models.impl.TaskImplDB;

import java.util.ResourceBundle;

import static by.gsu.epamlab.constants.ConstantsController.*;

public class TaskFactory {

    private enum Source {
        DB{
            @Override
            TaskDAO getImpl(ResourceBundle rb){
                ServiceDB.init(
                        rb.getString(DB_NAME_SOURCE_KEY),
                        rb.getString(DB_USER_SOURCE_KEY),
                        rb.getString(DB_PASSWORD_SOURCE_KEY)
                );
                return new TaskImplDB();
            }
        };

        abstract TaskDAO getImpl(ResourceBundle rb);
    }

    private static TaskDAO taskImpl;

    public static void init(ResourceBundle rb) {
        String taskImplName = rb.getString(TASKS_SOURCE_KEY);
        Source source = Source.valueOf(taskImplName.toUpperCase());
        taskImpl = source.getImpl(rb);
    }

    public static TaskDAO getClassFromFactory() {
        return taskImpl;
    }
}
