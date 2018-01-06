package dao;

import logic.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    private ConnectionDB connectionDB = new ConnectionDB();

    @Override
    public List<HashMap<String, String>> createUser(String name, String lastname, String email, String password, Connection connection) {
        List<HashMap<String, String>> list = new ArrayList<>();
        try {
            HashMap<String, String> pair = new HashMap<>();
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call p_create_user(?,?,?,?,?,?)}");
            statement.setString("p_name", name);
            statement.setString("p_lastname", lastname);
            statement.setString("p_email", email);
            statement.setString("p_password", password);
            statement.execute();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HashMap<String, String>> getUser(int id, Connection connection) {
        List<HashMap<String, String>> list = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "select * from user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                HashMap<String, String> pair = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    pair.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(resultSet.getMetaData().getColumnName(i)));
                }
                list.add(pair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HashMap<String, String>> getUserList(Connection connection) {
        List<HashMap<String, String>> list = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                HashMap<String, String> pair = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    pair.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(resultSet.getMetaData().getColumnName(i)));
                }
                list.add(pair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HashMap<String, String>> updateUser(int id, String name, String lastname, String email, String password, Connection connection) {
        List<HashMap<String, String>> list = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call p_update_user(?,?,?,?,?,?,?)}");
            statement.setInt("p_id", id);
            statement.setString("p_name", name);
            statement.setString("p_lastname", lastname);
            statement.setString("p_email", email);
            statement.setString("p_password", password);
            statement.execute();
            HashMap<String, String> pair = new HashMap<>();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HashMap<String, String>> deleteUser(int id, Connection connection) {
        List<HashMap<String, String>> list = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call p_delete_user(?,?,?)}");
            statement.setInt("p_id", id);
            statement.execute();

            HashMap<String, String> pair = new HashMap<>();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
