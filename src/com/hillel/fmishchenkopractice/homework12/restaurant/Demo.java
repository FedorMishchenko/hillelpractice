package com.hillel.fmishchenkopractice.homework12.restaurant;

import java.sql.*;
import java.util.logging.Logger;

public class Demo {
    private static final Logger log = Logger.getLogger(Demo.class.getName());
    private static Connection connection;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static void main(String[] args) {


        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String serverName = "localhost";
            String dataBaseName = "restaurant";
            String url = "jdbc:mysql://" + serverName + "/" + dataBaseName;
            String username = "root";
            String password = "password";
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection: " + connection);

/*            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in))){
                log.info("Enter item:");
                String item = reader.readLine();
                log.info("Enter price");
                String price = reader.readLine();
                String stmt = "INSERT INTO restaurant.menu (item, price)" +
                        "VALUES ('"  + item + "','" + price + "')";
                statement = connection.createStatement();
                statement.executeUpdate(stmt);
            }catch (IOException | SQLException e){
                log.warning(e.toString());
            }*/

            String query = "Select * FROM restaurant.menu";
            Statement stm = connection.createStatement();
            try (ResultSet res = stm.executeQuery(query)) {
                String id;
                String item;
                String price;
                while (res.next()){
                    item = res.getString(2);
                    System.out.printf("%-10s",item);
                }
                connection.close();
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
