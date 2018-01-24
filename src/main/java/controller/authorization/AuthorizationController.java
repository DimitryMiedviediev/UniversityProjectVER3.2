package controller.authorization;

import com.fasterxml.jackson.databind.JsonNode;
import logic.ConnectionDB;
import service.AuthenticationService;

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
        name = "Authorization",
        description = "This is authorization servlet",
        urlPatterns = {"/authorization"}
)
public class AuthorizationController extends HttpServlet {

    private ConnectionDB connectionDB = new ConnectionDB();
    private AuthenticationService authenticationService = new AuthenticationService();

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
            if (jsonNode.get(0) != null) {
                resp.sendRedirect("home");
                return;
            }
        } catch (NullPointerException ignored) {
        }

        if (req.getParameter("SignIn") != null) {
            Connection connection = connectionDB.getConnection();
            Boolean bool = authenticationService.validateUser(req.getParameter("email"),
                    req.getParameter("password"),
                    connection);
            JsonNode userInfo = authenticationService.getUserInfo(req.getParameter("email"), connection);
            connectionDB.stopConnection(connection);
            if (bool) {
                session.setAttribute("UserInfo", userInfo);
                resp.sendRedirect("home");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/authentication/authorization.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/authentication/authorization.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
