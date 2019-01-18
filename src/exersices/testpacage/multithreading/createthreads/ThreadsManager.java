package exersices.testpacage.multithreading.createthreads;

public class ThreadsManager implements Runnable {
    @Override
    public void run() {
        Thread thread1 = new Thread(new PrintRunnable("first - ",100));
        Thread thread2 = new Thread(new PrintRunnable("        second",99));
        Thread thread3 = new Thread(new PrintRunnable("    third",55));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.out.println("-----------");
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
