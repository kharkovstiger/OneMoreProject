package com.example.recycleview;

public class Moovie {
    private String name;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Moovie() {

    }

    public Moovie(String name, String date) {
        this.name = name;
        this.date = date;
    }
}
