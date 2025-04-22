package com.pluralsight;


import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Book[] library = getPopulatedLibrary();


//        Book book = new Book(1, "asfg", "this is a title");
//
//        book.checkOut("Damian"); // when calling a method, make sure to mention the instance
//        // of the object that has those methods - in this case: object book | method .checkOut

        ShowHomeScreen();

    }

    private static Scanner scanner = new Scanner(System.in);



    private static Book[] library = getPopulatedLibrary(); // will allow the array we created
    // to be assigned to the value in library and is set to the value of
    // the return of getPopulatedLibrary() | is available anywhere within Main

    // this method is NOT within the Book.java because this method is referencing the library (multiple books)
    // the Book.java is only looking to control the behavior of a singular book
    private static Book[] getPopulatedLibrary(){

        Book[] library = new Book[20]; // creating a new instance of an array from the object Book and saving it in library

        library[0] = new Book(1, "ISBN 978-0-261-10236-9", "The Fellowship of the Ring");
        library[1] = new Book(2, "ISBN 978-0-261-10237-6", "The Two Towers");
        library[2] = new Book(3, "ISBN 978-0-261-10238-3", "The Return of the King");
        library[3] = new Book(4, "ISBN 978-0-553-57340-4", "A Game of Thrones");
        library[4] = new Book(5, "ISBN 978-0-553-57990-1", "A Clash of Kings");
        library[5] = new Book(6, "ISBN 978-0-553-10663-3", "A Storm of Swords");
        library[6] = new Book(7, "ISBN 978-0-06-447104-6", "Eragon");
        library[7] = new Book(8, "ISBN 978-0-06-089876-2", "Eldest");
        library[8] = new Book(9, "ISBN 978-0-06-089879-3", "Brisingr");
        library[9] = new Book(10, "ISBN 978-0-06-202406-0", "Inheritance");
        library[10] = new Book(11, "ISBN 978-1-250-30718-4", "The Name of the Wind");
        library[11] = new Book(12, "ISBN 978-0-7564-0407-9", "The Wise Man's Fear");
        library[12] = new Book(13, "ISBN 978-0-06-112241-5", "The Lion, the Witch and the Wardrobe");
        library[13] = new Book(14, "ISBN 978-0-06-447105-3", "Prince Caspian");
        library[14] = new Book(15, "ISBN 978-0-06-623850-0", "The Horse and His Boy");
        library[15] = new Book(16, "ISBN 978-0-06-447106-0", "The Silver Chair");
        library[16] = new Book(17, "ISBN 978-0-06-447107-7", "The Last Battle");
        library[17] = new Book(18, "ISBN 978-0-316-01724-4", "The Final Empire");
        library[18] = new Book(19, "ISBN 978-0-316-01725-1", "The Well of Ascension");
        library[19] = new Book(20, "ISBN 978-0-316-01726-8", "The Hero of Ages");

        return library;
    }

    private static void ShowHomeScreen(){
        String homeScreenPrompt = "Welcome to the Library! \n" +
                "Please select an option from the following: \n" +
                "   1 - Show Available Books \n  " +
                "   2 - Show Checked Out Books \n  " +
                "   0 - Exit library \n  " +
                "(1, 2, 0):";

        int option;
        do{ // here we choose a do/while loop because we want this to run at least once
            // because we want the print statement to print
            // this will rerun the display until the option is 0
            System.out.println(homeScreenPrompt);
            option = scanner.nextInt();
            scanner.nextLine(); // remove crlf
            if (option == 1){
                ShowAvailableBooksScreen();
            } else if(option == 2){
                ShowCheckedOutBooksScreen();
            } else if(option == 0){
                System.out.println("Exiting the library, have a nice day!");
            } else{
                System.out.println("Error! Not a valid option. Please try again!");
            }
        } while(option != 0);
    }

    private static void ShowAvailableBooksScreen(){
        System.out.println("... todo available books menu here");
    }

    private static void ShowCheckedOutBooksScreen(){
        System.out.println("...todo checked out books screen");
    }


}