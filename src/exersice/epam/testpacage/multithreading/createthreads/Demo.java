package exersice.epam.testpacage.multithreading.createthreads;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Thread manager = new Thread(new ThreadsManager());
        manager.start();
        System.out.println("main thread sleep");
        manager.join();
        System.out.println("main thread awake");
    }
}
