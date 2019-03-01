package com.hillel.fmishchenkopractice.homework12.restaurant.service;

import com.hillel.fmishchenkopractice.homework12.restaurant.dao.Query;
import com.hillel.fmishchenkopractice.homework12.restaurant.db.JdbcConnector;
import com.hillel.fmishchenkopractice.homework12.restaurant.ui.AdminMenu;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Service {
    private static final Logger logger =
            Logger.getLogger(Service.class.getName());
    private Scanner scanner = new Scanner(System.in);

    public void create(Query query) {
        new JdbcConnector().executeStatement(query.create());
        System.out.println("The record successful created");
        new AdminMenu().displayMenu();
    }

    public void read(Query query) {
        try {
            JdbcConnector connector = new JdbcConnector();
            createResultSet(connector, query.read());
        } catch (SQLException e) {
            logger.warning(e.getSQLState().concat(e.getMessage()));
        } finally {
            new AdminMenu().displayMenu();
        }
    }

    public void update(Query query) {
        System.out.println("Enter record id:");
        String id = scanner.nextLine();
        String stmt = null;
        try {
            createResultSet(new JdbcConnector(), query.update(id));
        } catch (SQLException e) {
            logger.warning(e.getSQLState().concat(e.getMessage()));
        }
        System.out.println("Enter item:");
        String item = scanner.nextLine();
        System.out.println("Enter price:");
        String price = scanner.nextLine();
        stmt = "UPDATE restaurant.menu SET item = '" +
                item + "' ,price = '" + price + "' WHERE id = " + id;
        new JdbcConnector().executeStatement(stmt);
        System.out.println("The record successful updated");
        new AdminMenu().displayMenu();

    }

    public void delete(Query query) {
        System.out.println("Enter record id to delete:");
        String stmt;
        String id = scanner.nextLine();
        JdbcConnector connector = new JdbcConnector();
        try {
            stmt = "SELECT id, item, price FROM restaurant.menu WHERE id = " + id;
            createResultSet(new JdbcConnector(), stmt);
        } catch (SQLException e) {
            logger.warning(e.getSQLState());
        }
        System.out.println("Enter 'y' to confirm delete");
        String confirmDelete = scanner.nextLine();
        if (confirmDelete.equals("y")) {
            connector.executeStatement(query.delete(id));
            System.out.println("The record has successful deleted");
            new AdminMenu().displayMenu();
        }
    }

    void createResultSet(@NotNull JdbcConnector connector, String stmt) throws SQLException {
        ResultSet resultSet = connector.readRecords(stmt);
        if (resultSet.next()) {
            printTable(resultSet);
        } else {
            logger.info("Database is empty");
        }
        connector.disconnectFromDB();
    }

    private void printTable(@NotNull ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%-15s%15s", metaData.getColumnName(i), "   |   ");
        }
        System.out.println();
        System.out.println("---------------------------------------"
                + "------------------------------------------------");
        do {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s%15s", resultSet.getObject(i), "   |   ");
            }
            System.out.println();
        } while (resultSet.next());
        System.out.println();
    }
}
