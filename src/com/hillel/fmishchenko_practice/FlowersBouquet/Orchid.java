package com.hillel.fmishchenko_practice.FlowersBouquet;

public class Orchid extends Flowers implements Comparable <Flowers>{
    public Orchid() {
    }

    @Override
    public int compareTo(Flowers flowers) {
        return this.getAge() == flowers.getAge()? 0: this.getAge() > flowers.getAge()? 1 : -1;
    }
}
