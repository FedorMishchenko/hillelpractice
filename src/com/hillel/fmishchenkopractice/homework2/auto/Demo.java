package com.hillel.fmishchenkopractice.homework2.auto;


import java.util.stream.Stream;

@SuppressWarnings("ALL")
public class Demo {
    public static void main(String[] args) {

        Auto truck = new Truck("DIESEL", "REAR-WHEEL");
        ((Truck) truck).setLoadCapacity(10);
        truck.setMaxSpeed(120);

        Auto bus = new Bus("GAS", "REAR-WHEEL");
        ((Bus) bus).setPassengerSeats(56);
        bus.setColor("yellow");

        Auto sedan = new Sedan("GAS","FRONT-WHEEL");
        ((Sedan) sedan).setEngineCapacity(3.2);

        Stream.of(truck,bus,sedan).forEach(System.out::println);
        ((Truck) truck).load();
        ((Bus) bus).route();
        ((Sedan) sedan).fuelConsumption();

    }

}
