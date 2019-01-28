package exersices.java8.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class FactoryDemo {
    public static void main(String[] args) {
        Factory factory = User::new;
        out.println(factory.create("petro","petro@com").toString());
        out.println("--------------------------------------");

        List<User> list = new ArrayList<>();
        list.add(new User("Ivan","ivan@com"));
        list.add(new User("Petro", "petro@com"));
        list.add(new User("Mikola", "mikola@com"));

        list.sort(Comparator.comparing(User::getName));
        list.forEach(out::println);
        out.println("--------------------------------------");

    }
}
