package tools;

import objects.Books;
import objects.Borrows;
import objects.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * this class is just there offered some usefull tools.
 *
 *
 */
public class Tools {

    //---------------------------------------- Scanner method  --------------------------------------------------------------------------------//

    /**
     * This function catches the user choice when the help menu is printed.
     * It is used only in the order class. It is the crossroad of our application : all the functionalities ordered are treated here.
     * @return int because
     * @throws Exception
     */
    public static int getChoice() throws Exception {

        System.out.println("\n" +
                "=> Please enter a valid command number : \n");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            choice = Integer.parseInt(sc.nextLine());
        }
        // to avoid missing statement
        catch (NumberFormatException enbr) {
            System.out.println("this is not a number. Please enter a number" + enbr.getCause());
        } catch (NullPointerException enp) {
            System.out.println("You write nothing ! Please enter a valid number" + enp.getCause());
        }
        // to be sure that users don't type too high or low numbers
        catch (IndexOutOfBoundsException e) {
            System.out.println("This number is not permitted. Please enter a valid number" + e.getCause());
        }
        // to avoid non treated exceptions
        catch (Exception ex) {
            System.out.println("OOPS : syntax error. Please enter a valid number" + ex.getCause() + ex.getMessage() + ex.getStackTrace());
        }
        return choice;

    }

    //---------------------------------------- Scanner method  --------------------------------------------------------------------------------//

    /**
     * scanner method to scan an int value. Used regularly in this app.
     * @param a to reinitialize the inner parameter
     * @return int value
     */
    public static int scanInt(int a) {
        Scanner sc2 = new Scanner(System.in);
        a = sc2.nextInt();
        return a;
    }

    /**
     * scanner method to scan an int value. Used regularly in this app.
     * @param st string
     * @return string
     */
    public static String scanString(String st) {
        Scanner sc3 = new Scanner(System.in);
        st = sc3.nextLine();
        return st;
    }

//---------------------------------------- Methods to check the presence of an a element in a list  --------------------------------------------------------------------------------//

    /**
     * this method checks the presence of a user in the userList thanks to a "for each" loop
     * @param usersList list of users
     * @param firstName list of firstname sof users
     * @param name list of names
     * @param isUserTheSame boolean
     * @return boolean isUserThesame => true means the user was detetced in the list during the loop
     */

    public static boolean isSameUser(List<Users> usersList, String firstName, String name, boolean isUserTheSame) {
        for (Users user1 : usersList) {
            if (user1.getFirstName().equals(firstName) && user1.getName().equals(name)) {
                isUserTheSame = true;
            } else {
                isUserTheSame = false;
                //System.out.println("OK give us other informations");

            }
        }
        return isUserTheSame;
    }

    /**
     * This method is called to check if a user is in the list of borrowers.
     * @param borrowedList list of borrowed books
     * @param firstName list of first name of the users
     * @param name list of name of the users
     * @param isHeIn boolean
     * @return boolean
     */


    public static boolean isheInThirdList(List<Borrows> borrowedList, String firstName, String name, boolean isHeIn) {
        for (Borrows borrower : borrowedList) {
            if ((borrower.getBorrowerFirstName().equals(firstName)) && (borrower.getBorrowerName().equals(name))) {
                isHeIn = true;
                return isHeIn;
            } else {
                isHeIn = false;
            }
        }
        return isHeIn;
    }


    /**
     * Method that check if a book is in the list of borrowers.
     * @param borrowedList list of borrowed books
     * @param bookReference list of first name of reference
     * @param isHeIn boolean
     * @return boolean
     */
    public static boolean isTheBookInThirdList(List<Borrows> borrowedList, String bookReference, boolean isHeIn) {
        for (Borrows borrow : borrowedList) {
            if (borrow.getBookReference().equals(bookReference)) {
                isHeIn = true;
                return isHeIn;
                //break?
            } else {
                isHeIn = false;
            }
        }
        return isHeIn;
    }

    /**
     * Method that check if a book is present in a list of book thanks to a "for each" loop.
     * @param booksList list of books
     * @param reference list of reference
     * @param isBookTheSame boolean
     * @return boolean
     */

    public static boolean isSameBook(List<Books> booksList, String reference, boolean isBookTheSame) {
        for (Books book1 : booksList) {
            if (book1.getReference().equals(reference)) {
                isBookTheSame = true;
                break;
            } else {
                isBookTheSame = false;
            }
        }
        return isBookTheSame;
    }

    /**
     * This method checks the presence of a user in a list of user.
     * @param usersList list of users
     * @param firstName firstname
     * @param name name of the user
     * @return  It return the complete object user.
     */
    public static Users getSimilarReference(List<Users> usersList, String firstName, String name) {
        for (Users user1 : usersList) {
            if (user1.getFirstName().equals(firstName) && user1.getName().equals(name)) {
                return user1;
            }
        }
        return null;
    }

    /**
     * Method thaht checks if a book is in a list of books thanks to a for each loop
     * @param booksList list of books
     * @param reference unique refere of book
     * @return object book
     */

    public static Books getSimilarReferenceForBook(List<Books> booksList, String reference) {
        for (Books book1 : booksList) {
            if (book1.getReference().equals(reference)) {
                return book1;
            }
        }
        return null;
    }

    /**
     * method to know the status of a book : is he borrowed?
     * @param BorrowedList liste
     * @param reference unique reference of a book
     * @return string used or not used for borrowed or not borrowed
     */

    public static String getBorrowStatus(List<Borrows>BorrowedList, String reference) {
        for (Borrows borrowed : BorrowedList) {
            if ((borrowed.getBookReference().equals(reference))&&(borrowed.getBorrowReturn()==null)){
                return "used";
                // break?
            }
        }
        return "not used";
    }


    /**
     * check if the reference of a book entered by the user is complete : 1letter, 4 numbers
     * @param reference unique reference of a book
     */

    public static void checkReference(String reference) {
        if (reference.length() != 4) {
            System.out.println("Check your entry the reference must be one letter followed by 3 numbers");
        }

    }

    //---------------------------------------- show list element --------------------------------------------------------------------------------//

    /**
     * print all the element of a list
     * @param theList anykind of list
     */

    public static void showListElement(ArrayList theList) {
        for (int i = 0; i < theList.size(); i++)
            System.out.println(theList.get(i));
    }

//-----------------------------------------------CHOOSE DATE RANDOMELY---------------------------------------------------------------------------//

    /**
     * method to generate a date past (in 2019)
     * @return date with the type LocalDate
     */
    public static LocalDate chooseDateForMe() {
            LocalDate chooseDateForMe = LocalDate.now().minusMonths((long) (Math.random() * 10)).minusDays((long) (Math.random() * 10));
            return chooseDateForMe;
    }


//---------------------------------------- Switch attribute methods  --------------------------------------------------------------------------------//

    /**
     * methods to replace one attribute if null of a book by another one
     * @param newVersion book with updated informations
     * @param OldVersion book with not updated informations
     * @param attribute
     */

    public static void switchBookStringAttributes(Books newVersion, Books OldVersion, String attribute) {
        //if (attribute == null) {
            switch (attribute) {
                case "title":
                    newVersion.setTitle(OldVersion.getTitle());
                    break;
                case "editorName":
                    newVersion.setEditorName(OldVersion.getEditorName());
                    break;
                case "bookReference":
                    newVersion.setReference(OldVersion.getReference());
                    break;
            }

        }

}
//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//
