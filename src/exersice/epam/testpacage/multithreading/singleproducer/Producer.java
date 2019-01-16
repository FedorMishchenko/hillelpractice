package exersice.epam.testpacage.multithreading.singleproducer;

public class Producer implements Runnable {
    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;
    public Producer(int startValue, int period, SingleElementBuffer buffer) {
        this.startValue = startValue;
        this.period = period;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("produced " + startValue);
                buffer.put(startValue++);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                return;
            }
        }
    }
}
