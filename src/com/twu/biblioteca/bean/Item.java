package com.twu.biblioteca.bean;


public class Item {
    private String name;
    private String category;
    private int year;
    public Item(String name,String category,int year){
        this.name=name;
        this.category= category;
        this.year= year;
    }


    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public  void printInfo(int i){}
}
