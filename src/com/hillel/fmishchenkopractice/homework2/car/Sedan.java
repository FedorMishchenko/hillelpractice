package com.hillel.fmishchenkopractice.homework2.car;

public class Sedan extends Car {
    private double engineCapacity;

    Sedan(String fuel, String drive) {
        super(fuel, drive);
    }
    public void fuelConsumption(){
        if(engineCapacity == 0){
            System.out.println("Please set engineCapacity");
        }else System.out.println("Sedan fuel consumption = " + engineCapacity * 4);
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", TYPE = Sedan" +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
