package com.hillel.fmishchenkopractice.homework10.task4;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private List<Truck> store;
    private static final int MAX_LOAD = 5;
    private static final int MIN_LOAD = 0;
    private int counter = 0;

    public Farm(){
        store = new ArrayList<>();
    }
    public synchronized boolean add(Truck truck){
        try {
            if(counter < MAX_LOAD){
                store.add(truck);
                print("Store added: " + store.size());
                counter++;
            }else {
                print("Store is full. Truck loading...");
                notifyAll();
                wait(3000);
                return false;
            }
        }catch (InterruptedException e){
            e.getMessage();
        }
        return true;
    }

    public void print(String s) {
        System.out.println(s);
    }

    public synchronized Truck get(){
        try {
            if(counter > MIN_LOAD){
                for (Truck truck: store){
                    counter--;
                    print("Store size = " + store.size()
                          + '\n' + "Truck " + truck.getNumber()
                            + " loading...");
                    store.remove(truck);
                    return truck;
                }
            }
            print("Store is empty");
            notifyAll();
            wait();
        }catch (InterruptedException e){
            e.getMessage();
        }
        return null;
    }
}
