package com.hillel.fmishchenko_practice.HomeWork_2_Auto;

public class Auto4x4 extends Auto {

    String mark;
    static {
        doors = 5;
        drive = "four-wheel drive";
        tank = 90;
    }

    public Auto4x4() {

    }

    public Auto4x4(String mark) {
        this.mark = mark;
    }

}
