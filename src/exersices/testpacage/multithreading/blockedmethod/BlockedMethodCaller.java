package exersices.testpacage.multithreading.blockedmethod;

public class BlockedMethodCaller implements Runnable {
    private final BlockedSet ref;
    private final int i;

    public BlockedMethodCaller(BlockedSet ref,int i){
        this.ref = ref;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            ref.f(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
