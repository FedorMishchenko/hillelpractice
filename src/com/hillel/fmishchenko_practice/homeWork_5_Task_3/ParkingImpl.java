package com.hillel.fmishchenko_practice.homeWork_5_Task_3;

import java.lang.IndexOutOfBoundsException;

public class ParkingImpl extends Parking {
    private int size = 0;

    public ParkingImpl() {

    }

    public void setSize(int index) {
        try {
            if (index >= 0) {
                this.size = index;
            } else throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    public int size() {
        return this.size;
    }
}
