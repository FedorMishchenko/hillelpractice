package com.hillel.fmishchenkopractice.homework3.task2.GeometryFigures;

public interface Figure {

    int getPerimeter(int side);

    int getTangle();

    int getSide();

    String toString();

    boolean equals(Figure f);

    int hashcode();


}
