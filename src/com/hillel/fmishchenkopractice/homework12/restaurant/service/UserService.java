package com.hillel.fmishchenkopractice.homework12.restaurant.service;

import com.hillel.fmishchenkopractice.homework12.restaurant.dao.Query;
import com.hillel.fmishchenkopractice.homework12.restaurant.db.JdbcConnector;
import com.hillel.fmishchenkopractice.homework12.restaurant.ui.Accounts;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserService {
    private static final Logger logger =
            Logger.getAnonymousLogger();
    private Scanner scanner = new Scanner(System.in);

    public void create(Query query) {
        new JdbcConnector().executeStatement(query.create());
        System.out.println("User successful created");
        new Accounts().displayMenu();
    }

    public void read(Query query) {
        try {
            JdbcConnector connector = new JdbcConnector();
            new Service().createResultSet(connector, query.read());
        } catch (SQLException e) {
            logger.warning(e.getSQLState());
        } finally {
            new Accounts().displayMenu();
        }
    }

    public void update(Query query){
        System.out.println("Enter user id");
        String user_id = scanner.nextLine();
        String stmt = null;
        try {
            new Service().createResultSet(new JdbcConnector(), query.update(user_id));
        }catch (SQLException e){
            logger.warning(e.getSQLState());
        }
        System.out.println("Enter email");
        String email = scanner.nextLine();
        stmt = "UPDATE restaurant.customer SET email = " + email;
        new JdbcConnector().executeStatement(stmt);
        System.out.println("User successful updated");
        new Accounts().displayMenu();
    }

    public void delete(Query query) {
        System.out.println("Enter user id to delete");
        String stmt;
        String user_id = scanner.nextLine();
        JdbcConnector connector = new JdbcConnector();
        try {
            stmt = "SELECT id, email FROM restaurant.customer WHERE id = " + user_id;
            new Service().createResultSet(new JdbcConnector(), stmt);
        } catch (SQLException e) {
            logger.warning(e.getSQLState());
        }
        System.out.println("Enter 'y' to confirm delete");
        String confirmDelete = scanner.nextLine();
        if (confirmDelete.equals("y")) {
            connector.executeStatement(query.delete(user_id));
            System.out.println("The record has successful deleted");
            new Accounts().displayMenu();
        }
    }
}
