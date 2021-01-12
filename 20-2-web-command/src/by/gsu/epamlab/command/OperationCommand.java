package by.gsu.epamlab.command;

import by.gsu.epamlab.command.page.AbstractPage;
import by.gsu.epamlab.command.page.RedirectPage;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDao;
import by.gsu.epamlab.model.factories.OperationEnum;
import by.gsu.epamlab.model.factories.TaskFactory;
import by.gsu.epamlab.model.factories.TypeTableEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public class OperationCommand implements ActionCommand {
    public OperationCommand() {
    }

    @Override
    public AbstractPage execute(HttpServletRequest request) throws DaoException {
        TypeTableEnum typeTable = TypeTableEnum.getTypeTable(request.getParameter(TYPE_TABLE));
        OperationEnum operation = OperationEnum.getOperationEnum(request.getParameter(PRESSED_BUTTON));
        String[] idOperationTask = request.getParameterValues(ID_TASK_FOR_OPERATION);
        int[] idTasks = Arrays.stream(idOperationTask).mapToInt(Integer::parseInt).toArray();
        TaskDao taskDao = TaskFactory.getInstanceFromFactory();
        taskDao.performOperation(idTasks, operation);
        return new RedirectPage(CON_MAIN_HADING + typeTable.toString());
    }
}