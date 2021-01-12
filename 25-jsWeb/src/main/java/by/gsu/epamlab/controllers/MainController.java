package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.models.beans.Task;
import by.gsu.epamlab.models.factories.ViewsFactory;
import by.gsu.epamlab.models.factories.TaskFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import static by.gsu.epamlab.constants.ConstantsController.*;
import static by.gsu.epamlab.constants.ConstantsError.ERR_DATA_SOURCE;


@WebServlet(name = MAIN_CONTROLLER, value = MAIN_URL)
public class MainController extends AbstractController {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            PrintWriter out = resp.getWriter();
            String view = req.getParameter(VIEW_PARAM);
            int userId = (int) session.getAttribute(USER_ID_PARAM);

            TaskDAO taskImpl = TaskFactory.getClassFromFactory();
            List<Task> tasks = taskImpl.getTasks(userId, view);
            List<String> views = Arrays.asList(ViewsFactory.getViews());
            List<String> buttons = Arrays.asList(ViewsFactory.getButtons(view));
            String jsonTasks = Utilities.getJsonTasks(tasks);
            String jsonViews = Utilities.getJsonByList(views);
            String jsonButtons = Utilities.getJsonByList(buttons);
            String jsonTasksViewsButtons = TASKS_PARAM + jsonTasks
                    + VIEWS_PARAM + jsonViews + BUTTONS_PARAM + jsonButtons + CLOSING_BRACKET;
            out.print(jsonTasksViewsButtons);

        } catch (DaoException e) {
            writeToLog(this.getClass(), e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ERR_DATA_SOURCE);
        }
    }
}
