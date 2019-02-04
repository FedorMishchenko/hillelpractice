package com.hillel.fmishchenkopractice.homework10.task3;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedBuffCopy copier = new SynchronizedBuffCopy(10);
        System.out.println(copier.process().join().getTotalBytes());
    }
}
