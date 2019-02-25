package exersices.testpacage.SQLTest;

import com.hillel.fmishchenkopractice.homework5.task4.Data;
import com.hillel.fmishchenkopractice.homework5.task4.User;

import java.util.List;

public class MySQLBase implements Data {
    @Override
    public Integer size() {
        return null;
    }

    @Override
    public void put(Integer key, User user) {

    }

    @Override
    public User get(Integer key) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> sort() {
        return null;
    }

    @Override
    public List<User> sort(String param) {
        return null;
    }

    @Override
    public List<User> sort(Integer arg1, Integer arg2) {
        return null;
    }

    @Override
    public void delete(Integer key) {

    }
}
