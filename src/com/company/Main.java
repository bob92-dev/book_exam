package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws LibraryException {
	// initialize and typing the order
        Order.init();
    // catch the order
    int cmdNum = Tools.getChoice();
    // instance of our database => initialisation
        Map usersMap = new HashMap();
    // run the process
        //TODO : gestion de l'exception à revoir. Ca plante.
        try {
        Order.processCmd(cmdNum, usersMap);
    }
    catch (LibraryException e) {System.out.println("this is an error()");}
// test pour savoir si ca passe dans le tostring
        System.out.println(usersMap.toString());

    }


    }

