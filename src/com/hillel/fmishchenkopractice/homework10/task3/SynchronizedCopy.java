package com.hillel.fmishchenkopractice.homework10.task3;

import java.io.*;

public class SynchronizedCopy {
    private String fileName0 = "E:/example.txt";
    private String fileName1 = "E:/example2.txt";
    private File source = new File(fileName0);
    private File dest = new File(fileName1);
    private byte[] buff = new byte[8192];

    public void copy() {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try (FileInputStream reader = new FileInputStream(source);
                     FileOutputStream writer = new FileOutputStream(dest)) {
                    try {
                        readContent(reader);
                        writeContent(writer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private synchronized void readContent(FileInputStream in) throws InterruptedException {
        try {
            print("Reader in ");
            in.read(buff);
            print("Reader out ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(String s) {
        System.out.println(s + Thread.currentThread().getName());
    }

    private synchronized void writeContent(FileOutputStream out) throws InterruptedException {
        try {
            print("Writer in ");
            out.write(buff);
            print("Writer out ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
