package coreSystem;


import objects.Books;
import tools.BooksTools;
import tools.FilesHandler;
import objects.Users;
import tools.Tools;
import tools.UsersTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {

    /**
     * initialization of our programm. No return. Order the help function and create the database
     */
    public static void init() throws IOException {
        //give name at our databases. The file creater need it.
        String usersDatabase = "usersDatabase";
        String borrowersDatabase = "borrowersDatabase";
        String booksDatabase = "booksDatabase";

        System.out.println(
                "                                  |---------------------------------------|\n" +
                        "                          |  WELCOME  TO OUR LIBRARY APPLICATION  |\n" +
                        "                          |---------------------------------------|");


        Order.help();

        // creation des fichiers d'enregistrement des données
        FilesHandler file = new FilesHandler();
        file.createFile(usersDatabase);
        file.createFile(borrowersDatabase);
        file.createFile(booksDatabase);
    }


    // help command
    public static void help() {
        System.out.println("MENU : ");
        System.out.println("Enter 1 to access help"); // create and display a character
        System.out.println("Enter 2 to exit");
        System.out.println("Enter 3 to add a user");
        System.out.println("Enter 4 to edit a user");
        System.out.println("Enter 5 to remove a user");
        System.out.println("Enter 6 to list all the users");
        System.out.println("Enter 7 to add a book");
        System.out.println("Enter 8 to edit a book");
        System.out.println("Enter 9 to remove a book");
        System.out.println("Enter 10 to list all the books");
        System.out.println("Enter 11 to create a borrower");
        System.out.println("Enter 12 to finish a borrow/to end a borrow");
        System.out.println("Enter 13 to list all the books that are borrowed");
        System.out.println("Enter 14 to save");
        System.out.println("Enter 15 to restore");
        //TODO : trouver une meilleure formule pour la commande 12
        // TODO : trouver ue meilleure formulation pour la commande 13 et s'assurer qu'elle est en lien avec le code
    }


    public static void runApp(int cmdNum, List<Users> usersList, List<Books> booksList, Map borrowedMap ){

        do {

            try {
                cmdNum = Tools.getChoice();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Order.processCmd(cmdNum, usersList, booksList,borrowedMap);
            } catch (Exception message) {
                System.out.println(message);
            }
        }while (cmdNum!=2);
    }


    // this function make the bridge between the typing and the process
    public static void processCmd(int cmdNumber, List <Users> usersList, List<Books> booksList, Map borrowedMap) throws IOException {


        //try {
        switch (cmdNumber) {
            case 1:
                System.out.println("help case");
                Order.help();
                break;

            case 2:
                System.out.println("You have asked to leave the application. Thanks you. We hope you've had fun.");
                break;

            case 3:
                UsersTools.addUser(usersList, booksList, borrowedMap);
                break;

            case 4:
                UsersTools.updateList(usersList, booksList, borrowedMap);
                break;
            case 5:
                UsersTools.removeUser(usersList, booksList, borrowedMap);
            case 6:
                Tools.showListElement((ArrayList) usersList);
                break;
            case 7:
                BooksTools.addBook(usersList,booksList,borrowedMap);
                break;
            case 8:
                BooksTools.editBook(usersList,booksList,borrowedMap);
                break;
            case 9:
                BooksTools.removeBook(usersList,booksList,borrowedMap);
                break;
            case 10 :
                Tools.showListElement((ArrayList) booksList);
                break;

        }
    }


    public static void endApp (List <Users> usersList, List<Books> booksList, Map borrowedMap){
        //Inscription des données dans les databases
        FilesHandler database = new FilesHandler();
        String usersDatabase = "usersDatabase";
        String borrowersDatabase= "borrowersDatabase";
        String booksDatabase ="booksDatabase";

        database.writeInFile(usersList,usersDatabase);
        database.readFile(usersDatabase);

        database.writeInFile(booksList,booksDatabase);
        database.readFile(booksDatabase);

        database.writeInFileMap(borrowedMap,borrowersDatabase);
        database.readFile(usersDatabase);
    }
}
//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//
