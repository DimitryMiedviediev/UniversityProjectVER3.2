package service;

import dao.UserDAO;
import dao.UserDAOImpl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class AuthenticationService {

    private UserDAO userDAO = new UserDAOImpl();

    public List<HashMap<String, String>> createUser(String name, String lastname, String email, String password, Connection connection) {
        return userDAO.createUser(name, lastname, email, password, connection);
    }

}
