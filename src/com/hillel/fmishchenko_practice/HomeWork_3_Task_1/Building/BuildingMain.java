package com.hillel.fmishchenko_practice.HomeWork_3_Task_1.Building;

public class BuildingMain {
    public static void main(String[] args) {
        Building building = new Theater();
        ((Theater) building).setFloors(2);
        ((Theater) building).setName("ХАТОБ");
        building.print();

        PublicBuilding publicBuilding = new Theater();
        publicBuilding.setName("Театр им.Шевченко");
        publicBuilding.setFloors(3);

        Building building2 = new Adapter(publicBuilding);
        building2.print();

    }
}