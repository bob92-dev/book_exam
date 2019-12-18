package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
	// initialize the order = > create 3 databases
        List<Users> usersList = new ArrayList<Users>();
        List<Books> booksList = new ArrayList<Books>();
        Map borrowedMap = new HashMap();
        int cmdNum =1;

        Order.init();

        // catch the order
        

    // introduction of datas of our databases in our programm

        //String firstName;
        //String name;
        //Users user = new Users(firstName, name, int day, int month, int year);







         // run the process ina boucle wheenver the exist function is not asked
        //TODO : gestion de l'exception à revoir. Ca plante.
        // TODO : voir s'il faut rajouter la booksList au CMD.
        //TODO voir pourquoi il écrit uniquement dans database et pas dans les noms de databas sespécifiées

        Order.runApp(cmdNum,usersList,booksList,borrowedMap) ;
        /*

        do {

            cmdNum = Tools.getChoice();
                try {
        Order.processCmd(cmdNum, usersList, borrowedMap);
            } catch (LibraryException message) {
                System.out.println(message);
            }
            }while (cmdNum!=2);
*/
        // test pour savoir si les données sont bien enregistrées
        //System.out.println(userslist.toString());



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

