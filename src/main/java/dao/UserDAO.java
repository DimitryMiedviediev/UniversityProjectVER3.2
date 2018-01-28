package dao;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    JsonNode createUser(String email, String password, Connection connection) throws IOException;

    JsonNode getUser(int id, Connection connection) throws IOException;

    JsonNode getUser(String email, Connection connection) throws IOException;

    JsonNode getUserList(Connection connection) throws IOException;

    JsonNode updateUserEmail(int id, String email, Connection connection) throws IOException;

    JsonNode updateUserPassword(int id, String password, Connection connection) throws IOException;

    JsonNode updateUserFullName(int id, String name, String lastname, Connection connection) throws IOException;

    JsonNode updateUser(int id, String name, String lastname, String email, String password, Connection connection) throws IOException;

    JsonNode deleteUser(int id, Connection connection) throws IOException;

}
