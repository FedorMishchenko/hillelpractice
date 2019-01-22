package com.hillel.fmishchenkopractice.homework9.task2;

public class User {
    private String name;
    private String login;
    private Integer id;
    private int age;
    private String email;
    private String phone;
    private boolean isMarried;

    public User(String name,Integer id,
                String login,int age,
                String email,String phone,
                boolean isMarried) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.age = age;
        this.login = login;
        this.phone = phone;
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }
    @Override
    public boolean equals(Object o) {
/*        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;*/

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !user.equals(user.login) : user.login != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (age > 0 && age < 100 ? age != (user.age) : user.age > 0 && user.age < 100) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;

        return true;
    }
    public boolean isValidUser(){
        if(name == null || name.isEmpty())return false;
        if(login == null || login.isEmpty())return false;
        if((email == null || !email.contains("@") || email.isEmpty()))return false;
        if(age < 0 || age > 100)return false;
        if(id == null || id.intValue() < 1 || id.intValue() > Integer.MAX_VALUE)return false;
        if(phone == null || phone.length() != 10)return false;
        return true;
    }
    @Override
    public int hashCode() {
        if(this.isValidUser()) {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (login != null ? login.hashCode() : 0);
            result = 31 * result + (id != null ? id.hashCode() : 0);
            result = 31 * result + (phone != null ? phone.hashCode() : 0);
            return result;
        }
        throw new RuntimeException("User by id " + this.getId() + " is not valid.");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", isMarried=" + isMarried +
                '}';
    }
}
