package dao;

import logic.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpecializationDAOImpl implements SpecializationDAO {

    private ConnectionDB connectionDB = new ConnectionDB();

    @Override
    public List<HashMap<String, String>> createSpecialization(String titleUa, String codeUa, String titleEn, String codeEn, int speciality, int bachelor, int specialist, int master, int katedra) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            HashMap<String, String> pair = new HashMap<>();
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{call p_create_specialization(?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("p_title_ua", titleUa);
            statement.setString("p_code_ua", codeUa);
            statement.setString("p_title_en", titleEn);
            statement.setString("p_code_en", codeEn);
            statement.setInt("p_speciality", speciality);
            statement.setInt("p_bachelor", bachelor);
            statement.setInt("p_specialist", specialist);
            statement.setInt("p_master", master);
            statement.setInt("p_katedra", katedra);
            statement.execute();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;    }

    @Override
    public List<HashMap<String, String>> getSpecialization(int id) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_specialization WHERE id = ?";
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
    public List<HashMap<String, String>> getSpecializationList() {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();

        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_specialization");
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
    public List<HashMap<String, String>> updateSpecialization(int id, String titleUa, String codeUa, String titleEn, String codeEn, int speciality, int bachelor, int specialist, int master, int katedra) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{call p_update_specialization(?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setInt("p_id", id);
            statement.setString("p_title_ua", titleUa);
            statement.setString("p_code_ua", codeUa);
            statement.setString("p_title_en", titleEn);
            statement.setString("p_code_en", codeEn);
            statement.setInt("p_speciality", speciality);
            statement.setInt("p_bachelor", bachelor);
            statement.setInt("p_specialist", specialist);
            statement.setInt("p_master", master);
            statement.setInt("p_katedra", katedra);
            statement.execute();
            HashMap<String, String> pair = new HashMap<>();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }

    @Override
    public List<HashMap<String, String>> deleteSpecialization(int id) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{call p_delete_specialization(?,?,?)}");
            statement.setInt("p_id", id);
            statement.execute();

            HashMap<String, String> pair = new HashMap<>();
            pair.put("responseCode", statement.getString("p_response_code"));
            pair.put("responseMessage", statement.getString("p_response_message"));
            list.add(pair);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(conn);
        return list;
    }
}
