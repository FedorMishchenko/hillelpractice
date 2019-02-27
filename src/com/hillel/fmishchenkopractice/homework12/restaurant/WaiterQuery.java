package com.hillel.fmishchenkopractice.homework12.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class WaiterQuery implements Query {
    public String create(BufferedReader reader) throws IOException {
        System.out.println("Enter id");
        String id = reader.readLine();
        System.out.println("Enter customer id:");
        String customer_id = reader.readLine();
        System.out.println("Enter item:");
        String item = reader.readLine();
        System.out.println("Enter price:");
        String price = reader.readLine();
        return "INSERT INTO restaurant.order (customer_id, item, price)" +
                "VALUES ('" + customer_id + ',' + item + ',' + price + "')";
    }

    public String read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer_id");
        String id = scanner.nextLine();
        return "SELECT id, item, price " +
                "FROM restaurant.order WHERE customer_id = " + id;
    }

    public String update(String id) {
        return "SELECT id, item, price FROM " +
                "restaurant.order WHERE customer_id = " + id;

    }

    public String delete(String id) {
        return "DELETE FROM restaurant.order WHERE id = " + id;
    }
}
