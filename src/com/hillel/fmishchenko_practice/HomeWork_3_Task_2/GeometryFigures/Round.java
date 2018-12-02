package com.hillel.fmishchenko_practice.HomeWork_3_Task_2.GeometryFigures;

public class Round implements Figure {
    private int side;
    private int tangle;
    private int perimeter;

    public Round() {
    }

    public Round(int side) {
        this.side = side;
    }

    public int getPerimeter(int side) {
        perimeter = side;
        return perimeter;
    }

    public int getTangle() {
        this.tangle = 360;
        return tangle;
    }


    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public String toString() {
        return "out ->  " + this.getSide() + " side, " + this.getTangle()
                + " tangle, " + this.getPerimeter(side) + " perimeter." + '\n';

    }
}
