package com.hillel.fmishchenkopractice.homework11.stream;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Comparator;
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
    }//todo: realize

    @NotNull
    static Integer findMinAge(User[] users){
        return Stream.of(users)
                .min(new UserComparator()).get().getAge();

    }
    @NotNull
    static Integer findMaxAge(User[] users){
        return Stream.of(users)
                .max(new UserComparator()).get().getAge();
    }

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
        User[] arr = (User[]) users.toArray();

        for (User user:findAllUserNamesWithoutRepeat(users)){
            print(user.getName());
        }
        print("Min age = " + findMinAge(arr));
        print("Max age = " + findMaxAge(arr));

    }

    private static void print(String str) {
        System.out.println(str);
    }

    private static class UserComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

