package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> basicBookList;

    public List<Book> getCurrentBookList() {
        return currentBookList;
    }

    public void setCurrentBookList(List<Book> currentBookList) {
        this.currentBookList = currentBookList;
    }

    private List<Book> currentBookList;
    //private Customer customer;

    public void initial(){
        Book book1= new Book(1,"Clean code","BookList","sun",1990);
        Book book2= new Book(2,"winds","BookList","sun",1990);
        basicBookList = new ArrayList<>();
        currentBookList= new ArrayList<>();
        basicBookList.add(book1);
        basicBookList.add(book2);
        currentBookList.add(book1);
        currentBookList.add(book2);

        System.out.println("Welcome to Biblioteca!");
        System.out.println("Select number :");
        System.out.println("1.get booklist");
        System.out.println("2.return book");
        while(true) {
            int selectedNumber = InputUtil.getInputNum();
            if (selectedNumber == 1) {
                String cate = getCategory();
                searchBookList(cate);
                System.out.println("choose the book you want:");
                int bookID=InputUtil.getInputNum();
                checkoutBook(bookID);
            }else if (selectedNumber == 2) {
                returnBook();
            } else {
                System.out.println("reenter a number:");
            }
        }

    }

    private String getCategory() {
        System.out.println("choose the category you want:");
        System.out.println("1.BookList");
        System.out.println("2.ALL");
        System.out.println("0.Quit");
        int selectedcategory = InputUtil.getInputNum();
        String cate="ALL";
        if(selectedcategory==1)
        {
            cate="BookList";
        }else if(selectedcategory==0){
            cate="ALL";
        }
        else{
            System.out.println("Select a valid option!");
        }
        return cate;
    }

    public void searchBookList(String category){
        System.out.println("***********************************");
        System.out.println("Book ID     Name     Author   PublishedYear");
        if (category=="All"){
            for(Book book : currentBookList)
            {System.out.println(book.getBookID()+"  "+ book.getName() + "  " + book.getAuthor() + "  " + book.getPublishedYear());}
        }else {
            for (Book book : currentBookList) {
                if (book.getCategory() == category)
                    System.out.println(book.getBookID()+"   "+book.getName() + "  " + book.getAuthor() + "  " + book.getPublishedYear());
            }
        }
    }

    public void checkoutBook(int bookID){

        for(Book book :currentBookList){
            if (book.getBookID()==bookID)
            currentBookList.remove(book);
            System.out.println("Thank you! Enjoy the book");
        }
    }

    public List<Book> returnBook(){
        System.out.println("");

        return basicBookList;
    }

    public List<Book> getBasicBookList() {
        return basicBookList;
    }

    public void setBasicBookList(List<Book> basicBookList) {
        this.basicBookList = basicBookList;
    }


}
