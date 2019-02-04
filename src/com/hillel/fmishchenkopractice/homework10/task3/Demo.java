package com.hillel.fmishchenkopractice.homework10.task3;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
            /*copy();*/
        new SynchronizedBuffCopy(
                "E:/example.txt",
                "E:/example2.txt",
                10,2,3);
    }
}
