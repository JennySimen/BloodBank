package com.example.cressence.bloodbank;

public class Model {
    private int photoId;
    private String message;
    private String price;


    public Model(int photoId, String message, String price) {
        this.photoId = photoId;
        this.message = message;
        this.price = price;
    }

    public int getPhotoId() {
        return photoId;
    }
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

}
