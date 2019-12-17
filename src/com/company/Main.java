package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
	// initialize the order = > create 3 databases
        Order.init();

        // catch the order




    // introduction of datas of our databases in our programm
        Map usersMap = new HashMap();
        Map borrowedMap = new HashMap();
        Map booksMap = new HashMap();

        // test introduction datas :

        //usersMap.put("babar", new Users("babar","antoine", 11,03,1983));



         // run the process ina boucle wheenver the exist function is not asked
        //TODO : gestion de l'exception à revoir. Ca plante.
        // TODO : voir s'il faut rajouter la booksMap au CMD.
        //TODO voir pourquoi il écrit uniquement dans database et pas dans les noms de databas sespécifiées

        int cmdNum;
        do {

            cmdNum = Tools.getChoice();
                try {
        Order.processCmd(cmdNum, usersMap, borrowedMap);
            } catch (LibraryException message) {
                System.out.println(message);
            }
            }while (cmdNum!=2);

        // test pour savoir si les données sont bien enregistrées
        //System.out.println(usersMap.toString());



        //Inscription des données dans les databases
        FilesHandler database = new FilesHandler();
        String usersDatabase = "usersDatabase";
        String borrowersDatabase= "borrowersDatabase";
        String booksDatabase ="booksDatabase";

        database.writeInFile(usersMap,usersDatabase);
        database.readFile(usersDatabase);

        database.writeInFile(borrowedMap,borrowersDatabase);
        database.readFile(usersDatabase);

        database.writeInFile(booksMap,booksDatabase);
        database.readFile(booksDatabase);

    }

}

