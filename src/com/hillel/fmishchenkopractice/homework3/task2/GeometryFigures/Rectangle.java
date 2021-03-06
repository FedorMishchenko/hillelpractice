package com.hillel.fmishchenkopractice.homework3.task2.GeometryFigures;

public class Rectangle implements Figure {
    private int side;

    Rectangle(int side) {
        this.side = side;
    }

    public int getPerimeter(int side) {
        return side * 4;
    }

    public int getTangle() {
        return 360 / 4;
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
