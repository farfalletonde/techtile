package com.example.techtile.Model;

public class Event {

    private String eventName;
    private int image;
    private String location;
    private double rating;
    private int day;
    private int month;
    private boolean isVIP;

    public Event(String eventName, int image, String location, double rating, int day, int month, boolean isVIP) {
        this.eventName = eventName;
        this.image = image;
        this.location = location;
        this.rating = rating;
        this.day = day;
        this.month = month;
        this.isVIP = isVIP;
    }

    public Event() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }
}
