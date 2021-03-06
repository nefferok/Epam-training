package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDAO;
import by.gsu.epamlab.models.factories.TaskFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.gsu.epamlab.constants.ConstantsController.*;

@WebServlet(name = ADD_TASK_CONTROLLER, value = ADD_TASK_URL)
public class AddTaskController extends AbstractController{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();

            String date = req.getParameter(DATE_PARAM);
            String description = req.getParameter(DESCRIPTION_PARAM);
            String view = req.getParameter(VIEW_PARAM);
            String curDate = req.getParameter(CUR_DATE_PARAM);
            int userId = (int) session.getAttribute(USER_ID_PARAM);

            TaskDAO taskImpl = TaskFactory.getClassFromFactory();
            taskImpl.addTask(userId, description, date);

            final String ADD_PAGE_URL = "/add.jsp?view=";
            final String CUR_DATE_PARAM = "&curDate=";
            final String ADD_YES_PARAM = "&added=yes";

            redirectTo(req, resp, ADD_PAGE_URL + view + CUR_DATE_PARAM + curDate + ADD_YES_PARAM);

        } catch (DaoException e) {
            forwardToUrlWithErrMsg(req, resp, ADD_TASK_PAGE, e);
        }
    }
}
