import com.fasterxml.jackson.databind.JsonNode;
import dao.UserDAO;
import dao.UserDAOImpl;
import jSONextracter.UserInfo;
import logic.ConnectionDB;
import service.AuthenticationService;

import java.io.IOException;
import java.sql.Connection;

public class Start {
    public static void main(String[] args) {
//        AuthenticationService authenticationService = new AuthenticationService();
        UserInfo ui = new UserInfo();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();
        UserDAO userDAO = new UserDAOImpl();
        try {
            JsonNode userInfo = userDAO.getUser(15, connection);
            System.out.println(userInfo);
            System.out.println(ui.getUserName(userInfo));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(authenticationService.validateUser("dimidiev@gmail.com", "20101995", connection));
        connectionDB.stopConnection(connection);
    }
}
