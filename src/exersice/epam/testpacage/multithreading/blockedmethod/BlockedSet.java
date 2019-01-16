package exersice.epam.testpacage.multithreading.blockedmethod;

public class BlockedSet {
    public static void main(String[] args) {
        BlockedSet ref = new BlockedSet();
        for (int i = 0; i < 5; i++) {
            new Thread(new BlockedMethodCaller(ref, i)).start();
        }
    }

    public synchronized void f(int i) throws InterruptedException {
        System.out.println("+" + i);
        Thread.sleep(1000);
        /*this.wait(100);*/
        /*this.notifyAll();*/
        System.out.println("-" + i);
    }
}
