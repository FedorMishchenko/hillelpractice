package exersices.java8.lambda;

public class Lambda {

    public static void main(String[] args) {
        FuncInterface<String, Integer> interface1 = (from) -> Integer.valueOf(from);
        Integer convertedNumber = interface1.abstractFunction("123");
        System.out.println(convertedNumber);

        FuncInterface<String, Integer> interface3 = Integer::valueOf;
        Integer convertedNumber2 = interface3.abstractFunction("456");
        System.out.println(convertedNumber2);

        FuncInterface2<String> interface2 = (massege) -> {
            int i = interface3.abstractFunction("123");
            int j = interface1.abstractFunction("456");
            return massege + " " + i + " " + j;
        };
        String str = interface2.abstractFunc2("Massege");
        System.out.println(str);
        interface1.print("FuncInterface1");


    }
}



