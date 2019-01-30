package com.hillel.fmishchenkopractice.homework7.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextHandler {

    List<String> list = new ArrayList<>();
    String path = "E:/in.txt";
    BufferedReader reader;
    BufferedWriter writer;
    File file = new File(path);
    FileWriter fileWriter;
    String text = "We’re working together" +
            " with the educational community " +
            "to make a difference address challenges" +
            " and further positive change." +
            "We find that we all agree: the" +
            " best part of working in education is " +
            "seeing learners make progress in their lives. " +
            "That’s our inspiration and the inspiration" +
            " behind the products and services, resources and" +
            " ideas that you’ll find here";

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
                System.out.println("File is empty!");
            } else {
                while (inputString != null) {
                    list.add(inputString);
                    inputString = reader.readLine();
                }
            }
            for (String str : list) {
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound error");
        } catch (IOException e) {
            System.out.println("Buffer read from file error");
        }
    }

    private void writeDataInFile() throws IOException {
        try {
            fileWriter = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            throw new IOException("Error in FileWriter " + e);
        }
        writer = new BufferedWriter(fileWriter);
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
