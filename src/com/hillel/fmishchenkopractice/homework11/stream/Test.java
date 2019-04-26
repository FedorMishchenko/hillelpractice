package com.hillel.fmishchenkopractice.homework11.stream;

import com.hillel.fmishchenkopractice.homework12.restaurant.ui.Menu;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    private static Menu printf = new Menu();
    @NotNull
    public  List<User> list() {
        User user1 = new User(new User.Builder().id(new UUID(1L,3L)).name("Bill")
                .email("bill@email").age(19).salary(250)
                .address(new User.Address().country("USA").city("New York")
                .street("Avenue12").house(256).flat(12)));
        User user2 = new User(new User.Builder().id().name("Tom")
                .email("tom@email").age(27).salary(189)
                .address(new User.Address().country("USA").city("New York")
                .street("Avenue8").house(13).flat(9)));
        User user3 = new User(new User.Builder().id().name("Jack")
                .email("jack@email").age(31).salary(280)
                .address(new User.Address().country("USA").city("New York")
                .street("Avenue2").house(112).flat(89)));
        User user4 = new User(new User.Builder().id().name("Sara")
                .age(21).salary(200)
                .address(new User.Address().country("Canada").city("Toronto")
                .street("Avenue12").house(258).flat(4)));
        return Arrays.asList(user1, user2, user3, user1, user4);
    }
    private  List<User> findAllUserNamesWithoutRepeat(@NotNull List<User> users) {
        return users.stream().distinct().collect(Collectors.toList());
    }

    @NotNull
    @Contract(pure = true)
    private  Set<String> findUserNamesUniqueInArray(User[] users) {
        Set<String> names = new HashSet<>();
        Set<User> tmp = Stream.of(users)
                .collect(Collectors.toSet());
        for (User u : tmp) {
            names.add(u.getName());
        }
        return names;
    }

    @NotNull
    private  Integer findMinAge(User[] users) {
        return Stream.of(users)
                .min(new AgeComparator()).get().getAge();
    }

    @NotNull
    private  Integer findMaxAge(User[] users) {
        return Stream.of(users)
                .max(new AgeComparator()).get().getAge();
    }

     private static LongSummaryStatistics findSumOfSalariesForAllUsers(@NotNull List<User> list) {
         return list
                 .stream()
                 .collect(Collectors.summarizingLong(User::getSalary));

     }
   private  List<User> findUsersWhereAgeBetweenAndNameContainsSymbol(
           Integer fromAge, Integer toAge, String symbol){
        return list()
                .stream()
                .filter(x -> x.getAge() < toAge && x.getAge() > fromAge)
                .filter(x -> x.getName().contains(symbol))
                .collect(Collectors.toList());
   }
    private  List<User> deleteAllUsersWhereEmailIsNull(User [] users){
        return Stream.of(users)
                .filter(x -> x.getEmail()!= null)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        Test x = new Test();
        print("All Users:");
        for (User user : x.list()) {
            /*print(user.toString());*/
            printf.format(user.getName());
            printf.format(user.getEmail());
            printf.format(Integer.toString(user.getAge()));
            printf.format(user.getAddress().toString());
        }
        print("______________________________");
        User[] arr = (User[]) x.list().toArray();
        print("Find all User's names without repeat: ");
        for (User user : x.findAllUserNamesWithoutRepeat(x.list())) {
            print(user.getName());
        }
        print("______________________________");
        print("Find User's names unique in array: ");
        for (String name : Objects.requireNonNull(x.findUserNamesUniqueInArray(arr))) {
            print(name);
        }
        print("______________________________");
        print("Min User age = " + x.findMinAge(arr));
        print("Max User age = " + x.findMaxAge(arr));
        print("______________________________");
        print(findSumOfSalariesForAllUsers(x.list()).toString());
        print("User's salaries sum = " + findSumOfSalariesForAllUsers(x.list()).getSum());
        print("______________________________");
        print("Find Users where age between and name contains symbol:");
        for (User user:x.findUsersWhereAgeBetweenAndNameContainsSymbol(18,31,"B")){
            print(user.toString());
        }
        print("______________________________");
        print("Delete all Users where email is null:");
        for(User user: x.deleteAllUsersWhereEmailIsNull(arr)){
            print(user.getName() + ": " + user.getEmail());
        }
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

