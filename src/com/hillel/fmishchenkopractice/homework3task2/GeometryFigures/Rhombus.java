package com.hillel.fmishchenkopractice.homework3task2.GeometryFigures;

public class Rhombus implements Figure {
    private int side;
    private int tangle;
    private int perimeter;

    public Rhombus() {
    }

    public Rhombus(int side) {
        this.side = side;
    }

    public int getPerimeter(int side) {
        perimeter = side * 4;
        return perimeter;
    }

    public int getTangle() {
        this.tangle = 360 / 4;
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
