package com.hillel.fmishchenkopractice.homework12.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaiterQuery implements Query{
    public String create(BufferedReader reader) throws IOException {
        System.out.println("Enter customer id:");
        String customer_id = reader.readLine();
        System.out.println("Enter item:");
        String item = reader.readLine();
        System.out.println("Enter price:");
        String price = reader.readLine();
        return "INSERT INTO restaurant.order (customer_id, item, price)" +
                "VALUES ('" + customer_id + item + ',' + price + "')";
    }

    public String read() {
        String id = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter customer_id");
            id = reader.readLine();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return "SELECT id, item, price " +
                "FROM restaurant.order WHERE customer_id = " + id;
    }
    public String update(String id){
        return "SELECT id, item, price FROM " +
                "restaurant.order WHERE customer_id = " + id;

    }

    public String delete(String id){
        return "DELETE FROM restaurant.order WHERE customer_id = " + id;
    }
}
