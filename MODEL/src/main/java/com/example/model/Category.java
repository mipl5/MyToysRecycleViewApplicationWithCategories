package com.example.model;

public class Category extends BaseEntity {
    private String name;
    private String ageRange;
    private String picture;

    public Category(){
        /*empty space*/
    }

    public Category(String name, String ageRange){
        this.name = name;
        this.ageRange = ageRange;
    }

    public String getName(){
        return this.name;
    }
    public String getAgeRange(){
        return this.ageRange;
    }
    public String getPicture(){
        return this.picture;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAgeRange(String ageRange){
        this.ageRange = ageRange;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }
}
