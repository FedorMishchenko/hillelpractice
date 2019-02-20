package com.hillel.fmishchenkopractice.homework2.candy;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Bisquit extends Sweets {
    private String name;
    private String color;
    private boolean dough;
    private float price;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isDough() {
        return dough;
    }

    public float getPrice() {
        return price;
    }

    Bisquit(@NotNull Builder builder){
        this.name = builder.getName();
        this.color = builder.getColor();
        this.dough = builder.isDough();
        this.price = builder.getPrice();
    }

    public static class Builder {
        private String name;
        private String color;
        private boolean dough;
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

        public boolean isDough() {
            return dough;
        }

        public Builder dough(boolean sugar) {
            this.dough = sugar;
            return this;
        }

        public float getPrice() {
            return price;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }
        public Bisquit build(){
            return new Bisquit(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bisquit)) return false;
        Bisquit bisquit = (Bisquit) o;
        return dough == bisquit.dough &&
                Float.compare(bisquit.price, price) == 0 &&
                name.equals(bisquit.name) &&
                color.equals(bisquit.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, dough, price);
    }

    @Override
    public String toString() {
        return "Bisquit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", dough=" + dough +
                ", price=" + price +
                '}';
    }
}
