package com.hillel.fmishchenkopractice.homework9.task2;

public class Person {
    private String name;
    private String address;
    private String profession;
    private int age;
    private String email;

    public Person(String name, String profession,
                  String adress, int age,
                  String email) {
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.age = age;
        this.address = adress;
    }

    public Person() {

    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
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
        return age;
    }

    public void setAge(String age) {
        checkForEmpty(age);
        int number = Integer.parseInt(age);
        this.age = number;
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

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (profession != null ? !person.equals(person.profession) : person.profession != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (age > 0 && age < 100 ? age != (person.age) : person.age > 0 && person.age < 100) return false;
        if (address != null ? !address.equals(person.address) : person.address != null) return false;

        return true;
    }

    public boolean isValidUser() {
        if (name == null | name.isEmpty()) return false;
        if (profession == null | profession.isEmpty()) return false;
        if ((email == null | !email.contains("@") | email.isEmpty())) return false;
        if (age < 20 | age > 65) return false;
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
        throw new RuntimeException("User by email " + this.getEmail() + " is not valid.");
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