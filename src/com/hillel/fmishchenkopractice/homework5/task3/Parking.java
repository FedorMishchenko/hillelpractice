package com.hillel.fmishchenkopractice.homework5.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Parking {
    private int size;
    private final static String FREE = "FREE";
    private HashMap<Integer, String> map = new HashMap<>();

    public Parking(int size) {
        this.size = size;
        for (int i = 0; i <= size; i++) {
            this.map.put(i, getStatus());
        }
    }

    public int getSize() {
        return size;
    }

    public static String getStatus() {
        return FREE;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean arrivalAuto(String numberCar) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(getStatus())) {
                entry.setValue(numberCar);
                return true;
            }
        }
        System.out.println("All places are occupied");
        return false;
    }

    public boolean departureAuto(String numberCar) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(numberCar)) {
                entry.setValue(getStatus());
                return true;
            }
        }
        System.out.println("This car is not in the parking.");
        return false;
    }


    public String print() {
        System.out.println("-----the status of parking spaces-----");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.printf("Place: %d,  number of the car: %s\n", entry.getKey(), entry.getValue());
        }
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return size == parking.size &&
                Objects.equals(map, parking.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, map);
    }
}