package com.hillel.fmishchenkopractice.homework10.task1.lockmethod;

import java.util.concurrent.locks.ReentrantLock;

public class Unlock implements Runnable {
    private static X x = new X();
    private static Y y = new Y();
    private ReentrantLock lock;

    private Unlock(X x, Y y, ReentrantLock lock) {
        Unlock.x = x;
        Unlock.y = y;
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
            x.doX(y);
            print(": lock run()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {

            }
            y.doY(x);
            print(": out from doY");
        } finally {
            lock.unlock();
            print(": unlock run()");
        }
    }

    private void run2() {
        lock.lock();
        try {
            y.doY(x);
            print(": lock run2()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {

            }

            x.doX(y);
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


