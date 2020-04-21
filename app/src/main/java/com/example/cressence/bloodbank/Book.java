package com.example.cressence.bloodbank;

public class Book {
    public  int book_id;
    public String hospital;
    public String dates;
    public String hour;

    public Book(int book_id, String hospital, String hour, String dates) {

        this.book_id = book_id;
        this.hospital = hospital;
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

}
