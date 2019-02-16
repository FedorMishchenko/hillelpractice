package com.hillel.fmishchenkopractice.homework2.car;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        AutoFactory<Car> factory = Car::new;
        Stream.of(
                factory.create(Auto.type.CAR,"GAS","FOUR-WHEEL"),
                factory.create(Auto.type.TRUCK,"DIESEL","REAR-WHEEL")
        )
                .forEach(System.out::println);
    }
}
