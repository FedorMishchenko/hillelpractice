package com.hillel.fmishchenkopractice.homework2.car;

import java.util.Objects;

public class Car extends Auto {
    private String fuel;
    private String drive;
    private String additionalFuel;

    public String getAdditionalFuel() {
        return additionalFuel;
    }

    public void setAdditionalFuel(String additionalFuel) {
        this.additionalFuel = additionalFuel;
    }

    Car(String fuel, String drive){
        this.fuel = fuel;
        this.drive = drive;

    }
    @Override
    public String getFuel() {
        return fuel;
    }

    @Override
    public String getDrive() {
        return drive;
    }

    @Override
    public String toString() {
        return super.toString()  +
                ", fuel= " + fuel  +
                ", drive= " + drive  +
                ", additionalFuel= " + additionalFuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car sedan = (Car) o;
        return getFuel().equals(sedan.getFuel()) &&
                getDrive().equals(sedan.getDrive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFuel(), getDrive());
    }
}
