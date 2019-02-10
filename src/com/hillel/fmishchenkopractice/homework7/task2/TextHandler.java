package com.hillel.fmishchenkopractice.homework7.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextHandler {

    List<String> list = new ArrayList<>();
    private String path;
    private File file = new File(path);
    String text =
            "We’re working together " +
            "with the educational community " +
            "to make a difference address challenges " +
            "and further positive change." +
            "We find that we all agree: the " +
            "best part of working in education is " +
            "seeing learners make progress in their lives. " +
            "That’s our inspiration and the inspiration " +
            "behind the products and services, resources and " +
            "ideas that you’ll find here";

    public TextHandler() {
        path = "E:/in.txt";
    }

    public void process() throws IOException {
        createFile();
        writeDataInFile();
        dataOutputFromFile();
    }

    private void dataOutputFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String inputString;
            inputString = reader.readLine();
            if (inputString == null) {
                print("File is empty!");
            } else {
                while (inputString != null) {
                    list.add(inputString);
                    inputString = reader.readLine();
                }
            }
            for (String str : list) {
                print(str);
            }

        } catch (FileNotFoundException e) {
            print("FileNotFound error");
        } catch (IOException e) {
            print("Buffer read from file error");
        }
    }

    private void print(String s) {
        System.out.println(s);
    }

    private void writeDataInFile() throws IOException {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            throw new IOException("Error in FileWriter " + e);
        }
        BufferedWriter writer = new BufferedWriter(fileWriter);
        try {
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new IOException("Error write in file " + e);
        }
    }

    private void createFile() throws IOException {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new IOException("Error create file " + file.getName()
                        + " " + file.getPath());
            }
        }
    }
}
