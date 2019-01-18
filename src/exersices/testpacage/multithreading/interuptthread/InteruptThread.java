package exersices.testpacage.multithreading.interuptthread;

public class InteruptThread {
    public static void main(String[] args)throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread newThread = Thread.currentThread();
                while (!newThread.isInterrupted()){
                    System.out.println(newThread.isInterrupted());
                    for (long i = 0; i < 1_000_000_000L; i++){

                    }
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
}
