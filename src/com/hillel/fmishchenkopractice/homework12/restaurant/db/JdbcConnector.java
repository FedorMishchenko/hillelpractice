package com.hillel.fmishchenkopractice.homework12.restaurant.db;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class JdbcConnector {
    private static final Logger logger = Logger.getLogger(JdbcConnector.class.getName());
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public JdbcConnector() {
        try {
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "password";
        Class.forName(driver);
        String serverName = "localhost";
        String dataBaseName = "restaurant";
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        String url = "jdbc:mysql://" + serverName + "/" + dataBaseName;
            connection = DriverManager.getConnection(url,properties );
        } catch (SQLException | ClassNotFoundException e) {
            logger.warning(e.getMessage());
        }
    }

    public void disconnectFromDB() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    public ResultSet readRecords(String stmt) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(stmt);
            return resultSet;
        }
        catch (SQLException e) {
            logger.warning(e.getSQLState().concat(e.getMessage()));
        }
        return resultSet;
    }

    public void executeStatement(String stmt) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(stmt);
        }
        catch (SQLException e) {
            logger.warning(e.getSQLState().concat(e.getMessage()));
        }
    }
}
