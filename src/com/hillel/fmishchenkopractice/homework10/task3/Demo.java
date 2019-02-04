package com.hillel.fmishchenkopractice.homework10.task3;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
            copy();
    }

    private static void copy() throws InterruptedException {
        for(int i = 0; i < 3; i++) {
            System.out.println(new SynchronizedBuffCopy
                           ("E:/example.txt",
                            "E:/example2.txt",
                            10)
                            .copy()
                            .join()
                            .getTotalBytes());
        }
    }
}
