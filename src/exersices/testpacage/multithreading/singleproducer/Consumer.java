package exersices.testpacage.multithreading.singleproducer;

public class Consumer implements Runnable {
    private SingleElementBuffer buffer;
    public Consumer(SingleElementBuffer buffer) {
        this.buffer = buffer;

    }

    @Override
    public void run() {
        while (true){
            try {
                int elem = buffer.get();
                System.out.println("consumed " + elem);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                return;
            }
        }

    }
}
