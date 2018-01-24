package controller.errors;

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
        name = "404",
        description = "This is 404 servlet",
        urlPatterns = {"/error"}
)
public class Error404Controller extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getStatus();

        if (resp.getStatus() == 404){
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/errors/404.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("authorization");
        }
    }
}
