package com.hillel.fmishchenkopractice.homework7task2;

import java.util.ArrayList;

public class OutputMinMax {
    public OutputMinMax() {

    }
    ArrayList<String> min = new ArrayList<>();
    ArrayList<String> max = new ArrayList<>();
    public void wordsMinMax(String text) {
        if (text == null) {
            return;
        }
        int minLength = 1;
        int maxLength = 1;

        String[] substrings = text.split(" ");

        for(String s : substrings) {
            if(s.length() > maxLength) maxLength = s.length();
        }
        for(String s: substrings) {
            if(s.length() == maxLength) max.add(s);
        }
        for(String s : substrings) {
            if(s.length() < minLength) minLength = s.length();
        }
        for(String s: substrings) {
            if(s.length() == minLength) min.add(s);
        }

        System.out.println("Min: " + min.toString());
        System.out.print("Max: " + max.toString());
    }
}
