package com.hillel.fmishchenkopractice.homework3task2.GeometryFigures;

public interface Figure {

        public int getPerimeter(int side);

        public int getTangle();

        int getSide();

        public String toString();

        public boolean equals(Figure f);

        public int hashcode();


}
