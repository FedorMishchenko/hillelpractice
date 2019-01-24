package com.hillel.fmishchenkopractice.homework9.task4;

public class CommandListener {
    public CommandListener(){

    }
    @Command(args = "create",
            print = "Create data",
            create = "create",
            read = "",
            update = "",
            delete = "")
    public void create(String args){

    }
    @Command(args = "read",
            print = "Read data",
            create = "",
            read = "read",
            update = "",
            delete = "")
    public void read(String args){

    }
    @Command(args = "update",
            print = "Update data",
            create = "",
            read = "",
            update = "update",
            delete = "")
    public void update(String args){

    }
    @Command(args = "delete",
            print = "Delete data",
            create = "",
            read = "",
            update = "",
            delete = "delete")
    public void delete(String args){

    }
    public String print(String args){
        return args;
    }

}
