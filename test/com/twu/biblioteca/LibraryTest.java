package com.twu.biblioteca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {
    Library bibloteca;
    @Before
    public void setUp() throws Exception {
        bibloteca= new Library();


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shoud_get_welcome_when_get_ready(){
        bibloteca .initial();

        assertEquals(2,bibloteca.getBasicBookList().size());
    }
    @Test
    public void should_delete_book_when_checkout(){
        Book book1= new Book(1,"Clean code","BookList","sun",1990);
        Book book2= new Book(2,"winds","BookList","sun",1990);
        List<Book> bookList= new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        Customer c1= new Customer();
        bibloteca.setCurrentBookList(bookList);

        bibloteca.checkoutBook(book1, c1);

        assertEquals(1, bibloteca.getCurrentBookList().size());
        assertEquals(1,c1.getBorrowedBookList().size());
    }
    @Test
    public void should_add_book_when_return(){
        Book book1= new Book(1,"Clean code","BookList","sun",1990);
        Book book2= new Book(2,"winds","BookList","sun",1990);
        List<Book> bookList= new ArrayList<>();
        List<Book> currentBookList= new ArrayList<>();
        List<Book> borrowedBookList= new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        currentBookList.add(book2);
        bibloteca.setBasicBookList(bookList);
        bibloteca.setCurrentBookList(currentBookList);

        borrowedBookList.add(book1);
        Customer c1= new Customer();
        c1.setBorrowedBookList(borrowedBookList);

        bibloteca.returnBook(c1);

        assertEquals(2, bibloteca.getCurrentBookList().size());
        assertEquals(0,c1.getBorrowedBookList().size());
    }






}