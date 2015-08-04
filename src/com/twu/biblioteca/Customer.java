package com.twu.biblioteca;
import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.bean.Item;

import java.util.ArrayList;
import java.util.List;
public class Customer {

    String name;
    List<Item> borrowedItemList= new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Item> getBorrowedItemList() {
        return borrowedItemList;
    }

    public void setBorrowedBookList(List<Item> borrowedItemList) {
        this.borrowedItemList = borrowedItemList;
    }
}
