package com.hillel.fmishchenkopractice.homework7task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    List<String> list  = new ArrayList<>();
    String text;
    String path;

    public Reader(){

    }
    public void read(){
        text = "We’re working together" +
                " with the educational community " +
                "to make a difference address challenges" +
                " and further positive change." +
                "We find that we all agree: the" +
                " best part of working in education is " +
                "seeing learners make progress in their lives. " +
                "That’s our inspiration and the inspiration" +
                " behind the products and services, resources and" +
                " ideas that you’ll find here";
        path = "E:/in.txt";

        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error create file");
            }
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            System.out.println("Error in FileWriter");
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(text);
        } catch (IOException e) {
            System.out.println("Error write in file");
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error close bufferedWriter");


        } try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String inputString;
            inputString = buffer.readLine();
            if (inputString == null) {
                System.out.println("File is empty!");
            } else {
                while (inputString != null) {
                    list.add(inputString);
                    inputString = buffer.readLine();
                }
            }
            for (String str: list){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound error");
        } catch (IOException e) {
            System.out.println("Buffer read from file error");
        }


    }
}
