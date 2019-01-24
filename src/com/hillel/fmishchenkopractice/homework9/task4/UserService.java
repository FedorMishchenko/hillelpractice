package com.hillel.fmishchenkopractice.homework9.task4;

public class UserService {
    private User user;
    public UserService(){

    }
    @Command(args = "create",
            print = "Create user",
            create = "create",
            read = "",
            update = "",
            delete = "")
    public void create(String args){
        print(args);
        user = new User();

    }
    @Command(args = "read",
            print = "Read data",
            create = "",
            read = "read",
            update = "",
            delete = "")
    public void read(String args){
        if(this.user != null){
            print(user.toString());
        }
    }
    @Command(args = "update",
            print = "Update data",
            create = "",
            read = "",
            update = "update",
            delete = "")
    public void update(String args){
        print(args);
        if(this.user != null){

        }
    }
    @Command(args = "delete",
            print = "User deleted",
            create = "",
            read = "",
            update = "",
            delete = "delete")
    public void delete(String args){
        if(this.user != null){
            this.user = null;
            print(args);
        }else {
            throw new RuntimeException("Deleted user not exists");
        }

    }
    public void print(String args){
        System.out.println(args);
    }

}
