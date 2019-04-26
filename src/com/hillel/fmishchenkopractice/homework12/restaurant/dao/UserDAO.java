package com.hillel.fmishchenkopractice.homework12.restaurant.dao;

import java.util.Scanner;

public class UserDAO implements Query{
    private final String CREATE_USER =
            "INSERT INTO restaurant.customer (email) VALUES ";
    private final String SELECT_USERS =
            "SELECT id, email FROM restaurant.customer";
    private final String UPDATE_USER_BYID =
            "SELECT id, email FROM restaurant.customer WHERE id = ";
    private final String DELETE_USER =
            "DELETE FROM restaurant.customer WHERE id = ";
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
        return UPDATE_USER_BYID + id;
    }

    @Override
    public String delete(String id) {
        return DELETE_USER + id ;
    }
}
