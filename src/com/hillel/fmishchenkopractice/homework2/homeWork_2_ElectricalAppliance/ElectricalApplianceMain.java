package com.hillel.fmishchenkopractice.homework2.homeWork_2_ElectricalAppliance;

import java.util.ArrayList;

public class ElectricalApplianceMain {
    public static void main(String[] args) {
        ElectricalAppliance computer = new Computer();
        ElectricalAppliance kettle = new Kettle();
        ElectricalAppliance microwave = new Microwave();
        ElectricalAppliance washer = new Washer();

        computer.setName("computer");
        computer.setPower(1);
        computer.setPrice(100);

        kettle.setName("kettle");
        kettle.setPower(2);
        kettle.setPrice(50);

        microwave.setName("microwave");
        microwave.setPower(4);
        microwave.setPrice(120);

        washer.setName("washer");
        washer.setPower(5);
        washer.setPrice(150);

        ElectricalAppliance[] appliances = new ElectricalAppliance[]{computer,kettle,microwave,washer};
        ElectricalAppliance.sort(appliances);

        ArrayList<ElectricalAppliance> list;

        list = ElectricalAppliance.findAppliance(appliances);
        for (int i = 0; i < list.size();i++) {
            System.out.println(list.get(i).getName());
        }
    }
}
