package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dimitry on 9/19/17.
 */
public class ConnectionDB {
    private final String SCHEMA_NAME = "univercity42test";
    private final String HOST = "31.42.165.48";
    private final String USERNAME = "univer";
    private final String PASSWORD = "universe";
    private final String URL = "jdbc:mysql://" + HOST + ":3306/" + SCHEMA_NAME + "?characterEncoding=utf8&amp;useSSL=false&amp;useUnicode=yes";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println(" --Connection to DB is active...");
            } else {
                System.err.println(" --Cannot get DB access...");
                System.err.println(" --Connection to DB is not active...");
            }
        } catch (SQLException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public String getSCHEMA_NAME() {
        return SCHEMA_NAME;
    }

    public void stopConnection(Connection connection) {
        try {
            connection.close();
            if (connection.isClosed()) {
                System.out.println(" --Connection to DB is disabled...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
