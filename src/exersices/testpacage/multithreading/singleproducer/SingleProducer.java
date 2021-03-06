package exersices.testpacage.multithreading.singleproducer;

public class SingleProducer {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1,1000,buffer)).start();
        new Thread(new Producer(1000,1000,buffer)).start();
        new Thread(new Producer(100,1000,buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
