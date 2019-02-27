package com.hillel.fmishchenkopractice.homework12.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

public class QueryManager {
    private static final Logger logger = Logger.getLogger(QueryManager.class.getName());

    String adminCreateQuery(BufferedReader reader) throws IOException {
        System.out.println("Enter item:");
        String item = reader.readLine();
        System.out.println("Enter price:");
        String price = reader.readLine();
        return "INSERT INTO restaurant.menu (item, price)" +
                "VALUES ('" + item + "','" + price + "')";
    }

    String adminReadQuery() {
        return "SELECT id, item, price FROM restaurant.menu";
    }

    String adminUpdateQuery(String id) {
        return "SELECT id, item, price FROM " +
                "restaurant.menu WHERE id = " + id;
    }

    String adminDeleteQuery(String id) {
        return "DELETE FROM restaurant.menu WHERE id = " + id;
    }

    String createOrderQuery() {
        return null;
    }

    String readOrdersQuery(String id) {
        return "SELECT ";
    }
    String updateOrderQuery(){
        return null;
    }
    String deleteOrderQuery(){
        return null;
    }

}

