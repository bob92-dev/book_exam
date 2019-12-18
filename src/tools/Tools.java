package tools;

import objects.Books;
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


    public static boolean isSameUser(List<Users> usersList, String firstName, String name, boolean isUserTheSame) {
        for (Users user1 : usersList) {
            if (user1.getFirstName().equals(firstName) && user1.getName().equals(name)) {
                isUserTheSame = true;
            } else {
                isUserTheSame = false;
                System.out.println("OK give us other informations");

            }
        }
        return isUserTheSame;
    }

    public static boolean isSameBook(List<Books> booksList,String reference, String title, int publishedYear,String editorName, boolean isBookTheSame) {
        for (Books book : booksList) {
            if (book.getReference().equals(reference)) {
                isBookTheSame = true;
            } else {
                isBookTheSame = false;
                System.out.println("OK give us other informations");

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

    public static void showListElement (ArrayList theList){
        for(int i=0; i<theList.size(); i++)
            System.out.println(theList.get(i));
    }

}
//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//
