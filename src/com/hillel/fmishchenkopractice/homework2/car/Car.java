package com.hillel.fmishchenkopractice.homework2.car;

import java.util.Objects;

public class Car extends Auto {
    private String fuel;
    private String drive;
    private type Type;
    private String additionalFuel;
    private int loadCapacity;
    private int passengerSeats;

    public int getPassengerSeats() {
        return passengerSeats;
    }

    public void setPassengerSeats(int passengerSeats) {
        this.passengerSeats = passengerSeats;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String getAdditionalFuel() {
        return additionalFuel;
    }

    public void setAdditionalFuel(String additionalFuel) {
        this.additionalFuel = additionalFuel;
    }

    Car(type T, String fuel, String drive){
        this.Type = T;
        this.fuel = fuel;
        this.drive = drive;

    }
    public type getType(){
        return this.Type;
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
                ", Type= " + Type +
                ", additionalFuel= " + additionalFuel  +
                ", loadCapacity= " + loadCapacity +
                ", passengerSeats= " + passengerSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car sedan = (Car) o;
        return getFuel().equals(sedan.getFuel()) &&
                getDrive().equals(sedan.getDrive()) &&
                getType() == sedan.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFuel(), getDrive(), getType());
    }
}
