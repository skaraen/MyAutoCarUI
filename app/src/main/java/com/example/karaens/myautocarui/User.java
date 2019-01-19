package com.example.karaens.myautocarui;

public class User {
    String carID,email,uid;

    public User() {
    }

    public User(String carID, String email, String uid) {
        this.carID = carID;
        this.email = email;
        this.uid = uid;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String name) {
        this.carID = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
