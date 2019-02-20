package com.hillel.fmishchenkopractice.homework2.flowers;

import java.util.Objects;

public class Flower {
    private String name;
    private String color;
    private Integer age;
    private float price;


    Flower(Builder builder) {
        this.name = builder.getName();
        this.color = builder.getColor();
        this.age = builder.getAge();
        this.price = builder.getPrice();
    }
    public static class Builder{
        private String name;
        private String color;
        private Integer age;
        private float price;

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public float getPrice() {
            return price;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }
        public Flower build(){
            return new Flower(this);
        }
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
