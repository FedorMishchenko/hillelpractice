package exersices.java8.lambda;

public interface FuncInterface<F, T> {
    T abstractFunction(F from);

    default void print(String massege){
        System.out.println(massege);
    }
}
