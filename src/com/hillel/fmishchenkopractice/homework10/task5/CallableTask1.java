package com.hillel.fmishchenkopractice.homework10.task5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CallableTask1 implements Runnable {
    public Map<Integer,String> map = new ConcurrentHashMap<>();
    @Override
    public void run() {
        int n = 100;
        int index = 0;
        for (int i = 2; i < n; i++) {
            boolean a = true;
            int q = (int) Math.sqrt(i);
            for (int j = 2; j <= q; j++) {
                if ((i % j) == 0) {
                    a = false;
                    break;
                }
            }
            if (a) {
                System.out.print(i + ", ");
                map.put(i,String.valueOf(index++));
            }
        }
    }
}
