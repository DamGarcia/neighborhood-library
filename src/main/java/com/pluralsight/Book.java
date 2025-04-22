package com.pluralsight;

// Book class
public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;


    // constructor method that allows us to create an instance of obj Book
    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {

        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    // methods
    public void checkOut( String name){ // this method is void because it's only printing something
       // add a verifiable statement to see if book is already checked out
        isCheckedOut = true; // only works in this method because there is no other instance of 'isCheckedOut'
        this.checkedOutTo = name; // so both statements work but "this." references the variable "checkedOutTo"
        // that is specific to the class named checkedOutTo

    }

    public void checkIn(){ // when the method is incomplete, its called a method stub
        this.checkedOutTo = "";
        this.isCheckedOut = false;

    }


    // getters&setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
}
