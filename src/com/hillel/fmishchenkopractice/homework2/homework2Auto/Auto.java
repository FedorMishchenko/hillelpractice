package com.hillel.fmishchenkopractice.homework2.homework2Auto;

public abstract class Auto {
    int doors;
    String color;
    int tank;
    String model;

    public abstract String getColor();

    public abstract void setColor(String color);

    public abstract int getDoors();

    public abstract void setDoors(int doors);

    public abstract int getTank();

    public abstract void setTank(int tank);

    public abstract String getModel();

    public abstract void setModel(String model);
}
