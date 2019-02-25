package com.hillel.fmishchenkopractice.homework5.crud;

import com.hillel.fmishchenkopractice.homework5.task4.UserMenu;

public class Demo {
    private DatabaseManager manager;
    Demo(DatabaseManager manager){
        this.manager = manager;
    }
    public static void main(String[] args) {
        new Demo(new Menu()).manager.displayMenu();
    }
}
