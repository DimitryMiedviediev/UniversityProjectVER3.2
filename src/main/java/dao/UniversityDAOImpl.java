package dao;

import logic.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dimitry on 9/19/17.
 */
public class UniversityDAOImpl implements UniversityDAO {

    private ConnectionDB connectionDB = new ConnectionDB();

    public List<HashMap<String, String>> createUniversity(String titleUa, String codeUa, String titleEn, String codeEn) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            HashMap<String, String> pair = new HashMap<>();
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{CALL P_CREATE_UNIVERSITY(?,?,?,?,?,?)}");
            statement.setString("vTITLE_UA", titleUa);
            statement.setString("vCODE_UA", codeUa);
            statement.setString("vTITLE_EN", titleEn);
            statement.setString("vCODE_EN", codeEn);
            statement.execute();
            pair.put("responseCode", statement.getString("vRESPONSE_CODE"));
            pair.put("responseMessage", statement.getString("vRESPONSE_MESSAGE"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }

    public List<HashMap<String, String>> getUniversity(int id) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_university WHERE id = ?";
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

    public List<HashMap<String, String>> getUniversityList() {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();

        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_university");
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

    public List<HashMap<String, String>> updateUniversity(int id, String titleUa, String codeUa, String titleEn, String codeEn) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{CALL P_UPDATE_UNIVERSITY(?,?,?,?,?,?,?)}");
            statement.setInt("vID", id);
            statement.setString("vTITLE_UA", titleUa);
            statement.setString("vCODE_UA", codeUa);
            statement.setString("vTITLE_EN", titleEn);
            statement.setString("vCODE_EN", codeEn);
            statement.execute();
            HashMap<String, String> pair = new HashMap<>();
            pair.put("responseCode", statement.getString("vRESPONSE_CODE"));
            pair.put("responseMessage", statement.getString("vRESPONSE_MESSAGE"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }

    public List<HashMap<String, String>> deleteUniversity(int id) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{CALL P_DELETE_UNIVERSITY(?,?,?)}");
            statement.setInt("vID", id);
            statement.execute();

            HashMap<String, String> pair = new HashMap<>();
            pair.put("responseCode", statement.getString("vRESPONSE_CODE"));
            pair.put("responseMessage", statement.getString("vRESPONSE_MESSAGE"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }
}
