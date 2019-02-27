package com.hillel.fmishchenkopractice.homework12.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

public class AdminQuery implements Query{
    private static final Logger logger = Logger.getLogger(AdminQuery.class.getName());

    public String create(BufferedReader reader) throws IOException {
        System.out.println("Enter item:");
        String item = reader.readLine();
        System.out.println("Enter price:");
        String price = reader.readLine();
        return "INSERT INTO restaurant.menu (item, price)" +
                "VALUES ('" + item + "','" + price + "')";
    }

    public String read() {
        return "SELECT id, item, price FROM restaurant.menu";
    }

    public String update(String id) {
        return "SELECT id, item, price FROM " +
                "restaurant.menu WHERE id = " + id;
    }

    public String delete(String id) {
        return "DELETE FROM restaurant.menu WHERE id = " + id;
    }


}

