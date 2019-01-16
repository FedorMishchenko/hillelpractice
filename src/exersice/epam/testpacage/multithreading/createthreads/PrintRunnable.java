package exersice.epam.testpacage.multithreading.createthreads;

public class PrintRunnable implements Runnable {

    String massege;
    long sleepMillis;

    public PrintRunnable(String msg, long sleepMillis){
        this.massege = msg;
        this.sleepMillis = sleepMillis;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            System.out.println(massege);
        }
    }
}
