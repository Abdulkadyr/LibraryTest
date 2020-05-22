package OOP.LibraryManagementSystem;


import java.util.ArrayList;

public class Book {
    private int id;
    private String name;
    private String author;
    private boolean inStock;
    private Reader user;

    private ArrayList<Book> bookArrayList;


    public Book(int id, String name, String author, boolean inStock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.inStock = inStock;
    }

    public Book(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public Book() {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Reader getUser() {
        return user;
    }

    public void setUser(Reader user) {
        this.user = user;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

}
