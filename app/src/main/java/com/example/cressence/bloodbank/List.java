package com.example.cressence.bloodbank;

public class List {
    private String title, info;

    public List() {
    }

    public List(String title, String info) {
        this.title = title;
        this.info = info;
    }

    //getter
    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }
    //setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
