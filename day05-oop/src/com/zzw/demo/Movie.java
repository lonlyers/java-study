package com.zzw.demo;

public class Movie {
    // 成员变量
    private double price;
    private String director;
    private int id;
    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  Movie() {

    }
    public  Movie(String name, double price, String director, int id) {
        this.price = price;
        this.director = director;
        this.id = id;
        this.name = name;
    }

}
