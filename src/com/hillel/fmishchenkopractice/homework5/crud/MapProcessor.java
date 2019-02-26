package com.hillel.fmishchenkopractice.homework5.crud;

import com.hillel.fmishchenkopractice.homework5.task4.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MapProcessor implements ProcessorManager {
    private static final Logger log = Logger.getLogger(MapProcessor.class.getName());
    private Map<Integer, User> map = new HashMap<>();

    @Override
    public void create(String name, String email, Integer age) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            print("Enter id");
            Integer id = Integer.parseInt(reader.readLine());
            map.put(id,new User().name(name).email(email).age(age).id(id));
        }catch (IOException e){
            log.warning(e.toString());
        }

    }

    @Override
    public void read() {
        map.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(System.out::println);

    }

    @Override
    public void update(BufferedReader reader, String id) throws IOException {
        print("Enter name:");
        String name = reader.readLine();
        print("Enter email:");
        String email = reader.readLine();
        print("Enter age:");
        Integer age = Integer.parseInt(reader.readLine());
        map.put(Integer.parseInt(id),map.get(id)
                .name(name).email(email).age(age).id(Integer.parseInt(id)));
    }

    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void delete(BufferedReader reader, String id){
        map.remove(Integer.parseInt(id));
    }
}
