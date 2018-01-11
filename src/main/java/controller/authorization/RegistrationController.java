package controller.authorization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@WebServlet(
        name = "Registration",
        description = "This is registration servlet",
        urlPatterns = {"/registration"}
)
public class RegistrationController extends HttpServlet {

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

        if (req.getParameter("SignUp") != null && Objects.equals(req.getParameter("password"), req.getParameter("reset_password"))) {
            Connection connection = connectionDB.getConnection();
            JsonNode actualObj = authenticationService.createUser(
                    req.getParameter("email"),
                    req.getParameter("password"),
                    connection);
            connectionDB.stopConnection(connection);
            if (actualObj.get(0).get("responseCode").asInt() == 101) {
                resp.sendRedirect("authorization");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/authentication/registration.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/authentication/registration.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
