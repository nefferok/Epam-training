package by.gsu.epamlab.model.impl;

public class ConstantsSql {

    public static final String SELECT_CHECK_USERNAME = "SELECT login FROM users WHERE login = ?";
    public static final String INSERT_NEW_USER = "INSERT INTO users(login, password, mail) VALUES(?, ?, ?)";
    public static final String SELECT_USER = "SELECT id,login,mail FROM users WHERE login = ? AND password = ?";
    public static final String SELECT_TASK_TODAY = "AND fixed = 0 AND `delete` = 0 AND tasks.date <= CURDATE()";
    public static final String SELECT_TASK_TOMORROW = "AND fixed = 0 AND `delete` = 0 AND tasks.date - CURDATE() = 1";
    public static final String SELECT_TASK_SOMEDAY = "AND fixed = 0 AND `delete` = 0 AND tasks.date - CURDATE() > 1";
    public static final String SELECT_TASK_FIXED = "AND fixed = 1 AND `delete` = 0";
    public static final String SELECT_TASK_DEL = "AND `delete` = 1";
    public static final String SQL_ADD_TASK = "INSERT INTO tasks (iduser, task, date,fixed,`delete`) values (?,?,?,0,0)";
    public static final String FIX_TASK = "UPDATE tasks SET fixed = 1 WHERE idtask = ?";
    public static final String REMOVE_TASK = "UPDATE tasks SET `delete` = 1 WHERE idtask = ?";
    public static final String DELETE_TASK = "DELETE FROM tasks where idtask = ?";
    public static final String RESTORE_TASK = "UPDATE tasks SET `delete` = 0 WHERE idtask = ?";
    public static final String CANCEL_TASK = "UPDATE tasks SET fixed = 0 WHERE idtask = ?";
}