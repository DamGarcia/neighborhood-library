package com.pluralsight;

// Book class
public class Book {

    // data within the Class Object is private (we don't want it to be accessed outside of methods)
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;


    // constructor method that allows us to create an instance of obj Book
    public Book(int id, String isbn, String title) {

        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
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

    public boolean isCheckedOut() { // removed the  setter for isCheckedOut
        // because we don't want a user altering whether isCheckedOut is true/false
        // there is a separate method for that process
        return isCheckedOut;
    }

    public String getCheckedOutTo() { // removed the setter for checkedOutTo because there is a specific method
        // to alter this variable, and we don't want the User to be able to change the variable
        return checkedOutTo;
    }


    // for the action within a method, what is the data needed to ask and complete that task?
    // that data is added within a parameter
    // methods
    // this method is to be called when we are checking out a book
    public void checkOut( String name){ // this method is void because it's only printing something
        // add a verifiable statement to see if book is already checked out
        isCheckedOut = true; // only works in this method because there is no other instance of 'isCheckedOut'
        this.checkedOutTo = name; // so both statements work but "this." references the variable 'checkedOutTo'
        // that is specific to the Book class variable 'checkedOutTo'
        // using '.this' is to be ultra specific, standard use
    }

    // this method is to be called when we check in a book
    public void checkIn(){ // when the method is incomplete, it's called a method stub - nothing within brackets
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public String toString(){
        return String.format("%d, %s, %s \n"
        , this.getId()
        , this.getIsbn()
        , this.getTitle());
    }
}
