package com.hillel.fmishchenkopractice.homework10.task1.lockmonitor;

import java.util.concurrent.locks.ReentrantLock;

public class Unlock {
    public static void main(String[] args) {
        Object x = new Object();
        Object y = new Object();
        ReentrantLock lock = new ReentrantLock();

        new MyThread(x,y,lock).run();
        new MyThread(y,x,lock).run();


    }

    static class MyThread implements Runnable {
        private Object res;
        private Object res2;
        ReentrantLock lock;

        public MyThread(Object res,Object res2, ReentrantLock lock) {
            this.res = res;
            this.res2 = res2;
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                synchronized (res) {
                    print(": got x monitor");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignore) {
                    }
                    print(": trying to get y monitor");
                    synchronized (res2) {
                        print(": got y monitor");
                    }
                }

            } finally {
                lock.unlock();
            }
        }

        public void print(String s) {
            System.out.println(Thread.currentThread().getName() + s);
        }
    }

}
