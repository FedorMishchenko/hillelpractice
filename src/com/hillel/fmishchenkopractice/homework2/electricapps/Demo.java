package com.hillel.fmishchenkopractice.homework2.electricapps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        List<ElectricApps> list = new ArrayList<>();
        ElectricAppsFactory factory = ElectricApps::new;
        Map<String,ElectricApps> map = new HashMap();
        map.put("micro", (ElectricApps) factory.create("microwave",20,555));
        map.put("kettle", (ElectricApps) factory.create("kettle",5,100));
        map.put("comp", (ElectricApps) factory.create("computer",2,1000));
        map.forEach((k,v) -> System.out.println("App = " + k + " " + v.toString()));

        map.forEach((k,v) -> list.add(v));
        Function<List<ElectricApps>,ElectricApps> check = ElectricAppsUtil::checkMaxPowerApps;
        System.out.println("Max power apps = " + check.apply(list).toString());
        ElectricApps app = check.apply(list);
        ElectricAppsUtil.switchoff(app);
    }
}
