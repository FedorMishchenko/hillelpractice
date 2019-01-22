package com.hillel.fmishchenkopractice.homework5.task3;


class Car implements Comparable<Car>{
    private String model;
    private int key;

    public String getModel() {
        return this.model;
    }

    public int getKey() {
        key = this.hashCode();
        return key;
    }
    public Car(String model) {
        this.model = model;
    }
    @Override
    public int compareTo(Car auto) {
        if (!getModel().equals(auto.getModel())) {
            if (getModel().compareTo(auto.getModel()) > 0){
                return 1;
            }
            else return -1;
        }
        return 0;

    }
    public String toString(){
        return this.model;
    }
}
