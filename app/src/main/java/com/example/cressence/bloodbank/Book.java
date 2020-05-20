package com.example.cressence.bloodbank;

public class Book {
    public  int book_id;
    public String hospital;
    public int user_id;
    public String dates;
    public String hour;


    public Book(int book_id, String hospital, int user_id, String hour, String dates) {

        this.book_id = book_id;
        this.hospital = hospital;
        this.user_id = user_id;
        this.dates = dates;
        this.hour = hour;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getHospital() {
        return hospital;
    }

    public String getDates() {
        return dates;
    }

    public String getHour() {
        return hour;
    }

    public int getUser_id() {
        return user_id;
    }


}
