package by.gsu.epamlab.constants;

public class ConstantsSQL {
    public static final String SELECT_CHECK_USERNAME = "SELECT name FROM users WHERE name=?";
    public static final String INSERT_NEW_USER = "INSERT users (name,password) values (?,?)";
    public static final String SELECT_USER = "SELECT id,name FROM users WHERE name = ? and password = ?";
    public static final String SELECT_TASKS = "SELECT idEvent, description, date FROM tasks WHERE idUser = ?";
    public static final String INSERT_NEW_TASK = "INSERT INTO tasks (idUser, description, date) VALUES (?, ?, ?)";
    public static final String POSTFIX_TO_QUERY_TODAY = " and fixed = 0  and recycled = 0 and date <= curdate()";
    public static final String POSTFIX_TO_QUERY_TOMORROW = " and fixed = 0  and recycled = 0 and date = curdate() + 1";
    public static final String POSTFIX_TO_QUERY_SOMEDAY = " and fixed = 0  and recycled = 0 and date > curdate() + 1";
    public static final String POSTFIX_TO_QUERY_FIXED = " and fixed = 1 and recycled = 0";
    public static final String POSTFIX_TO_QUERY_RECYCLE = " and recycled = 1";

    public static final String FIX_TASK_QUERY = "update tasks set fixed = 1 where idEvent = ?";
    public static final String UNFIX_TASK_QUERY = "update tasks set fixed = 0 where idEvent = ?";
    public static final String RECYCLE_TASK_QUERY = "update tasks set recycled = 1 where idEvent = ?";
    public static final String RESTORE_TASK_QUERY = "update tasks set recycled = 0 where idEvent = ?";
    public static final String DELETE_TASK_QUERY = "delete from tasks where idEvent = ?";
    public static final String DELETE_ALL_TASKS_QUERY = "delete from tasks where idEvent = ?";
}
