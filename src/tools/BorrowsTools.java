package tools;

import coreSystem.Order;
import objects.Books;
import objects.Borrows;
import objects.Users;

import java.time.LocalDate;
import java.util.List;

/**
 * This class deals with all the commands applied who have an impact on our borrower database
 */


public class BorrowsTools {

    //--------------------------------------------- CREATION OF Borrowed- INPUT - IN DATABASE - COMMAND 11---------------------------------------------------------------------------------------------//

    /**
     * this function add a borrow to the borrowedlist, after checking the existence of the uqser in the list
     * @param usersList list of users
     * @param booksList list of book
     * @param borrowedList list of borrowing
     * @return list of "boorrows objects"
     */

    public static List<Borrows> createBorrow (List<Users> usersList, List<Books> booksList, List<Borrows> borrowedList) {


        String borrowerFirstName= null;
        String borrowerName=null;
        String bookReference=null;
        LocalDate borrowDate=null;
        LocalDate borrowReturn=null;
        boolean isUserExist = true;
        boolean isBookTheSame=false;

        Borrows borrows = new Borrows(borrowerFirstName, borrowerName, bookReference, borrowDate,borrowReturn);


        System.out.println("Give me the name of the borrower");
        borrowerName = Tools.scanString(borrowerName);
        borrows.setBorrowerName(borrowerName);

        System.out.println("Please give me the firtsname of the borrower: \n");
        borrowerFirstName = Tools.scanString(borrowerFirstName);
        borrows.setBorrowerFirstName(borrowerFirstName);
        // verification que l'utilisateur existe
        isUserExist= Tools.isSameUser(usersList, borrowerFirstName, borrowerName, isUserExist);
        if (isUserExist == false) {
            System.out.println("This user dosen't exist in our database. Go to help menu");
            Order.runApp(1, usersList,booksList, borrowedList );
        }


        // check of the presence of a book in the database
        do {
            System.out.println("Enter the reference of the book : 1 letter followed by 3 numbers (example :B218)");
            bookReference = Tools.scanString(bookReference);
            Tools.checkReference(bookReference);
        } while (bookReference.length()!=4);

        // getout if the reference is unknown
        isBookTheSame = Tools.isSameBook(booksList, bookReference, isBookTheSame);

        if (isBookTheSame == false) {
            System.out.println("This book is not in our database.");
            Order.runApp(1, usersList, booksList, borrowedList);
        }

        //check the status of our reference => borrowed or not borrowed
        if (Tools.getBorrowStatus(borrowedList,bookReference)=="used") {
            System.out.println("This book is already borrowed.");
            Order.runApp(1, usersList, booksList, borrowedList);
            }

        LocalDate dateChosen =  Tools.chooseDateForMe();
        borrows.setBorrowDate(dateChosen);
        System.out.println(borrows);
        borrowedList.add(borrows);
        System.out.println("The borrowed list contains : "+ borrowedList);

        // add the new table to our database
        FilesHandler f = new FilesHandler();
        f.writeInFile(borrowedList, "borrowersDatabase");
        return borrowedList;

    }

    //--------------------------------------------- CREATION OF Borrowed- INPUT - IN DATABASE - COMMAND 11---------------------------------------------------------------------------------------------//
//No time to finish that so i've prefered to let it commented, so as to preserve the application integrity. Et bonnes vacances Romu !
/*
    public static List<Borrows> endBorrow (List<Users> usersList, List<Books> booksList, List<Borrows> borrowedList) {


        String borrowerFirstName = null;
        String borrowerName=null;
        String bookReference=null;
        LocalDate borrowDate=null;
        LocalDate borrowReturn=null;
        boolean isBookReferenceIn = true;
        boolean isBookTheSame=false;


        Borrows borrows = new Borrows(borrowerFirstName, borrowerName, bookReference, borrowDate,borrowReturn);

// dtep 1 : check if is it in the third table
        do {
            System.out.println("Enter the reference of the book : 1 letter followed by 3 numbers (example :B218)");
            bookReference = Tools.scanString(bookReference);
            Tools.checkReference(bookReference);
        } while (bookReference.length()!=4);


        Tools.isTheBookInThirdList(borrowedList, bookReference,isBookReferenceIn);
        if (isBookReferenceIn==false){
        System.out.println("This book is not in our database.");
        Order.runApp(1, usersList, booksList, borrowedList);
        }

        if (Tools.getBorrowStatus(borrowedList,bookReference)=="not used") {
            System.out.println("This book is not in the borrowed database.");
            Order.runApp(1, usersList, booksList, borrowedList);
        }
    }*/
}

    //--------------------------------------------- END OF CLASS ---------------------------------------------------------------------------------------------//



