package exersices.java8.lambda;


import java.lang.reflect.Array;

public class Lambda {

    public Lambda(FuncInterface funcInterface) {
    }

    public Lambda(FuncInterface2 funcInterface2) {
    }

    public static void main(String[] args) {
        FuncInterface<String, Integer> interface1 = (from) -> Integer.valueOf(from);
        Integer convertedNumber = interface1.abstractFunction("123");
        System.out.println(convertedNumber);

        FuncInterface2<String> interface2 = (massege) -> {
            massege += massege;
            return massege;
        };
        String str = interface2.abstractFunc2("Massege");
        System.out.println(str);


    }
}



