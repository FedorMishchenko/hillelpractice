package com.hillel.fmishchenkopractice.homework2.car;

public class Truck extends Car {
    private int loadCapacity;

    Truck(String fuel, String drive) {
        super(fuel, drive);
    }

    public void load(){
        int time;
        if(loadCapacity != 0){
            time = loadCapacity * 5;
            System.out.println("Truck load time = " + time + " minutes");
        }else System.out.println("Please set loadCapacity");
    }
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", TYPE = Truck " +
                ", loadCapacity=" + loadCapacity +
                '}';
    }
}
