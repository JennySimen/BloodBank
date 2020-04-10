package com.example.cressence.bloodbank;

public class User {
    public  int id;
    public String name;
    public String location;
    public String email;

    public User(int id, String username, String email, String location) {
        this.email = email;
        this.name = name;
        this.location = location;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}