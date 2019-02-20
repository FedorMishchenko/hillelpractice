package com.hillel.fmishchenkopractice.homework2.auto2;

import java.util.Objects;

public class Auto {
    private String name;
    private String body;
    private String color;
    private int year;
    private int price;

    Auto(String name, String body,
         String color, int year, int price) {
        this.name = name;
        this.body = body;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    private String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return getYear() == auto.getYear() &&
                getPrice() == auto.getPrice() &&
                Objects.equals(getName(), auto.getName()) &&
                Objects.equals(getBody(), auto.getBody()) &&
                Objects.equals(getColor(), auto.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBody(), getColor(), getYear(), getPrice());
    }

    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", body='" + body + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
