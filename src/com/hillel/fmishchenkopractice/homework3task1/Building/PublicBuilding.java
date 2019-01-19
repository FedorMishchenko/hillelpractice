package com.hillel.fmishchenkopractice.homework3task1.Building;

abstract class PublicBuilding implements Building{

    private int floors;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public void print(){
        System.out.println("Building name = " + name + '\n' + "building has floors = " + floors + '\n');
         }

}
