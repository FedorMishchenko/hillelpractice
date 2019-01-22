package com.hillel.fmishchenkopractice.homework3.task2.GeometryFigures;

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

    @Override
    public boolean equals(Figure f) {
        if(this.getPerimeter(this.getSide()) == f.getSide())return true;
        return false;
    }

    @Override
    public int hashcode() {
        return this.hashcode();
    }
}
