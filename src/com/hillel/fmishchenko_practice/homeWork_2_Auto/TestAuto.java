package com.hillel.fmishchenko_practice.homeWork_2_Auto;

public class TestAuto {
    public static void main(String[] args) {

        Auto hatch = new AutoHatch();
        hatch.setMark("Audi");
        hatch.setColor("silver");
        System.out.println("Mark auto: " + hatch.getMark() + ", color: " + hatch.getColor());
    }
}
