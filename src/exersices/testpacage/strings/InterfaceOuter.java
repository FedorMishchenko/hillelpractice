package exersices.testpacage.strings;

public interface InterfaceOuter {
    class ClassInner {
       public  void f(){
           System.out.println("Hello");
        }
        public static void main(String[] args) {
            InterfaceOuter.ClassInner inner = new InterfaceOuter.ClassInner();
            inner.f();

        }
    }
}
