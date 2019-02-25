
package com.hillel.fmishchenkopractice.homework5.crud;

import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MySQLProcessor implements Processor {
    private static final Logger log = Logger.getLogger(MySQLProcessor.class.getName());
    private Connection connection;
    private Statement statement = null;
    private ResultSet resultSet = null;

    MySQLProcessor() {
        String serverName = "localhost";
        String password = "password";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", password);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        try {
            String dataBaseName = "users";
            String url = "jdbc:mysql://" + serverName + "/" + dataBaseName;
            connection = DriverManager
                    .getConnection(url, properties);
        } catch (SQLException e) {
            log.info(e.getSQLState());
        }
    }
    public void create(String name,String email,Integer age){
        MySQLProcessor processor = new MySQLProcessor();
        String stmt = "INSERT INTO user (name,email,age) " +
                "VALUES ('" + name + "','" + email + "','" + age + "')";
        processor.executeStatement(stmt);
    }
    public void read() {
        try {
            MySQLProcessor processor = new MySQLProcessor();
            String stmt = "SELECT id, name, email, age FROM user";
            ResultSet resultSet = processor.readRecords(stmt);
            if (resultSet.next()) {
                int columnCount = printRecords(resultSet);
                do {
                    for (int i = 1; i <= columnCount; i++) {
                        printf(resultSet.getObject(i));
                    }
                    print();
                } while (resultSet.next());

            } else {
                log.warning("No data base records found");
            }
            processor.disconnectFromDB();
        } catch (SQLException e) {
            log.info(e.getSQLState());
        }
    }

    public void update(@NotNull BufferedReader reader, String id) throws IOException {
        updateRecord(id);
        print();
        print("Enter new name:");
        String name = reader.readLine();
        print("Enter new email:");
        String email = reader.readLine();
        print("Enter new age");
        String age = reader.readLine();
        MySQLProcessor processor = new MySQLProcessor();
        String stmt = "UPDATE user SET name = '" +
                name + "',email = '" + email + "',age = '" +
                age + "' WHERE id = " + id;
        processor.executeStatement(stmt);
    }
    private void updateRecord(String id) {
        try {
            MySQLProcessor processor = new MySQLProcessor();
            String stmt = "SELECT id, name, email, age FROM user WHERE id = " + id;
            ResultSet resultSet = processor.readRecords(stmt);
            if(resultSet.next()){
                int columnCount = printRecords(resultSet);
                do {
                    for (int i = 1; i <= columnCount; i++) {
                        printf(resultSet.getObject(i));
                    }
                } while (resultSet.next());
            }else {
                log.warning("No data base records found");
            }
            processor.disconnectFromDB();
        }catch (SQLException e){
            log.info(e.getSQLState());
        }
    }
    public void delete(@NotNull BufferedReader reader, String id) throws IOException {
        deleteRecord(id);
        print();
        print("Enter 'y' to confirm deletion: ");
        String confirm_delete = reader.readLine();

        if ("y".equals(confirm_delete)) {
            MySQLProcessor processor = new MySQLProcessor();
            String stmt = "DELETE FROM user WHERE id = " + id;
            processor.executeStatement(stmt);
            print("Record successful delete");
        }
    }

    private void deleteRecord(String id) {
        try {
            MySQLProcessor processor = new MySQLProcessor();
            String stmt = "SELECT id, name, email, age FROM user WHERE id = " + id;
            ResultSet resultSet = processor.readRecords(stmt);
            if (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                print("Records:");
                for (int i = 1; i <= columnCount; i++) {
                    printf(metaData.getColumnName(i));
                }
                print();
                do {
                    for (int i = 1; i <= columnCount; i++) {
                        printf(resultSet.getObject(i));
                    }
                } while (resultSet.next());
            } else {
                log.warning("No data base records found.");
            }
            processor.disconnectFromDB();
        } catch (SQLException e) {
            log.info(e.getSQLState());
        }
    }

    private int printRecords(@NotNull ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        print("Records:");
        for (int i = 1; i <= columnCount; i++) {
            printf(metaData, i);
        }
        print();
        return columnCount;
    }

    private ResultSet readRecords(String stmt) {
        try {
            statement = connection.createStatement();
            return statement.executeQuery(stmt);
        } catch (SQLException e) {
            log.info(e.getSQLState());
        }
        return resultSet;
    }

     private void executeStatement(String stmt){
        try {
            statement = connection.createStatement();
            statement.executeUpdate(stmt);
        }catch (SQLException e){
            log.info(e.getSQLState());
        }
    }

     private void disconnectFromDB() {
        try {
            connection.close();
        } catch (SQLException e) {
            log.info(e.getSQLState());
        }
    }
    private void printf(Object object) {
        System.out.printf("%-15s", object);
    }
    private void printf(@NotNull ResultSetMetaData metaData, int i) throws SQLException {
        printf(metaData.getColumnName(i));
    }
    private void print(String s) {
        System.out.println(s);
    }
    public void print() {
        print("");
    }
}
