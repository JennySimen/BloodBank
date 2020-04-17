package com.example.cressence.bloodbank;

public class User {
    public  int id;
    public String name;
    public String location;
    public String email;
    public String blood;

    public User(int id, String name, String email, String location, String blood) {
        this.email = email;
        this.name = name;
        this.location = location;
        this.id = id;
        this.blood = blood;
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

    public String getBlood() {
        return blood;
    }
}
