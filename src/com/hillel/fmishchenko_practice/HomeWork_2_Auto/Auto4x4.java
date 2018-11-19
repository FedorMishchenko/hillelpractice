package com.hillel.fmishchenko_practice.HomeWork_2_Auto;

public class Auto4x4 extends Auto {


    public Auto4x4() {
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
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }

}
