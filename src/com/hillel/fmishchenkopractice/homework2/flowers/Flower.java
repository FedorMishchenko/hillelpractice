package com.hillel.fmishchenkopractice.homework2.flowers;

import java.util.Objects;

public class Flower {
    private String name;
    private String color;
    private Integer age;
    private Integer price;
    public Flower(String name, String color,
                  Integer age, Integer price) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;
        Flower flower = (Flower) o;
        return name.equals(flower.name) &&
                color.equals(flower.color);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }

}
