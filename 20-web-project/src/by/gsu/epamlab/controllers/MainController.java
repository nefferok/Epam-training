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
import java.util.Arrays;
import java.util.List;

import static by.gsu.epamlab.constants.ConstantsController.*;


@WebServlet(name = MAIN_CONTROLLER, value = MAIN_URL)
public class MainController extends AbstractController {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();

            String view = req.getParameter(VIEW_PARAM);
            String errMsg = req.getParameter(ERROR_MESSAGE);

            int userId = (int) session.getAttribute(USER_ID_PARAM);

            TaskDAO taskImpl = TaskFactory.getClassFromFactory();
            List<Task> tasks = taskImpl.getTasks(userId, view);
            List<String> views = Arrays.asList(ViewsFactory.getViews());
            List<String> buttons = Arrays.asList(ViewsFactory.getButtons(view));


            req.setAttribute(TASKS_PARAM, tasks);
            req.setAttribute(VIEW_PARAM, view);
            req.setAttribute(ERROR_MESSAGE, errMsg);
            req.setAttribute(BUTTONS_PARAM, buttons);
            req.setAttribute(VIEWS_PARAM, views);

            forwardToUrl(req, resp, MAIN_PAGE);

        } catch (DaoException e) {
            forwardToUrlWithErrMsg(req, resp, INDEX_PAGE, e);
        }
    }
}
