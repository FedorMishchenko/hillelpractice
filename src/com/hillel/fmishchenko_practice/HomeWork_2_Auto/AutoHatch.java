package com.hillel.fmishchenko_practice.HomeWork_2_Auto;

public class AutoHatch extends Auto {
    static {
        int doors;
        String drive;
        int tank;
    }
    String mark;

    public AutoHatch() {

        drive = "front wheel drive";
        tank = 45;
        doors = 3;
    }

    public AutoHatch(String mark) {
        this.mark = mark;
        drive = "front wheel drive";
        tank = 45;
        doors = 3;
    }
}
