package com.example.karaens.myautocarui;

public class CollisionStats {
    private Double clat;
    private Double clng;
    private String time;
    private String type;
    private String date;
    private String day;
    private String speed;
    private String carname;
    private String fuel;

    public CollisionStats(Double clng, Double clat, String time, String type, String date, String day, String speed, String carname, String fuel) {
        this.clng = clng;
        this.clat=clat;
        this.time=time;
        this.type=type;
        this.date = date;
        this.day = day;
        this.speed = speed;
        this.carname = carname;
        this.fuel = fuel;
    }

    public Double getClat() {
        return clat;
    }

    public void setClat(Double clat) {
        this.clat = clat;
    }

    public Double getClng() {
        return clng;
    }

    public void setClng(Double clng) {
        this.clng = clng;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }
}
