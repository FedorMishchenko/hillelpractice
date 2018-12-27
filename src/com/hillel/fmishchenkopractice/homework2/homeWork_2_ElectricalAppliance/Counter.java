package com.hillel.fmishchenkopractice.homework2.homeWork_2_ElectricalAppliance;

public class Counter {
    public static final int MAXPOWER = 10;

    public static void off(ElectricalAppliance appliance){
        if(appliance.getPower() > MAXPOWER){
            System.out.println("Switch off " + appliance.getName());
        }
    }

}
