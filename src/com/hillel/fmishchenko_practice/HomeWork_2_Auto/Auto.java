package com.hillel.fmishchenko_practice.HomeWork_2_Auto;

public abstract class Auto {
    int doors;
    String color;
    int tank;
    String mark;

    public abstract String getColor();

    public abstract void setColor(String color);

    public abstract int getDoors();

    public abstract void setDoors(int doors);

    public abstract int getTank();

    public abstract void setTank(int tank);

    public abstract String getMark();

    public abstract void setMark(String mark);

}
