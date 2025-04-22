package com.pluralsight;


public class Main {
    public static void main(String[] args){

        Book book = new Book(1, "asfg", "this is a title", false, "");

        book.checkOut("Damian"); // when calling a method, make sure to mention the instance
        // of the object that has those methods

    }
}