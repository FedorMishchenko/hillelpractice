package com.hillel.fmishchenkopractice.homework2.candy;

import java.util.stream.Stream;

import static com.hillel.fmishchenkopractice.homework2.candy.Candy.*;

public class Demo {
    public static void main(String[] args) {
        Stream.of(
                new Builder().name("avk").color("black").sugar(true).price(43.22f).build(),
                new Builder().name("roshen").color("black").sugar(true).price(22.08f).build(),
                new Builder().name("milka").color("black").sugar(true).price(32.08f).build(),
                new Builder().name("milka").color("black").sugar(true).price(32.08f).build())
                .distinct()
                .sorted(new CandyComparator())
                .forEach(x -> System.out.println(x.toString()));

    }
    private static class CandyComparator implements java.util.Comparator<Candy> {
        @Override
        public int compare(Candy o1, Candy o2) {
            if (o1.getPrice() == o2.getPrice()) {
                return 0;
            } else if (o1.getPrice() > o2.getPrice()) {
                return 1;
            }
            return -1;
        }
    }
}
