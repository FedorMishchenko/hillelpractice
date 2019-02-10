package com.hillel.fmishchenkopractice.homework2.candy;

import java.util.Objects;

public class Candy {
    private String name;
    private String color;
    private boolean sugar;
    private int price;

    Candy(String name, String color,
          boolean sugar, int price) {
        this.name = name;
        this.color = color;
        this.sugar = sugar;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candy)) return false;
        Candy candy = (Candy) o;
        return isSugar() == candy.isSugar() &&
                getPrice() == candy.getPrice() &&
                getName().equals(candy.getName()) &&
                getColor().equals(candy.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor(), isSugar(), getPrice());
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", sugar=" + sugar +
                ", price=" + price +
                '}';
    }
}
