package com.hillel.fmishchenkopractice.homework9.task4;

public class Demo {
    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();
        manager.process(new UserService());
    }
}
