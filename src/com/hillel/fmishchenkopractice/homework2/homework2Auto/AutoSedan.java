package com.hillel.fmishchenkopractice.homework2.homework2Auto;

public class AutoSedan extends Auto {
    private String model;

    public AutoSedan(String model) {
        this.model = model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getDoors() {
        return doors;
    }

    @Override
    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public int getTank() {
        return tank;
    }

    @Override
    public void setTank(int tank) {
        this.tank = tank;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return this.model;
    }
}














