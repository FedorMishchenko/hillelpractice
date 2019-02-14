package com.hillel.fmishchenkopractice.homework2.candy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        List<Candy> list = new ArrayList<>();
        List<Candy> check;
        CandyFactory factory = Candy::new;
        list.add((Candy) factory.create("Avk","black",true,70));
        list.add((Candy) factory.create("Roshen","white",false,35));
        list.add((Candy) factory.create("Svitoch","black",true,60));
        list.forEach(System.out::println);
        Function<List<Candy>,List<Candy>> checkPrice = CandyUtils::checkForCandy;
        check = checkPrice.apply(list);
        check.forEach(System.out::println);
    }
}
