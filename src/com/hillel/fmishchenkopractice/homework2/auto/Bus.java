package com.hillel.fmishchenkopractice.homework2.auto;

public class Bus extends Car {
    private int passengerSeats;

    Bus(String fuel, String drive) {
        super(fuel, drive);
    }

    public void route() {
        if(passengerSeats == 0){
            System.out.println("Please set passengerSeats");
        }else if(passengerSeats < 36){
            System.out.println("Bus purpose = City");
        }else System.out.println("Bus purpose = Intercity");
    }

    public int getPassengerSeats() {
        return passengerSeats;
    }

    public void setPassengerSeats(int passengerSeats) {
        this.passengerSeats = passengerSeats;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", TYPE = Bus" +
                ", passengerSeats=" + passengerSeats +
                '}';
    }
}
