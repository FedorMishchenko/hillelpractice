package com.hillel.fmishchenkopractice.homework4.part1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IosifFlaviy {
    public static void main(String[] args) {
        List<Integer> list = Stream.generate(() -> 1)
                .map(x -> x + 1)
                .limit(10)
                .collect(Collectors.toList());
        int index = 0;
        while (list.size() != 1){
            index = (index + 2) % list.size();
            System.out.println(index);
            list.remove(index);
        }
        System.out.print("Last number: ");
        list.forEach(System.out::println);
    }
}

