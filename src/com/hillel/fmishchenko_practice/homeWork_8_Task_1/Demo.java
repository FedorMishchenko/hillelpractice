package com.hillel.fmishchenko_practice.homeWork_8_Task_1;

public class Demo {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.put("Привет","Hello");
        System.out.println(dictionary.toString("Привет"));
        dictionary.put("Пока","Bye");
        System.out.println(dictionary.toString("Пока"));
        System.out.println(dictionary.getEn("Пока"));
        System.out.println(dictionary.getRu("Hello"));
        System.out.println("Dictionary size: " + dictionary.size());
        dictionary.remove("Привет");
        System.out.println(dictionary.toString("Привет"));
        System.out.println("Dictionary size: " + dictionary.size());
    }
}
