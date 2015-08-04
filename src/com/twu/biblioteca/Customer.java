package com.twu.biblioteca;
import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.bean.Item;

import java.util.ArrayList;
import java.util.List;
public class Customer {

    String name;
    String emailAddress;
    int phone;
    String passWord;
    String libraryNum;

    List<Item> borrowedItemList= new ArrayList<>();
    public Customer(){}

    public Customer(String name,String emailAddress,int phone,String libraryNum,String passWord)
    {
        this.name= name;
        this.emailAddress=emailAddress;
        this.phone=phone;
        this.passWord=passWord;
        this.libraryNum=libraryNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Item> getBorrowedItemList() {
        return borrowedItemList;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setBorrowedItemList(List<Item> borrowedItemList) {
        this.borrowedItemList = borrowedItemList;
    }
    public String getLibraryNum() {
        return libraryNum;
    }

    public void setLibraryNum(String libraryNum) {
        this.libraryNum = libraryNum;
    }
}
