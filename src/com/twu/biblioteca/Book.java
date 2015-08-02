package com.twu.biblioteca;

public class Book {
    private String name;
    private String category;
    private String author;
    private int publishedYear;
    private int bookID;

    public Book(int bookID,String name,String category,String author,int publishedYear){
        this.bookID=bookID;
        this.name=name;
        this.author=author;
        this.category=category;
        this.publishedYear= publishedYear;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
