package com.twu.biblioteca;

import com.twu.biblioteca.Util.InputUtil;
import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.bean.Item;
import com.twu.biblioteca.bean.Movie;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> basicBookList;
    private List<Item> basicMovieList;
    private List<Item> currentBookList;
    private List<Item> currentMovieList;
    private List<Customer> customerList;

    public void initial() throws Exception {
        Item book1= new Book("Clean code","BookList","sun",1990);
        Item book2= new Book("winds","BookList","sun",1990);
        Item movie1= new Movie("Yunshuiyao","Movie","sun",1990,1);
        Customer customer1= new Customer("test1","123@qq.com",12345,"001-0001","1234");
        Customer customer2= new Customer("test2","123@qq.com",12345,"001-0002","1254");
        customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        basicBookList = new ArrayList<>();
        currentBookList = new ArrayList<>();
        basicMovieList = new ArrayList<>();
        currentMovieList = new ArrayList<>();
        basicBookList.add(book1);
        basicBookList.add(book2);
        basicMovieList.add(movie1);
        currentBookList.add(book1);
        currentBookList.add(book2);
        currentMovieList.add(movie1);



        System.out.println("Welcome to Biblioteca!");
        while(true) {
            Customer customer= new Customer();;
            System.out.println("Please Login ");
            System.out.println("library number:");
            String libraryNum = InputUtil.getInputString();
            System.out.println("Pssword:");
            String psssword = InputUtil.getInputString();
            int customerNum = customerList.size();
            for (int i = 0; i <= customerNum; i++) {
                if (i == customerNum) {
                    System.out.println("customer not exist! try again");

                }
                if (customerList.get(i).getLibraryNum().equals(libraryNum) || customerList.get(i).getPassWord().equals(psssword)) {
                    System.out.println("Success login!");
                    customer=customerList.get(i);
                    break;
                }
            }

            System.out.println("Select number :");
            System.out.println("1.get itemlist");
            System.out.println("2.return item");
            System.out.println("3.my profile");
            int selectedNumber = InputUtil.getInputNum();
            if (selectedNumber == 1) {
                String cate = getCategory();
                if(cate.equals("Quit")){
                    continue;
                }
                getDetailsList(cate);
                System.out.println("If you want to quit enter zero,else to continue.");
                if(InputUtil.getInputNum()==0){
                    continue;
                }else
                {
                    if (cate.equals("BookList")){
                        Item wanttoBorrowBook = selectItem(cate);
                        checkoutItem(wanttoBorrowBook,customer);
                    }
                    if(cate.equals("Movie")){
                        Item wanttoBorrowItem = selectItem(cate);
                        checkoutItem(wanttoBorrowItem,customer);
                    }
                }
            }else if (selectedNumber == 2) {
                returnItem(customer);
            } else if (selectedNumber == 3){
                showCustomerInfo(customer);
            }else {
                System.out.println("The number is wrong, please reenter a number:");
            }
        }
    }

    private String getCategory() {
        System.out.println("choose the category you want:");
        System.out.println("1.BookList");
        System.out.println("2.Movie");
        System.out.println("0.Quit");
        int selectedcategory = InputUtil.getInputNum();
        String cate="ALL";
        if(selectedcategory==1)
        {
            cate="BookList";
        }else if(selectedcategory==2)
        {
              cate = "Movie" ;
         }else if(selectedcategory==0){
            cate="Quit";
        }
        else{
            System.out.println("Select a valid option!");
        }
        return cate;
    }

    public void getDetailsList(String category){

        int i=1;
        if (category.equals("BookList"))
        {
            System.out.println("*************** Book ****************************");
            System.out.println("No         Name       Author     PublishedYear");
            for (Item book : currentBookList)
            {
                    book.printInfo(i);
                    i++;
            }
        }else if (category.equals("Movie"))
        {
            System.out.println("***************** Movie **************************");
            System.out.println("No         Name       Author     Year    Rating");
            for(Item movie : currentMovieList)
            {
                    movie.printInfo(i);
                    i++;
            }
        }
    }

    private Item selectItem(String cate) {
        List<Item> targetList=new ArrayList<>();

        if(cate.equals("BookList"))
        {
            targetList=getCurrentBookList();
        }
        else{
            targetList=getCurrentMovieList();
        }
        System.out.println("choose the one you want:");
        int itemNum= InputUtil.getInputNum();
        if(itemNum > targetList.size()){
            System.out.println("That Number is not available.");
        }
        itemNum--;
        return targetList.get(itemNum);
    }

    public void checkoutItem(Item item, Customer customer){
        if (item.getCategory().equals("BookList")){
            getCurrentBookList().remove(item);
            customer.borrowedItemList.add(item);
            System.out.println("Thank you! Enjoy !");
        }
        else if(item.getCategory().equals("Movie"))
        {
            getCurrentMovieList().remove(item);
            customer.borrowedItemList.add(item);
            System.out.println("Thank you! Enjoy!");
        }

    }

    public void returnItem(Customer customer){
        System.out.println("**********"+customer.getName()+"'List *************************");
        System.out.println("No       Name       Author    Year");
        int i =1;
        for(Item item1:customer.getBorrowedItemList())
        {
            item1.printInfo(i);
            i++;
        }
        System.out.println("which one do you like to return?");
        int returenedItemNum=InputUtil.getInputNum()-1;
        Item itemToReturn=customer.getBorrowedItemList().get(returenedItemNum);
        if (itemToReturn.getCategory().equals("BookList"))
        {
            getCurrentBookList().add(itemToReturn);
            customer.getBorrowedItemList().remove(itemToReturn);
            System.out.println("Thank you for returning.");
        } else if(itemToReturn.getCategory().equals("Movie"))
        {
            getCurrentMovieList().add(itemToReturn);
            customer.getBorrowedItemList().remove(itemToReturn);
            System.out.println("Thank you for returning.");

        }else
        {
            System.out.println("That is not a vaild item to return.");
        }
    }

    public void showCustomerInfo(Customer customer){
        System.out.println("library number       name      email        phone");
        System.out.println(customer.getLibraryNum()+"    "+customer.getName()+"  "+customer.getEmailAddress() +"  "+ customer.getPhone());
    }


    public List<Item> getCurrentMovieList() {
        return currentMovieList;
    }

    public void setCurrentMovieList(List<Item> currentMovieList) {
        this.currentMovieList = currentMovieList;
    }

    public List<Item> getBasicBookList() {
        return basicBookList;
    }

    public void setBasicBookList(List<Item> basicBookList) {
        this.basicBookList = basicBookList;
    }

    public List<Item> getBasicMovieList() {
        return basicMovieList;
    }

    public void setBasicMovieList(List<Item> basicMovieList) {
        this.basicMovieList = basicMovieList;
    }

    public List<Item> getCurrentBookList() {
        return currentBookList;
    }

    public void setCurrentBookList(List<Item> currentBookList) {
        this.currentBookList = currentBookList;
    }



}
