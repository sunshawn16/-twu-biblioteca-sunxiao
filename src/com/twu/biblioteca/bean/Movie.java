package com.twu.biblioteca.bean;

public class Movie extends Item {
    private String director;
    private int rating;



    public Movie(String name,String category,String  director,int publishedYear,int rating){
        super(name,category,publishedYear);
        this.director=director;
        this.rating=rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public  void printInfo(int i){
        System.out.println(i+"   "+getName() + "  " + getDirector() + "   " + getYear()+"     "+getRating());
    }
}
