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

        //il faut relier les database crées enb init aux arrylist

         // run the process ina boucle wheenver the exist function is not asked
        //TODO : gestion de l'exception à revoir. Ca plante.
        // TODO : voir s'il faut rajouter la booksList au CMD.
        //TODO voir pourquoi il écrit uniquement dans database et pas dans les noms de databas sespécifiées

        Order.runApp(cmdNum,usersList,booksList,borrowedMap) ;

        Order.endApp(usersList,booksList,borrowedMap);


    }

}

