package com.hillel.fmishchenkopractice.homework5.task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataImpl {
    private Map<Integer, User> map = new HashMap<>();

    public Integer size() {
        return map.size();
    }

    public void put(Integer key, User user) {
        map.put(key, user);
    }

    public User get(Integer key) {
        return map.get(key);
    }

     List<User> getAll() {
        return Stream.of(map)
                .flatMap(x -> x.entrySet().stream())
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public List<User> sort() {
        return Stream.of(map)
                .flatMap(x -> x.entrySet().stream())
                .map(Map.Entry::getValue)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<User> sort(Integer arg1, Integer arg2) {
        return Stream.of(map)
                .flatMap(x -> x.entrySet().stream())
                .map(Map.Entry::getValue)
                .filter(x -> x.getAge() > arg1 && x.getAge() < arg2)
                .collect(Collectors.toList());
    }

    public List<User> sort(String param) {
        return Stream.of(map)
                .flatMap(x -> x.entrySet().stream())
                .map(Map.Entry::getValue)
                .filter(x -> x.getName().startsWith(param))
                .collect(Collectors.toList());
    }

    public void delete(Integer key) {
        map.remove(key);
    }
}
