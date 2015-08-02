package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;
public class Customer {
    String name;
    List<Book> borrowedBookList= new ArrayList<>();
    public void checkoutBook(Book book){

        borrowedBookList.add(book);
        System.out.println("Thank you! Enjoy the book");
    }


    public List<Book> getBorrowedBookList() {
        return borrowedBookList;
    }

    public void setBorrowedBookList(List<Book> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }
}
