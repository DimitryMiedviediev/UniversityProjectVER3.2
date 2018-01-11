package controller.authorization;

import com.fasterxml.jackson.databind.JsonNode;

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
        name = "ResetPassword",
        description = "This is reset password servlet",
        urlPatterns = {"/reset_password"}
)
public class ResetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(true);

        if (req.getParameter("Reset") != null) {
            resp.sendRedirect("authorization");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/authentication/reset_password.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
