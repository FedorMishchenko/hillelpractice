package com.hillel.fmishchenkopractice.homework2.electricapps;

import java.util.List;

class ElectricAppsUtil {
    private static final int MAXPOWER = 100;

    static void switchoff(ElectricApps apps){
        if(apps.getPower() > MAXPOWER){
            System.out.println("SWITCH OFF " + apps.getName());
        }else System.out.println(apps + " power normal");
    }
    static ElectricApps checkMaxPowerApps(List<ElectricApps> list){
        ElectricApps tmp = list.get(0);
        for(ElectricApps apps: list){
            if(tmp.getPower() < apps.getPower()){
                tmp = apps;
            }
        }
        return tmp;
    }

}
