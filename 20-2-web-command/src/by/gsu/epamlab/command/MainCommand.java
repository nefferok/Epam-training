package by.gsu.epamlab.command;

import by.gsu.epamlab.command.page.AbstractPage;
import by.gsu.epamlab.command.page.ForwardPage;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDao;
import by.gsu.epamlab.model.beans.Task;
import by.gsu.epamlab.model.factories.TaskFactory;
import by.gsu.epamlab.model.factories.TypeTableEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public class MainCommand implements ActionCommand {
    public MainCommand() {
    }

    @Override
    public AbstractPage execute(HttpServletRequest request) throws DaoException {
        HttpSession session = request.getSession();
        int idUser = (int) session.getAttribute(ID_USER);
        TaskDao taskDao = TaskFactory.getInstanceFromFactory();
        TypeTableEnum typeTable = TypeTableEnum.getTypeTable(request.getParameter(TYPE_TABLE));
        request.setAttribute(TYPE_TABLE, typeTable.toString());
        request.setAttribute(NAMES_TYPE_TABLES, typeTable.getNamesTable());
        List<Task> tasks = taskDao.getTasks(idUser, typeTable);
        request.setAttribute(LIST_TASKS, tasks);
        request.setAttribute(BUTTONS_OPERATIONS, typeTable.getButtons());
        return new ForwardPage(PAGE_MAIN_JSP);
    }
}