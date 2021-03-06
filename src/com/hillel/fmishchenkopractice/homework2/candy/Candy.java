package com.hillel.fmishchenkopractice.homework2.candy;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Candy extends Sweets{
    private String name;
    private String color;
    private boolean sugar;
    private float price;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isSugar() {
        return sugar;
    }

    public float getPrice() {
        return price;
    }

    Candy(@NotNull Builder builder) {
        this.name = builder.getName();
        this.color = builder.getColor();
        this.sugar = builder.isSugar();
        this.price = builder.getPrice();
    }

    public static class Builder {
        private String name;
        private String color;
        private boolean sugar;
        private float price;

        public String getName() {
            return name;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public String getColor() {
            return color;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public boolean isSugar() {
            return sugar;
        }

        public Builder sugar(boolean sugar) {
            this.sugar = sugar;
            return this;
        }

        public float getPrice() {
            return price;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }
        public Candy build(){
            return new Candy(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candy)) return false;
        Candy candy = (Candy) o;
        return sugar == candy.sugar &&
                price == candy.price &&
                name.equals(candy.name) &&
                color.equals(candy.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, sugar, price);
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
