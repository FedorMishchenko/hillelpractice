package com.hillel.fmishchenkopractice.homework10.task1.lockmethod;

import java.util.concurrent.locks.ReentrantLock;

public class Unlock implements Runnable {
    static X x = new X();
    static Y y = new Y();
    ReentrantLock lock;

    Unlock(X x, Y y, ReentrantLock lock) {
        this.x = x;
        this.y = y;
        this.lock = lock;
        new Thread(this::run).start();
        new Thread(this::run2).start();
    }

    public static void main(String[] args) {
        new Unlock(x,y,new ReentrantLock());
        print(": finish");
    }

    @Override
    public void run() {
        lock.lock();
        try {
            this.x.doX(y);
            print(": lock run()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {

            }
            this.y.doY(x);
            print(": out from doY");
        } finally {
            lock.unlock();
            print(": unlock run()");
        }
    }

    public void run2() {
        lock.lock();
        try {
            this.y.doY(x);
            print(": lock run2()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {

            }

            this.x.doX(y);
            print(": out from doX");

        } finally {
            lock.unlock();
            print(": unlock run2()");
        }
    }

    public static void print(String s) {
        System.out.println(Thread.currentThread().getName() + s);
    }

    static class X {
        synchronized void doX(Y y) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            print(": inside doX");
        }
    }

    static class Y {
        synchronized void doY(X x) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print(": inside doY");
        }
    }
}


