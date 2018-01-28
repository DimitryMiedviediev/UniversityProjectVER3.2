package controller.settings;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.xml.internal.bind.v2.TODO;
import logic.ConnectionDB;
import service.AuthenticationService;
import service.SettingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(
        name = "ChangeEmail",
        description = "This is change email servlet",
        urlPatterns = {"/change_email"}
)
public class ChangeEmailController extends HttpServlet {

    private ConnectionDB connectionDB = new ConnectionDB();
    private SettingService settingService = new SettingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(true);
        try {
            JsonNode jsonNode = (JsonNode) session.getAttribute("UserInfo");
            if (jsonNode.get(0) == null) {
                resp.sendRedirect("authorization");
                return;
            }
        } catch (NullPointerException e) {
            resp.sendRedirect("authorization");
            return;
        }

        if (req.getParameter("Confirm") != null) {
            JsonNode userInfo = (JsonNode) session.getAttribute("UserInfo");
            Connection connection = connectionDB.getConnection();
            JsonNode requestDB = settingService.updateUserEmail(userInfo.get(0).get("id").asInt(), req.getParameter("new_email"), connection);

            if (requestDB.get(0).get("responseCode").asInt() == 101) {
                session.setAttribute("UserInfo", settingService.getUserInfo(req.getParameter("new_email"), connection));
                resp.sendRedirect("account_settings");
            } else {
                // TODO доделать возврат ошибок и переход на страницу change_email_error.jsp (саму страницу тоже создать) или реализовать на существующей
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/settings/change_email.jsp");
                dispatcher.forward(req, resp);
            }
            connectionDB.stopConnection(connection);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/settings/change_email.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
