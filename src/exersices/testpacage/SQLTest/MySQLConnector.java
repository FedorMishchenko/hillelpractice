package exersices.testpacage.SQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {
    public static void main(String[] args) {
    /*    Connection connection;
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String serverName = "localhost";
            String dataBaseName = "users";
            String url = "jdbc:mysql://" + serverName + "/" + dataBaseName;
            String username = "root";
            String password = "password";
            connection = DriverManager.getConnection(url,username,password);
            check(connection);
            String query = "Select * FROM users.user";
            Statement stm = connection.createStatement();
            try (ResultSet res = stm.executeQuery(query)) {
                String items;
                while (res.next()){
                    items = res.getString(2);
                    print(items);
                }
                connection.close();
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void check(Connection connection) {
        print("Connection: " + connection);
    }
}
