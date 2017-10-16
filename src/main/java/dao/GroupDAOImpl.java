package dao;

import logic.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class GroupDAOImpl implements GroupDAO{

    private ConnectionDB connectionDB = new ConnectionDB();

    @Override
    public List<HashMap<String, String>> createGroup(String number, int status, int specialization, int educationForm, int academicDegree, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> getGroup(int id) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "select * from v_group where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectQuery);
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
        connectionDB.stopConnection(conn);
        return list;
    }

    @Override
    public List<HashMap<String, String>> getGroupList() {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();

        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from v_group");
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
        connectionDB.stopConnection(conn);
        return list;
    }

    @Override
    public List<HashMap<String, String>> updateGroup(int id, String number, int status, int specialization, int educationForm, int academicDegree, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> deleteGroup(int id) {
        return null;
    }
}
