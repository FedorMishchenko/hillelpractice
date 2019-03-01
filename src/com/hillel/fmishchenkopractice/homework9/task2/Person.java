package com.hillel.fmishchenkopractice.homework9.task2;

import java.util.Objects;

public class Person {
    private String name;
    private String address;
    private String profession;
    private String age;
    private String email;

    public Person(String name, String profession,
                  String adress, String age,
                  String email) {
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.age = age;
        this.address = adress;
    }

    public Person() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        checkForEmpty(address);
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        checkForEmpty(profession);
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkForEmpty(name);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        checkForEmpty(email);
        this.email = email;
    }

    public int getAge() {
        return Integer.parseInt(age);
    }

    public void setAge(String age) {
        checkForEmpty(age);
        /*int number = Integer.parseInt(age);*/
        this.age = age;
    }

    private void checkForEmpty(String value) {
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException("Value shouldn't be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
/*        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;*/

        Person person = (Person) o;

        if (!Objects.equals(name, person.name)) return false;
        if (profession != null ? !person.equals(person.profession) : person.profession != null) return false;
        if (!Objects.equals(email, person.email)) return false;
        if (!Objects.equals(address, person.address)) return false;

        return true;
    }

    private boolean isValidUser() {
        if (name == null | name.isEmpty()) return false;
        if (profession == null | profession.isEmpty()) return false;
        if ((email == null | !email.contains("@") | email.isEmpty())) return false;
        if (Integer.parseInt(age) < 20 | Integer.parseInt(age) > 65) return false;
        if (address == null | address.isEmpty()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (this.isValidUser()) {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (profession != null ? profession.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            return result;
        }
        throw new RuntimeException("UserDTO by email " + this.getEmail() + " is not valid.");
    }

    @Override
    public String toString() {
        return "Person [" +
                "name = " + name  +
                "; address = " + address  +
                "; age = " + age +
                "; email = " + email  +
                "; profession = " + profession +
                ']';
    }
}
