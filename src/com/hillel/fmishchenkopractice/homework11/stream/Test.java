package com.hillel.fmishchenkopractice.homework11.stream;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    static List<User> findAllUserNamesWithoutRepeat(@NotNull List<User> users) {
        return users.stream().distinct().collect(Collectors.toList());
    }
    @Nullable
    @Contract(pure = true)
    static Set<String> findUserNamesUniqueInArray(User[] users){
        return null;
    }
    /*Integer findMinAge(User[] users){
        Stream.of(users)
                .filter(x -> )
    }
    Integer findMinAge(User[] users){

    }*/


    public static void main(String[] args) {
        User user1 = new User(new User.Builder().name("Bil").email("bil@email").age(30).salary(250f),
                new User.Address().country("USA").city("New York").street("Avenue12")
                        .house(256).flat(12));
        User copy = new User(new User.Builder().name("Bil").email("bil@email").age(30).salary(250f),
                new User.Address().country("USA").city("New York").street("Avenue12")
                        .house(256).flat(12));
        User user2 = new User(new User.Builder().name("Tom").email("tom@email").age(46).salary(180f),
                new User.Address().country("USA").city("New York").street("Avenue8")
                        .house(3).flat(8));
        User user3 = new User(new User.Builder().name("Jack").email("jack@email").age(19).salary(330f),
                new User.Address().country("USA").city("New York").street("Avenue3")
                        .house(100).flat(2));
        List<User> users = Arrays.asList(user1, user2, user3, user1,copy);

        for (User user:findAllUserNamesWithoutRepeat(users)){
            print(user.getName());
        }

    }

    private static void print(String str) {
        System.out.println(str);
    }

}

