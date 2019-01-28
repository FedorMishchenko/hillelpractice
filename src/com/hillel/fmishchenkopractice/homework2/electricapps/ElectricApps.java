package com.hillel.fmishchenkopractice.homework2.electricapps;

import java.util.Objects;

public class ElectricApps {
    private String name;
    private int power;
    private int price;

    public ElectricApps(String name,int power,int price) {
        this.name = name;
        this.power = power;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricApps)) return false;
        ElectricApps that = (ElectricApps) o;
        return getPower() == that.getPower() &&
                getPrice() == that.getPrice() &&
                getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower(), getPrice());
    }

    @Override
    public String toString() {
        return "ElectricApps{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", price=" + price +
                '}';
    }
}
