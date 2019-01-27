package com.hillel.fmishchenkopractice.homework9.task4;

public class TransactionManagerDemo {
    public void start() {
        TransactionManager manager = new TransactionManager();
        manager.process(new UserService());
    }
}
