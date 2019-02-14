package com.hillel.fmishchenkopractice.homework2.auto;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        AutoFactory<Auto> factory = Auto::new;
        Stream.of(
                factory.create("Audi", "sedan",
                "silver", 2010, 15_000),
                factory.create("BMW", "sedan",
                "black", 1998, 2_000),
                factory.create("Lada", "hatchback",
                        "white", 2015, 500))
                .forEach(System.out::println);

    }
}
