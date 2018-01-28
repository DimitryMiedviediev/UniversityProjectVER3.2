package controller.settings;

import com.fasterxml.jackson.databind.JsonNode;
import logic.ConnectionDB;
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
import java.util.Objects;

@WebServlet(
        name = "ChangeFullName",
        description = "This is change full name servlet",
        urlPatterns = {"/change_full_name"}
)
public class ChangeFullName extends HttpServlet{

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
            JsonNode requestDB = settingService.updateUserFullName(userInfo.get(0).get("id").asInt(), req.getParameter("name"), req.getParameter("lastname"), connection);
//            resp.sendRedirect("account_settings");

            // TODO доделать процедуру в БД и нормальную отработку здесь. Плюс добавить реакццию на ответ из базы 101 (например)
            if (requestDB.get(0).get("responseCode").asInt() == 101) {
                session.setAttribute("UserInfo", settingService.getUserInfo(userInfo.get(0).get("email").asText(), connection));
                resp.sendRedirect("profile_settings");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/settings/change_full_name.jsp");
                dispatcher.forward(req, resp);
            }

            connectionDB.stopConnection(connection);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/settings/change_full_name.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
