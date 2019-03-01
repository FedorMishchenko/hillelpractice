package com.hillel.fmishchenkopractice.homework12.restaurant.dao;

import java.util.Scanner;

public class OrderDAO implements Query {
    private final String SELECT_ALL_USER_ORDERS =
            "SELECT id, item, price FROM restaurant.order WHERE customer_id = ";
    private final String CREATE_ORDER =
            "INSERT INTO restaurant.order (item, price, customer_id) VALUES ";
    private final String UPDATE_ORDER_BYID = "SELECT id, item, price " +
            "FROM restaurant.order WHERE customer_id = ";
    private final String DELETE_ORDER_BYID =
            "DELETE FROM restaurant.order WHERE customer_id = ";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String create(){
        System.out.println("Enter item");
        String item = scanner.nextLine();
        System.out.println("Enter price");
        String price = scanner.nextLine();
        System.out.println("Enter user_id");
        String id = scanner.nextLine();
        return CREATE_ORDER + "('" + item + "','" +
                price + "','" + id + "')";
    }

    @Override
    public String read() {
        System.out.println("Enter user_id");
        String id = scanner.nextLine();
        return SELECT_ALL_USER_ORDERS + id;
    }

    @Override
    public String update(String id) {
        return UPDATE_ORDER_BYID;
    }

    @Override
    public String delete(String id) {
        System.out.println("Enter user_id");
        String user_id = scanner.nextLine();
        return DELETE_ORDER_BYID + user_id ;
    }
}
