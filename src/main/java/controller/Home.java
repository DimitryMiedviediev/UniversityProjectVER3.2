package controller;

import com.fasterxml.jackson.databind.JsonNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "Home",
        description = "This is home servlet",
        urlPatterns = {"/home"}
)
public class Home extends HttpServlet {
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
            if (jsonNode.get(0) == null) resp.sendRedirect("authorization");
        } catch (NullPointerException e) {
            resp.sendRedirect("authorization");
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home/home.jsp");
        dispatcher.forward(req, resp);
    }
}
