package exersices.testpacage.strings;

public class TestPrimitives {

    public static int x = 0;
    private int y = 0;

    public TestPrimitives(){
        x++;
        y++;
    }
    public static void main(String[] args) {

     TestPrimitives t1 = new TestPrimitives();
     TestPrimitives t2 = new TestPrimitives();
     TestPrimitives t3 = new TestPrimitives();

        System.out.println(t1.x);
        System.out.println(t2.y);
        System.out.println(t3.y);

    }
}
