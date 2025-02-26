package com.example.model;

public class Categories extends BaseList<Category, Categories>{
    public Categories(){
        super();
    }
    public void getAll(){
        add(new Category("Lego", "9+"));
        add(new Category("Barbie", "8+"));
        add(new Category("Cars", "12+"));
        add(new Category("Robots", "17+"));
        add(new Category("Dolls", "10+"));
        add(new Category("Action Figures", "16+"));
    }
}
