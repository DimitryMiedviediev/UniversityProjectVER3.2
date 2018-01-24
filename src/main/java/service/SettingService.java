package service;

import com.fasterxml.jackson.databind.JsonNode;
import dao.UserDAO;
import dao.UserDAOImpl;

import java.io.IOException;
import java.sql.Connection;

public class SettingService {
    private UserDAO userDAO = new UserDAOImpl();

    public JsonNode updateUserEmail(int id, String email, Connection connection) throws IOException {
        return userDAO.updateUserEmail(id, email, connection);
    }

    public JsonNode updateUserPassword(int id, String password, Connection connection) throws IOException {
        return userDAO.updateUserPassword(id, password, connection);
    }

    public JsonNode getUserInfo(String email, Connection connection) throws IOException {
        return userDAO.getUser(email, connection);
    }
}
