package com.hillel.fmishchenkopractice.homework11.stream;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class User {
    private String name;
    private String email;
    private int age;
    private float salary;
    private Address address;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public User(@NotNull Builder builder, Address address){
        this.name = builder.getName();
        this.email = builder.getEmail();
        this.age = builder.getAge();
        this.salary = builder.getSalary();
        this.address = address;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age &&
                Float.compare(user.salary, salary) == 0 &&
                name.equals(user.name) &&
                email.equals(user.email) &&
                address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age, salary, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", address=" + this.address.toString() +
                '}';
    }

    static class Builder{
        private String name;
        private String email;
        private int age;
        private float salary;

        String getName(){return this.name;}
        String getEmail(){return this.email;}
        int getAge(){return this.age;}
        float getSalary(){return this.salary;}
        Builder name(String name){this.name = name; return this;}
        Builder email(String email){this.email = email; return this;}
        Builder age(int age){this.age = age; return this;}
        Builder salary(float salary){this.salary = salary; return this;}
    }


    static class Address{
        private String country;
        private String city;
        private String street;
        private Integer house;
        private Integer flat;

        public Address(String country, String city, String street,
                       Integer house, Integer flat) {
            this.country = country;
            this.city = city;
            this.street = street;
            this.house = house;
            this.flat = flat;
        }

        public Address() {

        }

        public String getCountry() {
            return country;
        }

        public String getCity() {
            return city;
        }

        public Address city(String city) {
            this.city = city;
            return this;
        }

        public Address country(String country) {
            this.country = country;
            return this;
        }

        public String getStreet() {
            return street;
        }

        public Address street(String street) {
            this.street = street;
            return this;
        }

        public Integer getHouse() {
            return house;
        }

        public Address house(Integer house) {
            this.house = house;
            return this;
        }

        public Integer getFlat() {
            return flat;
        }

        public Address flat(Integer flat) {
            this.flat = flat;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Address)) return false;
            Address address = (Address) o;
            return getCountry().equals(address.getCountry()) &&
                    getCity().equals(address.getCity()) &&
                    getStreet().equals(address.getStreet()) &&
                    getHouse().equals(address.getHouse()) &&
                    Objects.equals(getFlat(), address.getFlat());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCountry(),
                    getCity(), getStreet(), getHouse(), getFlat());
        }

        @Override
        public String toString() {
            return "{" +
                    "country='" + getCountry() + '\'' +
                    ", city='" + getCity() + '\'' +
                    ", street='" + getStreet() + '\'' +
                    ", house=" + getHouse() +
                    ", flat=" + getFlat() +
                    '}';
        }


    }
}
