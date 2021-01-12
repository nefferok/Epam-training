package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.ActivityDAO;
import by.gsu.epamlab.model.factory.ActivityFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

import static by.gsu.epamlab.constants.ConstantsJSP.*;

@WebServlet(name = "RegController", value = "/reg")
public class RegController extends HttpServlet {
    private static final long serialVersionUID = 2L;

    private static final String CONFIRM_PATH = "/confirm.jsp?account=";
    private static final String ERROR_PARAM = "&error=yes";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int idConf = (int) session.getAttribute(ID_ATR_PARAM);
        String account = req.getParameter(ACCAUNT_PARAM);
        String [] strEvents = req.getParameterValues(ID_EVENT_PARAM);
        int [] events = Arrays.stream(strEvents)
                .mapToInt(Integer::parseInt)
                .toArray();
        ActivityDAO activityDAO = ActivityFactory.getClassFromFactory();
        String errorFlag = "";
        try {
            activityDAO.addParticipant(account, idConf, events);
        } catch (DaoException e) {
            errorFlag += ERROR_PARAM;
        }
        resp.sendRedirect(req.getContextPath() + CONFIRM_PATH + account + errorFlag);
    }
}
