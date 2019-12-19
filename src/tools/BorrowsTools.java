package tools;

import coreSystem.Order;
import objects.Books;
import objects.Borrows;
import objects.Users;

import java.util.List;

public class BorrowsTools {

    //--------------------------------------------- CREATION OF Borrowed- INPUT - IN DATABASE - COMMAND 3---------------------------------------------------------------------------------------------//


    public static List<Borrows> createBorrow (List<Users> usersList, List<Books> booksList, List<Borrows> borrowedList) {

       String borrowerFirstName="";
       String borrowerName="";
       String bookReference="";
       String borrowDate="";
       String borrowReturn="";
       boolean isUserExist = false;

        Borrows borrows = new Borrows(borrowerFirstName, borrowerName, bookReference, borrowDate, borrowReturn);

        System.out.println("Give me the name of the borrower");
        borrowerName = Tools.scanString(borrowerName);
        borrows.setBorrowerFirstName(borrowerName);

        System.out.println("Please give me the firtsname of the borrower: \n");
        borrowerFirstName = Tools.scanString(borrowerFirstName);
        borrows.setBorrowerFirstName(borrowerFirstName);
        // verification que l'utilisateur existe
        isUserExist= Tools.isSameUser(usersList, borrowerFirstName, borrowerName, isUserExist);
        if (isUserExist == false) {
            System.out.println("This user dosen't exist in our database. Go to help menu");
            Order.runApp(1, usersList,booksList, borrowedList );
        }

        // verifictaion que le livre existe

        // veriofiocation que la réference est bien tapée
        do {
            System.out.println("Enter the reference of the book : 1 letter followed by 3 numbers (example :B218)");
            bookReference = Tools.scanString(bookReference);
            Tools.checkReference(bookReference);
        } while (bookReference.length()!=4);






        // l'utilisateur exioste t il ?




        return borrowedList;

    }



}
