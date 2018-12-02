package com.hillel.fmishchenko_practice.HomeWork2.HomeWork_2_ElectricalAppliance;

import java.util.ArrayList;

abstract class ElectricalAppliance {
    private String name;
    private int power;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void sort(ElectricalAppliance[] electricalAppliances){
        int tmp = 0;
        int maxPower = 0;
        for (int i = 0; i < electricalAppliances.length; i++){
            tmp = electricalAppliances[i].getPower();
            if(tmp > maxPower){
                maxPower = tmp;
            }

        }
            System.out.println("Maxpower = " + maxPower);

    }

    public static ArrayList<ElectricalAppliance> findAppliance(ElectricalAppliance[] appliances){
        int maxPower = 3;
        int maxPrice = 50;
        ArrayList<ElectricalAppliance> res = new ArrayList();
        ArrayList<ElectricalAppliance> result = new ArrayList();
        for (int i = 0; i < appliances.length; i++){
                if(maxPower < appliances[i].getPower()){
                    result.add(appliances[i]);
                }
                for (ElectricalAppliance e: result){
                    if(e.getPrice() > maxPrice){
                        res.add(e);
                    }
                }



        }
        return res;
    }
}
