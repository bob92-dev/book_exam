package com.company;


import java.util.Scanner;

public class Order {

    /**
     * initialization of our programm. No return. Order the help function
      */
    public static void init() {

            System.out.println(
                            "                          |---------------------------------------|\n" +
                            "                          |  WELCOME  TO OUR LIBRARY APPLICATION  |\n" +
                            "                          |---------------------------------------|");


            Order.help();
        System.out.println( "\n"+
                "=> Please enter a command : \n");
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


    // this function make the bridge between the typing and the process
    public static void processCmd (int cmdNumber){

           // TODO : faire le try catch comme demandé dans le backlog des commandes
           //try {
               switch (cmdNumber) {
                   case 1 :
                       System.out.println("help case ");
                       //TODO  lister toutes les commandes de l'application
                        Order.help();
                   //case 2 : etc.

               }

            }
           //catch (Exception ex){
             //  throw new LibraryException();
             //
           //}







}
