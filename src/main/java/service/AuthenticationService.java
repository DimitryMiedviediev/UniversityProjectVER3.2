package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDAO;
import dao.UserDAOImpl;
import logic.ConnectionDB;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class AuthenticationService {

    private UserDAO userDAO = new UserDAOImpl();

    public JsonNode createUser(String email, String password, Connection connection) throws IOException {
        return userDAO.createUser(email, password, connection);
    }

    public Boolean validateUser(String email, String password, Connection connection) throws IOException {
        JsonNode actualObj = userDAO.getUser(email, connection);
        return actualObj.has(0) && Objects.equals(actualObj.get(0).get("email").asText(), email) && Objects.equals(actualObj.get(0).get("password").asText(), password);
    }

    public JsonNode getUserInfo(String email, Connection connection) throws IOException {
        return userDAO.getUser(email, connection);
    }

}
