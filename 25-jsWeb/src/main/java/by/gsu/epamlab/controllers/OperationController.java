package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.models.factories.TaskFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import static by.gsu.epamlab.constants.ConstantsController.*;

@WebServlet(name = OPERATION_CONTROLLER, value = OPERATION_URL)
public class OperationController extends AbstractController {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String[] strIdEvents = req.getParameterValues(EVENT_ID_PARAM);
            String operation = req.getParameter(OPERATION_PARAM);
            String view = req.getParameter(VIEW_PARAM);
            int[] tasks = Arrays.stream(strIdEvents)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            TaskDAO taskImpl = TaskFactory.getClassFromFactory();
            taskImpl.operateTask(operation, tasks);

            redirectTo(req, resp, MAIN_VIEW_URL + view);

        } catch (DaoException e) {
            forwardToUrlWithErrMsg(req, resp, INDEX_PAGE, e);
        }
    }
}
