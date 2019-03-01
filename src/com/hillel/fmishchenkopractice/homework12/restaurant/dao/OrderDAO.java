package com.hillel.fmishchenkopractice.homework12.restaurant.dao;

import java.util.Scanner;

public class OrderDAO implements Query {
    private Scanner scanner = new Scanner(System.in);

    private final String SELECT_ORDER_BY_USER_ID = "SELECT id, item, price " +
            "FROM restaurant.order WHERE customer_id = ";
    private final String UPDATE_ORDER_BY_USER_ID = "SELECT id, item, price FROM " +
            "restaurant.order WHERE customer_id = ";
    private final String DELETE_ORDER_BYID = "DELETE FROM restaurant.order WHERE id = ";


    public String create() {
     /*   System.out.println("Enter id");
        String id = scanner.nextLine();*/
        System.out.println("Enter customer id:");
        String customer_id = scanner.nextLine();
        System.out.println("Enter item:");
        String item = scanner.nextLine();
        System.out.println("Enter price:");
        String price = scanner.nextLine();
        return "INSERT INTO restaurant.order (customer_id, item, price)" +
                "VALUES ('" + customer_id + ',' + item + ',' + price + "')";
    }

    public String read() {
        System.out.println("Enter customer_id");
        String id = scanner.nextLine();
        return SELECT_ORDER_BY_USER_ID + id;
    }

    public String update(String id) {
        return UPDATE_ORDER_BY_USER_ID + id;

    }

    public String delete(String id) {
        return DELETE_ORDER_BYID + id;
    }
}
