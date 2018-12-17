package com.hillel.fmishchenko_practice.flowersBouquet;

public class Aster extends Flowers implements Comparable<Flowers> {
    public Aster() {
        super();
    }

    @Override
    public int compareTo(Flowers flowers) {
        return this.getAge() == flowers.getAge()? 0: this.getAge() > flowers.getAge()? 1 : -1;
    }
}
