package coreSystem;

import objects.Books;
import objects.Users;
import objects.Borrows;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the main class of our application named "library".
 * This class is the entry point of our programm : it initialize,run, and close our application
 */



public class Main {

    public static void main(String[] args) throws Exception {
	// initialize the order = > create 3 databases
        List<Users> usersList = new ArrayList<Users>();
        List<Books> booksList = new ArrayList<Books>();
        List <Borrows> borrowedList = new ArrayList<Borrows>();

        // initialisation of the command at one to call the help
        int cmdNum =1;


        Order.init();

        //TODO il faut relier les database crées enb init aux arrylist
        // TODO run the process ina boucle wheenver the exist function is not asked

        Order.runApp(cmdNum,usersList,booksList,borrowedList) ;
        Order.endApp(usersList,booksList,borrowedList);

    }

}
//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//


