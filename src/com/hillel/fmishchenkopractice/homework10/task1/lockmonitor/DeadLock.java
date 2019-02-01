package com.hillel.fmishchenkopractice.homework10.task1.lockmonitor;

public class DeadLock {
    public static void main(String[] args) {
        Object x = new Object();
        Object y = new Object();
        new Thread(() -> {
            synchronized (x){
                print(": got x monitor");
                try{Thread.sleep(1000);}
                catch (InterruptedException ignore){}
                print(": trying to get y monitor");
                synchronized (y){
                    print(": got y monitor");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (y){
                print(": got y monitor");
                try{Thread.sleep(1000);}
                catch (InterruptedException ignore){}
                print(": trying to get x monitor");
                synchronized (x){
                    print(": got y monitor");
                }
            }
        }).start();
    }

    public static void print(String s) {
        System.out.println(Thread.currentThread().getName() + s);
    }
}
