package com.hillel.fmishchenkopractice.homework10.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        Farm farm = new Farm();
        TruckFactory factory = new TruckFactory(farm);
        TruckLoader loader1 = new TruckLoader(farm);
        TruckLoader loader2 = new TruckLoader(farm);
        TruckLoader loader3 = new TruckLoader(farm);
        TruckLoader loader4 = new TruckLoader(farm);
        TruckLoader loader5 = new TruckLoader(farm);
        ExecutorService service = Executors.newFixedThreadPool(Runtime
                        .getRuntime()
                        .availableProcessors());
        service.execute(factory);
        service.execute(loader1);
        service.execute(loader2);
        service.execute(loader3);
        service.execute(loader4);
        service.execute(loader5);
        service.shutdown();
    }
}
