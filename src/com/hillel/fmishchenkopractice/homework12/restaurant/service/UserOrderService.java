package com.hillel.fmishchenkopractice.homework12.restaurant.service;

import com.hillel.fmishchenkopractice.homework12.restaurant.dao.Query;
import com.hillel.fmishchenkopractice.homework12.restaurant.db.JdbcConnector;
import com.hillel.fmishchenkopractice.homework12.restaurant.ui.UserMenu;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserOrderService {
    private static final Logger logger =
            Logger.getLogger(UserOrderService.class.getName());
    private Scanner scanner = new Scanner(System.in);

    public void create(Query query) {
        new JdbcConnector().executeStatement(query.create());
        System.out.println("User successful created");
        new UserMenu().displayMenu();
    }

    public void read(Query query) {
        try {
            JdbcConnector connector = new JdbcConnector();
            new Service().createResultSet(connector, query.read());
        } catch (SQLException e) {
            logger.warning(e.getSQLState());
        } finally {
            new UserMenu().displayMenu();
        }
    }
    public void update(Query query) {
        System.out.println("Enter record id:");
        String id = scanner.nextLine();
        String stmt = null;
        try {
            new Service().createResultSet(new JdbcConnector(), query.update(id));
        } catch (SQLException e) {
            logger.warning(e.getSQLState().concat(e.getMessage()));
        }
            System.out.println("Enter item:");
            String item = scanner.nextLine();
            System.out.println("Enter price:");
            String price = scanner.nextLine();
            stmt = "UPDATE restaurant.order SET item = '" +
            item + "' ,price = '" + price + "' WHERE id = " + id;
        new JdbcConnector().executeStatement(stmt);
        System.out.println("The record successful updated");
        new UserMenu().displayMenu();
    }

    public void delete(Query query){
        System.out.println("Enter record id to delete:");
        String stmt;
        String id = scanner.nextLine();
        JdbcConnector connector = new JdbcConnector();

            try {
                stmt = "SELECT id, item, price FROM restaurant.order WHERE id = " + id;
                new Service().createResultSet(new JdbcConnector(),stmt);
            }catch (SQLException e){
                logger.warning(e.getSQLState());
            }

        System.out.println("Enter 'y' to confirm delete");
        String confirmDelete = scanner.nextLine();
        if(confirmDelete.equals("y")){
            connector.executeStatement(query.delete(id));
            System.out.println("The record has successful deleted");
            new UserMenu().displayMenu();
        }
    }
}
