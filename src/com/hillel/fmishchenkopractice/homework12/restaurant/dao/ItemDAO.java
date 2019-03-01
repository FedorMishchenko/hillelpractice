package com.hillel.fmishchenkopractice.homework12.restaurant.dao;

import java.util.Scanner;

public class ItemDAO implements Query {
    private final String SELECT_ALL_ITEMS_FROM_MENU =
            "SELECT id, item, price FROM restaurant.menu";
    private final String UPDATE_ITEM_BYID_IN_MENU = "SELECT id, item, price FROM " +
            "restaurant.menu WHERE id = ";
    private final String DELETE_ITEM_BYID = "DELETE FROM restaurant.menu WHERE id = ";




    public String create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item:");
        String item = scanner.nextLine();
        System.out.println("Enter price:");
        String price = scanner.nextLine();
        return "INSERT INTO restaurant.menu (item, price)" +
                "VALUES ('" + item + "','" + price + "')";
    }

    public String read() {
        return SELECT_ALL_ITEMS_FROM_MENU;
    }

    public String update(String id) {
        return UPDATE_ITEM_BYID_IN_MENU + id;
    }

    public String delete(String id) {
        return DELETE_ITEM_BYID + id;
    }


}

