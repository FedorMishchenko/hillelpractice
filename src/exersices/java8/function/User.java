package exersices.java8.function;

public class User {
    private String name, email;
    public User(String name,String email){
        this.name = name;
        this.email = email;
    }
    public String getName(){return this.name;}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
