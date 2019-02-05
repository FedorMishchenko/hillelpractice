package com.hillel.fmishchenkopractice.homework10.task3;

public class DemoTest {

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test).start();
        new Thread(test).start();
    }
}
