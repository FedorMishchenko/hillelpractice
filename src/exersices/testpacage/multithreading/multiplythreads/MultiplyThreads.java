package exersices.testpacage.multithreading.multiplythreads;

public class MultiplyThreads implements Runnable {

    @Override
    public void run() {
        System.out.println("one Thread start");
        new Thread(new MultiplyThreads()).start();
        System.out.println("                  another thread start");
        new Thread(new MultiplyThreads()).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
