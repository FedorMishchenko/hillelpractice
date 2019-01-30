package com.hillel.fmishchenkopractice.homework7.task5;

/**
 * Transformation decimal to roman
 */
public class Demo {
    public static void main(String[] args) {
        print(545);
        print(1212);
        print(1);
        print(2);
        print(12);
    }

    public static void print(int i) {
        System.out.println(new IntToRoman().convert(i));
    }
}
