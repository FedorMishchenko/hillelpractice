package exersices.java8.defaultInterfaceMethods;

public interface InterfaceWithDefaultMethod {
    int calculate(int a);
    default int multiply(int a,int b){
        return Math.multiplyExact(a,b);
    }
}
