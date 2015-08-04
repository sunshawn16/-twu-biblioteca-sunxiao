package com.twu.biblioteca.bean;

public class Book extends Item{
    private String author;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String name, String category, String author, int publishedYear) {
        super(name,category,publishedYear);
        this.author=author;
    }

    @Override
    public  void printInfo(int i){
        System.out.println(i+"   "+getName() + "  " + getAuthor() + "  " + getYear());
    }

}
