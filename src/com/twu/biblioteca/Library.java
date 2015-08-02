package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> bookList;

    public void initial(){
        Book book1= new Book("Clean code","BookList","sun",1990);
        Book book2= new Book("winds","BookList","sun",1990);
        bookList= new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);

        System.out.println("Welcome to Biblioteca!");
        System.out.println("Select number :");
        System.out.println("1.get booklist");
        System.out.println("2.return book");
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please input a number:");
            int selectedNumber = in.nextInt();
            if (selectedNumber == 1) {
                searchBookList();
            }
            if (selectedNumber == 2) {
                returnBook();
            } else {
                System.out.println("reenter a number:");
            }
        }

    }
    public void searchBookList(){


    }


    public List<Book> returnBook(){
        return bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
