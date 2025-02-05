package com.example.model;

public class Toy  extends BaseEntity {
    private String name;
    private double price;
    private String picture;

    public Toy(){
        /*empty space*/
    }
    public Toy(String name, double price){
        this.name = name;
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }
    public String getPicture(){
        return this.picture;
    }
}
