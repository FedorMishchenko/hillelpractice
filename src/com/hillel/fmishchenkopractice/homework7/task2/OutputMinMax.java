package com.hillel.fmishchenkopractice.homework7.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class OutputMinMax {
    private static int minLength = 1;
    private static int maxLength = 1;

    private ArrayList<String> min = new ArrayList<>();
    private ArrayList<String> max = new ArrayList<>();

    void wordsMinMax(String text) {
        if (text == null) {
            return;
        }

        String[] substrings = text.split(" ");

        for (String s : substrings) {
            if (s.length() > maxLength) maxLength = s.length();
        }
        for (String s : substrings) {
            if (s.length() == maxLength) max.add(s);
        }
        for (String s : substrings) {
            if (s.length() < minLength) minLength = s.length();
        }
        for (String s : substrings) {
            if (s.length() == minLength) min.add(s);
        }

        print();
    }

    private void print() {
        System.out.println("Min: " + min.toString());
        System.out.print("Max: " + max.toString());
    }
}
