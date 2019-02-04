package com.hillel.fmishchenkopractice.homework10.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NotSynchronizedCopy {
    private String fileName0 = "E:/example.txt";
    private String fileName1 = "E:/example2.txt";
    private File source = new File(fileName0);
    private File dest = new File(fileName1);

    public void copy(){
        for (int i = 0; i < 3; i++){
            new Thread(() -> {
                try (FileInputStream inputStream = new FileInputStream(source);
                     FileOutputStream outputStream = new FileOutputStream(dest)) {
                    readFile(inputStream);
                    writeFile(outputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    private void readFile(FileInputStream in){

    }
    private void writeFile(FileOutputStream out){

    }

}
