package com.hillel.fmishchenkopractice.homework12.restaurant.dao;

import java.util.Scanner;

public class UsreDAO implements Query{
    private final String CREATE_USER =
            "INSERT INTO restaurant.customer (email) VALUES ";
    private final String SELECT_USERS =
            "SELECT id, email FROM restaurant.customer";
    private final String UPDATE_USER_BYID =
            "";
    private final String DELETE_USER =
            "";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String create() {
        System.out.println("Enter email");
        String email = scanner.nextLine();
        return CREATE_USER + "('" + email + "')";
    }

    @Override
    public String read() {
        return SELECT_USERS;
    }

    @Override
    public String update(String id) {
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }
}
