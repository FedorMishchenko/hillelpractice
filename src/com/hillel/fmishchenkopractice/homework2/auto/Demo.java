package com.hillel.fmishchenkopractice.homework2.auto;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        AutoFactory<Auto> factory = Auto::new;
        Auto audi = factory.create("Audi", "sedan",
                "silver", 2010, 15_000);
        Auto bmw = factory.create("BMW", "sedan",
                "black", 1998, 2_000);
        Auto lada = factory.create("Lada", "hatchback",
                "white", 2015, 500);
        AutoUtils.market = Arrays.asList(audi,bmw,lada);
        AutoUtils.market.forEach(System.out::println);

    }
}
