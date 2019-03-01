package com.hillel.fmishchenkopractice.homework5.crud.map;

import com.hillel.fmishchenkopractice.homework5.crud.interfaces.ProcessorManager;
import com.hillel.fmishchenkopractice.homework5.task4.User;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class MapProcessor implements ProcessorManager {
    private static final Logger log = Logger.getLogger(MapProcessor.class.getName());
    private Map<Integer, User> map = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void create(String name, String email, Integer age) {

            print("Enter id");
            Integer id = Integer.parseInt(scanner.nextLine());
            map.put(id,new User().name(name).email(email).age(age).id(id));

    }

    @Override
    public void read() {
        map.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(System.out::println);

    }

    @Override
    public void update(String id) {
        print("Enter name:");
        String name = scanner.nextLine();
        print("Enter email:");
        String email = scanner.nextLine();
        print("Enter age:");
        Integer age = scanner.nextInt();
        map.put(Integer.parseInt(id),map.get(id)
                .name(name).email(email).age(age).id(Integer.parseInt(id)));
    }

    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void delete(String id){
        map.remove(Integer.parseInt(id));
    }
}
