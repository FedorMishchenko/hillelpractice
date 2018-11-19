package com.hillel.fmishchenko_practice.FlowersBouquet;

public class Rose extends Flowers implements Comparable <Flowers> {
    public Rose() {
    }

    @Override
    public int compareTo(Flowers flowers) {
        return this.getAge() == flowers.getAge()? 0: this.getAge() > flowers.getAge()? 1 : -1;
    }
}
