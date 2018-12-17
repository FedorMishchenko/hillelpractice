package com.hillel.fmishchenko_practice.homeWork_5_Task_3;

public class Auto {
    private String model;
    private int key;

    public String getModel() {
        return model;
    }

    public int getKey() {
        key = this.hashCode();
        return key;
    }


    public Auto(String model) {
        this.model = model;
    }

}
