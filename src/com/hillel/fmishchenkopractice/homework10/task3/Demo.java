package com.hillel.fmishchenkopractice.homework10.task3;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        new SyncBuffCopy(
                "E:/example.txt",
                "E:/example2.txt",
                10,3,3);
    }
}
