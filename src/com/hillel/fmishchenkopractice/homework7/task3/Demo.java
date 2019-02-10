package com.hillel.fmishchenkopractice.homework7.task3;

/**
 * revers input
 */
public class Demo {
    public static void main(String[] args) {
        String input =
                "The ponies run, the girls are young, " +
                "The odds are there to beat. " +
                "You win a while, and then it’s done " +
                "Your little winning streak";
        StringBuilder output = new StringBuilder();

        String[] words = input.split(" ");
        for (String s: words) {
            String first = s.substring(0, 1).toUpperCase();
            String all = s.substring(1);
            output.append(first).append(all).append(" ");
        }
        System.out.println(output);

    }
}
