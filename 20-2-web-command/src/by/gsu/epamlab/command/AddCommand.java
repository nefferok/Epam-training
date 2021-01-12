package by.gsu.epamlab.command;

import by.gsu.epamlab.command.page.AbstractPage;
import by.gsu.epamlab.command.page.RedirectPage;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDao;
import by.gsu.epamlab.model.beans.Task;
import by.gsu.epamlab.model.factories.TaskFactory;
import by.gsu.epamlab.model.factories.TypeTableEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public class AddCommand implements ActionCommand {
    public AddCommand() {
    }

    @Override
    public AbstractPage execute(HttpServletRequest request) throws DaoException {
        HttpSession session = request.getSession();
        TypeTableEnum typeTable = TypeTableEnum.getTypeTable(request.getParameter(TYPE_TABLE));
        String task = request.getParameter(ADD_TASK_VALUE);
        String date = request.getParameter(ADD_TASK_DATE);
        int idUser = (int) session.getAttribute(ID_USER);
        TaskDao taskDao = TaskFactory.getInstanceFromFactory();
        taskDao.addTask(idUser, new Task(task, date));
        return new RedirectPage(CON_MAIN_HADING + typeTable.toString());
    }
}