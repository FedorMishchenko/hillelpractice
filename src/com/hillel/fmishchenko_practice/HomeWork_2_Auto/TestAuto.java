package com.hillel.fmishchenko_practice.HomeWork_2_Auto;

public class TestAuto {
    public static void main(String[] args) {
        Auto jeep = new Auto4x4("Jeep Cherokee");
        System.out.println(jeep.getMark() + " :" + " have " + jeep.getDrive() + ", " + jeep.getDoors() + " doors," +
                " tank content: " + jeep.getTank());
        Auto hatch = new AutoHatch("Lanos");
        System.out.println(hatch.getMark());
    }
}
