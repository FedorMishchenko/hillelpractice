package com.hillel.fmishchenkopractice.homework10.task1.lockmethod;

public class Deadlock implements Runnable {
    X x = new X();
    Y y = new Y();

    Deadlock() {
        new Thread(this::run).start();
        print("try doX");
        x.doX(y);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ignore){
            /*NOP*/
        }
        print("done doX");
    }
    public static void main(String[] args) {
        new Deadlock();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("additional");
        print("try doY");
        y.doY(x);
        print("done doY");
    }

    public void print(String s) {
        System.out.println(s);
    }

    class X {
        synchronized void doX(Y y) {
            print("in doX thread "
                    + Thread.currentThread().getName()
                    + " blocked");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ignore){
                /*NOP*/
            }
            y.doY(x);
            /*unreachable code*/
            print("out doY");
        }
    }

    class Y {
        synchronized void doY(X x) {
            print("in doY thread "
                    + Thread.currentThread().getName()
                    + " blocked");
            x.doX(y);
            /*unreachable code*/
            print("out doX");
        }
    }
}
