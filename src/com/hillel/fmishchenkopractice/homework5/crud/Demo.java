package com.hillel.fmishchenkopractice.homework5.crud;

import com.hillel.fmishchenkopractice.homework5.crud.interfaces.DatabaseManager;
import com.hillel.fmishchenkopractice.homework5.crud.sql.Menu;

public class Demo {
    private DatabaseManager manager;

    private Demo(DatabaseManager manager) {
        this.manager = manager;
    }

    public static void main(String[] args) {
        new Demo(new Menu()).manager.displayMenu();
    }
}
