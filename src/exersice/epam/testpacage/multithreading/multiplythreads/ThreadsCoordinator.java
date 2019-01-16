package exersice.epam.testpacage.multithreading.multiplythreads;

public class ThreadsCoordinator {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread thread = new Thread(new MultiplyThreads()); //При запуске зависнет ОС OutOfMemory
            thread.start();                                    //в результате комбинаторного взрыва
            thread.join();
        }
    }

}
