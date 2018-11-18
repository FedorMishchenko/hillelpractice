package com.hillel.fmishchenko_practice.HomeWork_2_Auto;

public class AutoSedan extends Auto {
    static {
        int doors = 4;
        String drive = "rear wheel drive";
        int tank = 60;
    }
     String mark;

    public AutoSedan(){

    }
    public AutoSedan(String mark){
        this.mark = mark;
    }

}
