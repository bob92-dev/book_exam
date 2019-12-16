package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws LibraryException, IOException {
	// initialize the order = > create a database
        Order.init();

        // catch the order
    int cmdNum = Tools.getChoice();

    // introduce data of our database in our programm
        Map usersMap = new HashMap();


    // run the process
        //TODO : gestion de l'exception à revoir. Ca plante.
        try {
        Order.processCmd(cmdNum, usersMap);
    }
    catch (LibraryException e) {System.out.println("this is an error()");}
        // test pour savoir si les données sont bien enregistrées
        //System.out.println(usersMap.toString());
        usersMap.put("babar",new Users("babar","antoine", 11,03,1983));
        FilesHandler database = new FilesHandler();
        database.writeInFile(usersMap);
        database.readFile();

    }

}

