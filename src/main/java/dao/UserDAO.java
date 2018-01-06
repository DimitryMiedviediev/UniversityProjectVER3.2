package dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    List<HashMap<String, String>> createUser(String name, String lastname, String email, String password, Connection connection);

    List<HashMap<String, String>> getUser(int id, Connection connection);

    List<HashMap<String, String>> getUserList(Connection connection);

    List<HashMap<String, String>> updateUser(int id, String name, String lastname, String email, String password, Connection connection);

    List<HashMap<String, String>> deleteUser(int id, Connection connection);

}
