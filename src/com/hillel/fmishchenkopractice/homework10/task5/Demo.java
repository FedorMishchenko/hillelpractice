package com.hillel.fmishchenkopractice.homework10.task5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {
        CallableTask1 task1 = new CallableTask1();
        CallableTask2 task2 = new CallableTask2();
        ExecutorService service = Executors.newFixedThreadPool(Runtime
                .getRuntime()
                .availableProcessors());
        service.execute(task1);
        System.out.println(task1.map.size());
        /*service.execute(task2);*/
    }
}
