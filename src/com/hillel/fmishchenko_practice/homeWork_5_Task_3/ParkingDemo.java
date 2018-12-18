package com.hillel.fmishchenko_practice.homeWork_5_Task_3;


public class ParkingDemo {

    public static void main(String[] args) {
        Parking parking = new Parking();
        Car reno = new Car("reno");
        Car citroen = new Car("citroen");
        Car peugeot = new Car("peugeot");
        parking.put(reno.getKey(),reno);
        System.out.println("Arrival " + reno.getModel());
        parking.put(citroen.getKey(),citroen);
        System.out.println("Arrival " + citroen.getModel());
        parking.put(peugeot.getKey(),peugeot);
        System.out.println("Arrival " + peugeot.getModel());
        System.out.println("Cars on parking: " + parking.size());
        parking.remove(peugeot.getKey());
        System.out.println(peugeot.getModel() + " has departure");
        System.out.println("Is " + peugeot.getModel() +
                " on parking: "+ parking.containsValue(peugeot));
        System.out.println("Cars on parking: " + parking.size());
        parking.clear();
        System.out.println(parking.size());




    }
}
