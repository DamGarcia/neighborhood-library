package com.pluralsight;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Book[] library = getPopulatedLibrary();
        // creates the variable 'library' that holds the value of Book[] library
        // which holds the value of getPopulatedLibrary()


//        Book book = new Book(1, "asfg", "this is a title");
//
//        book.checkOut("Damian"); // when calling a method, make sure to mention the instance
//        // of the object that has those methods - in this case: object book | method .checkOut

        ShowHomeScreen();

    }

    private static Scanner scanner = new Scanner(System.in);


    private static Book[] library = getPopulatedLibrary(); // will allow the array we created
    // to be assigned to the variable library and is set to the value of
    // the return of getPopulatedLibrary() | is available anywhere within Main

    // this method is NOT within the Book.java because this method is referencing the library (multiple books)
    // the Book.java is only looking to control the behavior of a singular book
    private static Book[] getPopulatedLibrary() {

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

    private static void ShowHomeScreen() {
        String homeScreenPrompt = "Welcome to the Library! \n"
                + "Please select an option from the following: \n"
                + "1 - Show Available Books \n"
                + "2 - Show Checked Out Books \n"
                + "0 - Exit library \n"
                + "(1, 2, 0):";

        int option;
        do { // here we choose a do/while loop because we want this to run at least once
            // because we want the print statement to print
            // this will rerun the display until the option is 0
            System.out.println(homeScreenPrompt);
            option = scanner.nextInt();
            scanner.nextLine(); // remove crlf
            switch(option){
                case 1: ShowAvailableBooksScreen();
                    break;
                case 2: ShowCheckedOutBooksScreen();
                    break;
                case 0: System.out.println("Exiting the library! Have a nice day!");
                    break;
                default:
                    System.out.println("Not a valid option. Please try again!");
            }
        } while (option != 0);
    }

    private static void ShowAvailableBooksScreen() {
        int choice;
        do {
            // prompt user to check out book or exit to home screen
            System.out.println("[1] Would you like to check out a book? \n"
                    + "[2] or exit to home screen?");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Here is a list of available books: \n");
                    // for each instance of book in library, we are checking if the book is available
                    // if the book does not return null and is not false
                    for(Book book : library){
                        if (book != null && !book.isCheckedOut()){
                            System.out.println(book);
                        }
                    }

                    // prompt user to enter book ID to select
                    System.out.print("Please enter the book ID to select it: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();

                    // we are creating this variable to hold user input and check through
                    // the getBooksByID method whether the book ID matches one in the library array
                    Book selectedBook = getBooksById(library, bookID);

                    // prompt user for name to save within the isCheckedOut && isCheckedOut methods
                    // using the Book variable selectedBook
                    String name;
                    System.out.print("Please enter your name for check out: ");
                    name = scanner.nextLine();

                    System.out.printf("Thank you %s, you have checked out: %s", name, selectedBook);

                    // calling the Book variable method checkOut will alter the necessary switches within
                    // that method that tells the computer to alter the library array element the user selected
                    // the selectedBook will now be unavailable in the list of books
                    selectedBook.checkOut(name);

                case 2: ShowHomeScreen();
                    break;
                default:
                    System.out.println("Invalid entry. Please enter a numerical value shown.");
            }
        } while (choice!= 2);
        System.out.println("Sorry, invalid input taken! Please try again!");
    }

    private static void ShowCheckedOutBooksScreen() {
        System.out.println("Books currently checked out: \n");
        int bookCheckOut = 0; // adding loop counter to hold the number of books within the array that are checked out

        for(Book book : library){
            // for each iteration within array library, if a book.isCheckedOut() == true;
            // the print statement will run and increase the counter which can be used to check
            // if there are books checked out
            if(book.isCheckedOut()){
                System.out.println(book + " is checked out by " + book.getCheckedOutTo());
                bookCheckOut ++;
            }
        }

        if(bookCheckOut > 0) { // using loop counter to determine how many books in the array are checked out
            // prompt user to check in a book or go back to home screen
            String checkOutPrompt = "[C] Check in a book" +
                    " [X] Go back to home screen";

            System.out.println(checkOutPrompt);
            String choice = scanner.nextLine().trim().toUpperCase(); // .trim() tells the computer to ignore
            // any whitespace or Enter the user inputs
            // .toUpperCase() changes the user input specifically to UpperCase as that matches the options provided
            // while keeping in mind user error


            switch (choice){
                case "C": // now that we altered the user input directly, we can use a switch statement instead of
                    // checking if the 'choice' equalsIgnoreCase("C")
                    System.out.println("Please enter the id number of the book you'd like to return");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();

                    if(bookID > 0 && bookID <= library.length){ // this if statement checks whether the bookID
                        // the user entered would match an index of a book within the length of library
                        Book checkedOutBook = library[bookID - 1]; // we are creating this Book variable
                        // to hold the index of library that matches the bookID the user entered
                        // ( adding -1) accounts for user input not matching index cases within computer
                        if(checkedOutBook.isCheckedOut()){ // checks if the checkedOutBook is actually checked out
                            System.out.printf("Thank you %s, %d %s has been checked in \n\n"
                                    , checkedOutBook.getCheckedOutTo()
                                    , checkedOutBook.getId()
                                    , checkedOutBook.getTitle());
                            checkedOutBook.checkIn(); // the .checkIn method switches the cases within that method
                            // so the checkedOutBook will now be available within the library array
                        }
                    }
                case "X": // same reason as case "C"
                    return;

                default:
                    System.out.println("Invalid entry. Please try again!");
            }
        } else{System.out.println("There are currently no books checked out");}
    }

    private static Book getBooksById(Book[] library, int id){
        for(Book book : library){
            if(book.getId() == id)
            return book;
        }
        return null;
    }
}