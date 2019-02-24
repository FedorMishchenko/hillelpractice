package com.hillel.fmishchenkopractice.homework5.task4;

import java.util.List;

public interface Data {
     Integer size();
     void put(Integer key,User user);
     User get(Integer key);
     List<User> getAll();
     List<User> sort();
     List<User> sort(String param);
     List<User> sort(Integer arg1, Integer arg2);
     void delete(Integer key);

}
