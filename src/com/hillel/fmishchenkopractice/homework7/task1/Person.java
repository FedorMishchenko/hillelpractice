package com.hillel.fmishchenkopractice.homework7.task1;

public class Person implements Comparable<Person> {
    private String login;
    private String email;
    private String name;
    private StringBuffer buffer = new StringBuffer();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String getLogin() {
        return login;
    }

    void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int compareTo(Person person) {
        buffer.append(this.email);
        int index = buffer.indexOf("@");
        String temp1 = buffer.substring(index);
        buffer.delete(0,buffer.length());
        buffer.append(person.email);
        index = buffer.indexOf("@");
        String temp2 = buffer.substring(index);

        if (temp1.equals(temp2)) {
            return 0;
        }
        return -1;
    }
    public boolean equals(Person p){
        return this.email.equals(p.email);
    }
}
