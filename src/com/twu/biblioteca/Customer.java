package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;
public class Customer {

    String name;
    List<Book> borrowedBookList= new ArrayList<>();


   /* public void checkoutBook(Book book,Library library){
        if (library.getCurrentBookList().contains(book))
        {
                library.getCurrentBookList().remove(book);
                this.borrowedBookList.add(book);
            System.out.println("Thank you! Enjoy the book");
        }
        else {
            System.out.println("That book is not available.");
        }
    }

    public void returnBook(Library library){
        System.out.println("***********************************");
        System.out.println("Book ID     Name     Author   PublishedYear");
        for(Book bookitem:borrowedBookList)
        {
            {System.out.println(bookitem.getBookID()+"  "+ bookitem.getName() + "  " + bookitem.getAuthor() + "  " + bookitem.getPublishedYear());}
        }
        System.out.println("which one do you like to return?");
        int returenedBookNum=InputUtil.getInputNum()-11;
        if(library.getBasicBookList().contains(borrowedBookList.get(returenedBookNum)))
        {
            library.getCurrentBookList().add(borrowedBookList.get(returenedBookNum));
            borrowedBookList.remove(borrowedBookList.get(returenedBookNum));
            System.out.println("Thank you for returning the book.");
        }
        else {
            System.out.println("That is not a vaild book to return.");
        }

    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Book> getBorrowedBookList() {
        return borrowedBookList;
    }

    public void setBorrowedBookList(List<Book> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }
}
