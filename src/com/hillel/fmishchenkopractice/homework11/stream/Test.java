package com.hillel.fmishchenkopractice.homework11.stream;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    @NotNull
    public static List<User> list() {
        User user1 = new User(new User.Builder().name("Bill").email("bil@email").age(19).salary(250),
                new User.Address().country("USA").city("New York").street("Avenue12")
                        .house(256).flat(12));
        User copy = new User(new User.Builder().name("Bill").email("bil@email").age(19).salary(250),
                new User.Address().country("USA").city("New York").street("Avenue12")
                        .house(256).flat(12));
        User user2 = new User(new User.Builder().name("Tom").email("tom@email").age(46).salary(180),
                new User.Address().country("USA").city("New York").street("Avenue8")
                        .house(3).flat(8));
        User user3 = new User(new User.Builder().name("Jack").email("jack@email").age(30).salary(330),
                new User.Address().country("USA").city("New York").street("Avenue3")
                        .house(100).flat(2));
        return Arrays.asList(user1, user2, user3, user1, copy);
    }
    private static List<User> findAllUserNamesWithoutRepeat(@NotNull List<User> users) {
        print("Find all User names without repeat: ");
        return users.stream().distinct().collect(Collectors.toList());
    }

    @NotNull
    @Contract(pure = true)
    private static Set<String> findUserNamesUniqueInArray(User[] users) {
        Set<String> names = new HashSet<>();
        Set<User> tmp = Stream.of(users)
                .collect(Collectors.toSet());
        for (User u : tmp) {
            names.add(u.getName());
        }
        print("Find User names unique in array: ");
        return names;
    }

    @NotNull
    private static Integer findMinAge(User[] users) {
        return Stream.of(users)
                .min(new AgeComparator()).get().getAge();
    }

    @NotNull
    private static Integer findMaxAge(User[] users) {
        return Stream.of(users)
                .max(new AgeComparator()).get().getAge();
    }

     private static LongSummaryStatistics findSumOfSalariesForAllUsers(@NotNull List<User> list) {
         return list
                 .stream()
                 .collect(Collectors.summarizingLong(User::getSalary));

     }
  /* List<User> findUsersWhereAgeBeatweenAndNameContainsSymbol(
           Integer fromAge, Integer toAge, String symbol){

   }*/
    public static void main(String[] args) {
        print("All Users:");
        for (User user : list()) {
            print(user.toString());
        }
        print("______________________________");
        Map<Integer, User> map = new HashMap<>();
        int i = 0;
        for (User user : list()) map.put(i++, user);
        User[] arr = (User[]) list().toArray();

        for (User user : findAllUserNamesWithoutRepeat(list())) {
            print(user.getName());
        }
        print("______________________________");
        for (String name : Objects.requireNonNull(findUserNamesUniqueInArray(arr))) {
            print(name);
        }
        print("______________________________");
        print("Min age = " + findMinAge(arr));
        print("Max age = " + findMaxAge(arr));
        print("______________________________");
        print(findSumOfSalariesForAllUsers(list()).toString());
        print("______________________________");
    }

    private static void print(String str) {
        System.out.println(str);
    }

    private static class AgeComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}

