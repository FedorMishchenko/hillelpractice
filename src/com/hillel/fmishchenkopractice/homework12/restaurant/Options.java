package com.hillel.fmishchenkopractice.homework12.restaurant;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Options {
    private static final Logger logger =
            Logger.getLogger(Options.class.getName());

    public void create(QueryManager manager) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            new MySQLUtil().executeStatement(manager.adminCreateQuery(reader));
            System.out.println("The record successful created");
            new AdminMenu().displayMenu();
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }

    public void read(QueryManager manager) {
        try {
            MySQLUtil util = new MySQLUtil();
            createResultSet(util, manager.adminReadQuery());
        } catch (SQLException e) {
            logger.warning(e.getSQLState().concat(e.getMessage()));
        } finally {
            new AdminMenu().displayMenu();
        }
    }

    public void update(QueryManager manager) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            System.out.println("Enter item id:");
            String id = reader.readLine();
            try {
                createResultSet(new MySQLUtil(), manager.adminUpdateQuery(id));
            } catch (SQLException e) {
                logger.warning(e.getSQLState().concat(e.getMessage()));
            }
            System.out.println("Enter item:");
            String item = reader.readLine();
            System.out.println("Enter price:");
            String price = reader.readLine();
            String stmt = "UPDATE restaurant.menu SET item = '" +
                    item + "' ,price = '" + price + "' WHERE id = " + id;
            new MySQLUtil().executeStatement(stmt);
            System.out.println("The record successful updated");
            new AdminMenu().displayMenu();
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }

    public void delete(QueryManager manager){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter item id to delete:");
            String id = reader.readLine();
            MySQLUtil util = new MySQLUtil();
            try {
                String stmt = "SELECT id, item, price FROM restaurant.menu WHERE id = " + id;
                createResultSet(new MySQLUtil(),stmt);
            }catch (SQLException e){
                logger.warning(e.getSQLState());
            }
            System.out.println("Enter 'y' to confirm delete");
            String confirmDelete = reader.readLine();
            if(confirmDelete.equals("y")){
                util.executeStatement(manager.adminDeleteQuery(id));
                System.out.println("The record has successful deleted");
                new AdminMenu().displayMenu();
            }
        }catch (IOException e){
            logger.warning(e.getMessage());
        }
    }

    private void createResultSet(@NotNull MySQLUtil inner, String stmt) throws SQLException {
        ResultSet resultSet = inner.readRecords(stmt);
        if (resultSet.next()) {
            getTable(resultSet);
        } else {
            logger.info("Database is empty");
        }
        inner.disconnectFromDB();
    }

    private void getTable(@NotNull ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%-15s", metaData.getColumnName(i));
        }
        System.out.println();
        do {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s", resultSet.getObject(i));
            }
            System.out.println();
        } while (resultSet.next());
        System.out.println();
    }
}
