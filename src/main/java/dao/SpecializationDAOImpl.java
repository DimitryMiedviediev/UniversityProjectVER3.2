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
            CallableStatement statement = conn.prepareCall("{CALL P_CREATE_SPECIALIZATION(?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("vTITLE_UA", titleUa);
            statement.setString("vCODE_UA", codeUa);
            statement.setString("vTITLE_EN", titleEn);
            statement.setString("vCODE_EN", codeEn);
            statement.setInt("vSPECIALITY", speciality);
            statement.setInt("vBACHELOR", bachelor);
            statement.setInt("vSPECIALIST", specialist);
            statement.setInt("vMASTER", master);
            statement.setInt("vKATEDRA", katedra);
            statement.execute();
            pair.put("responseCode", statement.getString("vRESPONSE_CODE"));
            pair.put("responseMessage", statement.getString("vRESPONSE_MESSAGE"));
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
            CallableStatement statement = conn.prepareCall("{CALL P_UPDATE_SPECIALIZATION(?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setInt("vID", id);
            statement.setString("vTITLE_UA", titleUa);
            statement.setString("vCODE_UA", codeUa);
            statement.setString("vTITLE_EN", titleEn);
            statement.setString("vCODE_EN", codeEn);
            statement.setInt("vSPECIALITY", speciality);
            statement.setInt("vBACHELOR", bachelor);
            statement.setInt("vSPECIALIST", specialist);
            statement.setInt("vMASTER", master);
            statement.setInt("vKATEDRA", katedra);
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

    @Override
    public List<HashMap<String, String>> deleteSpecialization(int id) {
        List<HashMap<String, String>> list = new ArrayList<>();
        Connection conn = connectionDB.getConnection();
        try {
            conn.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = conn.prepareCall("{CALL P_DELETE_SPECIALIZATION(?,?,?)}");
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
