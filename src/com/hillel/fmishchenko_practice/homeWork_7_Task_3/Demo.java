package com.hillel.fmishchenko_practice.homeWork_7_Task_3;

public class Demo {
    public static void main(String[] args) {
        String input = "The ponies run, the girls are young," +
                " The odds are there to beat." +
                " You win a while, and then it’s done" +
                " Your little winning streak";
        String output = "";

        String[] words = input.split(" ");
        for (String s: words) {
            String first = s.substring(0, 1).toUpperCase();
            String all = s.substring(1);
            output += first + all + " ";
        }
        System.out.println(output);

    }
}
