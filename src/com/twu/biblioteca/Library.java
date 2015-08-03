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


    public void initial(){
        Book book1= new Book(1,"Clean code","BookList","sun",1990);
        Book book2= new Book(2,"winds","BookList","sun",1990);
        basicBookList = new ArrayList<>();
        currentBookList= new ArrayList<>();
        basicBookList.add(book1);
        basicBookList.add(book2);
        currentBookList.add(book1);
        currentBookList.add(book2);
        Customer customer= new Customer();

        System.out.println("Welcome to Biblioteca!");
        while(true) {
            System.out.println("Select number :");
            System.out.println("1.get booklist");
            System.out.println("2.return book");
            int selectedNumber = InputUtil.getInputNum();
            if (selectedNumber == 1) {
                String cate = getCategory();
                if(cate.equals("Quit")){
                    continue;
                }
                searchBookList(cate);
                System.out.println("If you want to quit enter zero,else to continue.");
                if(InputUtil.getInputNum()==0){
                    continue;
                }else
                {
                    System.out.println("choose the book you want:");
                    int booknum=InputUtil.getInputNum()-1;
                    Book wanttoBorrowBook = getCurrentBookList().get(booknum);
                    checkoutBook(wanttoBorrowBook, customer);

                }
            }else if (selectedNumber == 2) {
                returnBook(customer);
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
            cate="Quit";
        }
        else{
            System.out.println("Select a valid option!");
        }
        return cate;
    }

    public void searchBookList(String category){
        System.out.println("*******************************************");
        System.out.println("No         Name       Author     PublishedYear");
        int i=1;
        if (category=="ALL"){
            for(Book book : currentBookList)
            {
                System.out.println(i+"  "+ book.getName() + "  " + book.getAuthor() + "  " + book.getPublishedYear());
                i++;
            }
        }else {
            for (Book book : currentBookList) {
                if (book.getCategory() == category)
                {
                    System.out.println(i +"   "+book.getName() + "  " + book.getAuthor() + "  " + book.getPublishedYear());
                    i++;
                }
            }
        }
    }


    public void checkoutBook(Book book,Customer customer){
        if (getCurrentBookList().contains(book))
        {
            getCurrentBookList().remove(book);
            customer.borrowedBookList.add(book);
            System.out.println("Thank you! Enjoy the book");
        }
        else {
            System.out.println("That book is not available.");
        }
    }

    public void returnBook(Customer customer){
        System.out.println("**********"+customer.getName()+"'bookList *************************");
        System.out.println("No       Name         Author    PublishedYear");
        int i =1;
        for(Book bookitem:customer.getBorrowedBookList())
        {
            System.out.println(i +"  "+ bookitem.getName() + "  " + bookitem.getAuthor() + "  " + bookitem.getPublishedYear());
            i++;
        }
        System.out.println("which one do you like to return?");
        int returenedBookNum=InputUtil.getInputNum()-1;
        Book bookToReturn=customer.getBorrowedBookList().get(returenedBookNum);
        if(getBasicBookList().contains(bookToReturn))
        {
            getCurrentBookList().add(bookToReturn);
            customer.getBorrowedBookList().remove(bookToReturn);
            System.out.println("Thank you for returning the book.");
        }
        else {
            System.out.println("That is not a vaild book to return.");
        }
    }


    public List<Book> getBasicBookList() {
        return basicBookList;
    }
    public void setBasicBookList(List<Book> basicBookList) {
        this.basicBookList = basicBookList;
    }


}
