package com.hillel.fmishchenkopractice.homework9.task2;

public class User {
    private String name;
    private String adress;
    private String profession;
    private int age;
    private String email;

    public User(String name, String profession,
                String adress, int age,
                String email) {
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.age = age;
        this.adress = adress;
    }

    public User() {

    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        checkForEmpty(adress);
        this.adress = adress;
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

    public void setAge(int age) {
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

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (profession != null ? !user.equals(user.profession) : user.profession != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (age > 0 && age < 100 ? age != (user.age) : user.age > 0 && user.age < 100) return false;
        if (adress != null ? !adress.equals(user.adress) : user.adress != null) return false;

        return true;
    }

    public boolean isValidUser() {
        if (name == null || name.isEmpty()) return false;
        if (profession == null || profession.isEmpty()) return false;
        if ((email == null || !email.contains("@") || email.isEmpty())) return false;
        if (age < 0 || age > 100) return false;
        if (adress == null || adress.isEmpty()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (this.isValidUser()) {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (profession != null ? profession.hashCode() : 0);
            result = 31 * result + (adress != null ? adress.hashCode() : 0);
            return result;
        }
        throw new RuntimeException("User by id " + this.getEmail() + " is not valid.");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", profession=" + profession +
                '}';
    }
}
