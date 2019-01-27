package exersices.java8.defaultInterfaceMethods;

public class DefaultInterfaceMethods implements InterfaceWithDefaultMethod{
    private int number;
    @Override
    public int calculate(int a) {
        return this.number + a;
    }
    public static void print() {
        System.out.println(new DefaultInterfaceMethods().calculate(10));
        System.out.println(new DefaultInterfaceMethods().multiply(5,5));
    }
}
