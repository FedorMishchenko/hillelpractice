package com.hillel.fmishchenko_practice.homeWork_5_Task_3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ParkingDemo {

    public static void main(String[] args) {
        Parking parking = new Parking();
        Auto reno = new Auto("reno");
        Auto citroen = new Auto("citroen");
        Auto peugeot = new Auto("peugeot");
        parking.put(reno.getKey(),reno);
        parking.put(citroen.getKey(),citroen);
        parking.put(peugeot.getKey(),peugeot);



    }
}
