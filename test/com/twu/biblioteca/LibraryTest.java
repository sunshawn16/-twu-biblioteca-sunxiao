package com.twu.biblioteca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

        assertEquals(2,bibloteca.getBookList().size());
    }





}