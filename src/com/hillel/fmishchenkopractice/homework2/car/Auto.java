package com.hillel.fmishchenkopractice.homework2.car;

abstract class Auto {

    private String model;
    private String color;
    private int maxSpeed;
    enum type {TRUCK, CAR, MOTO, BUS}

    public abstract String getFuel();

    @Override
    public String toString() {
        return "Auto{" +
                "model= " + model +
                ", color= " + color +
                ", maxSpeed= " + maxSpeed;

    }

    public abstract String getDrive();

    public String getModel(){
        return model;
    }
    public void steModel(String model){
        this.model = model;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int getMaxspeed(){
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

}
