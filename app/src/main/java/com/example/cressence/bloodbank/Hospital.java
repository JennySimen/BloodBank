package com.example.cressence.bloodbank;

public class Hospital {

    private String city;
    private String name;
    private int image;

    public Hospital() {

    }

    public Hospital(String city, String name, int image) {
        this.city = city;

        this.name = name;
        this.image = image;
    }

    //Getters
    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    //setters

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
