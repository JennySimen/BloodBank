package com.example.cressence.bloodbank;

public class Notification {
    private String title, info, city, price;
    private int notification_id;

    public Notification() {
    }

    public Notification(int notification_id, String title, String info, String city, String price ) {
        this.notification_id = notification_id;
        this.title = title;
        this.info = info;
        this.city = city;
        this.price = price;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }
}
