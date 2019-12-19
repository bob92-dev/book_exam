package tools;

import objects.Books;
import objects.Borrows;
import objects.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tools {
    /**
     * this class is just there offered some usefull tools.
     *
     * @return
     */


//TODO : gestion de l'exception à vérifier
    public static int getChoice() throws Exception {

        System.out.println("\n" +
                "=> Please enter a valid command number : \n");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            choice = Integer.parseInt(sc.nextLine());
        }
        // erreur pour ceux qui laissent le champs vide
        catch (NumberFormatException enbr) {
            System.out.println("this is not a number. Please enter a number" + enbr.getCause());
        } catch (NullPointerException enp) {
            System.out.println("You write nothing ! Please enter a valid number" + enp.getCause());
        }
        // erreur pour gérer les gens qui tapent au delà du nombre maximum de commandes
        catch (IndexOutOfBoundsException e) {
            System.out.println("This number is not permitted. Please enter a valid number" + e.getCause());
        }
        // erreur voiture balais
        catch (Exception ex) {
            System.out.println("OOPS : syntax error. Please enter a valid number" + ex.getCause() + ex.getMessage() + ex.getStackTrace());
        }
        return choice;

    }

    //---------------------------------------- Scanner method  --------------------------------------------------------------------------------//

    public static int scanInt(int a) {
        Scanner sc2 = new Scanner(System.in);
        a = sc2.nextInt();
        return a;
    }

    public static String scanString(String st) {
        Scanner sc3 = new Scanner(System.in);
        st = sc3.nextLine();
        return st;
    }

//---------------------------------------- Methods to check the presence of an a element in a list  --------------------------------------------------------------------------------//

    public static boolean isSameUser(List<Users> usersList, String firstName, String name, boolean isUserTheSame) {
        for (Users user1 : usersList) {
            if (user1.getFirstName().equals(firstName) && user1.getName().equals(name)) {
                isUserTheSame = true;
                break;
            } else {
                isUserTheSame = false;
                //System.out.println("OK give us other informations");

            }
        }
        return isUserTheSame;
    }


    public static boolean isheInThirdList(List<Borrows> borrowedList, String firstName, String name, boolean isHeIn) {
        for (Borrows borrower : borrowedList) {
            if (borrower.getBorrowerFirstName().equals(firstName) && borrower.getBorrowerName().equals(name)) {
                isHeIn = true;
                return isHeIn;
            } else {
                isHeIn = false;
            }
        }
        return isHeIn;
    }


    //TODO : verifie ca
    public static boolean isTheBookInThirdList(List<Borrows> borrowedList, String bookReference, boolean isHeIn) {
        for (Borrows borrow : borrowedList) {
            if (borrow.getBookReference().equals(bookReference) && (borrow.getBorrowReturn() != null)) {
                isHeIn = true;
                break;
            } else {
                isHeIn = false;
            }
        }
        return isHeIn;
    }

    public static boolean isSameBook(List<Books> booksList, String reference, boolean isBookTheSame) {
        for (Books book1 : booksList) {
            if (book1.getReference().equals(reference)) {
                isBookTheSame = true;
                break;
            } else {
                isBookTheSame = false;
                //System.out.println("OK give us other informations");

            }
        }
        return isBookTheSame;
    }


    public static Users getSimilarReference(List<Users> usersList, String firstName, String name) {
        for (Users user1 : usersList) {
            if (user1.getFirstName().equals(firstName) && user1.getName().equals(name)) {
                return user1;
            }
        }
        return null;
    }


    public static Books getSimilarReferenceForBook(List<Books> booksList, String reference) {
        for (Books book1 : booksList) {
            if (book1.getReference().equals(reference)) {
                return book1;
            }
        }
        return null;
    }


    public static void checkReference(String reference) {
        if (reference.length() != 4) {
            System.out.println("Check your entry the reference must be one letter followed by 3 numbers");
        }

    }

    //---------------------------------------- show list element --------------------------------------------------------------------------------//


    public static void showListElement(ArrayList theList) {
        for (int i = 0; i < theList.size(); i++)
            System.out.println(theList.get(i));
    }

//---------------------------------------- Switch attribute methods  --------------------------------------------------------------------------------//


    // methods to replace one attribute if null of a book by another one
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
        /*} else {
            switch (attribute) {
                case "title":
                    newVersion.setTitle(attribute);
                    break;
                case "editorName":
                    newVersion.setEditorName(attribute);
                    break;
                case "reference":
                    newVersion.setReference(attribute);
                    break;
            }*/
        }


    /* not used:
    public static void switchBooksNullIntattributes (Books newVersion, Books OldVersion, Integer attribute){
            if (attribute == null) {
                newVersion.setPublishedYear(OldVersion.getPublishedYear());
            }
    }*/
}
//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//
