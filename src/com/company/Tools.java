package com.company;

import java.util.Map;
import java.util.Scanner;

public class Tools {
    /**
     * this class is just there offered some usefull tools.
     *
     * @return
     */


//TODO : gestion de l'exception à vérifier
    public static int getChoice() throws LibraryException {

        int choice;
        System.out.println("\n" +
                "=> Please enter a command : \n");

        Scanner sc = new Scanner(System.in);

        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            throw new LibraryException("Please try another number", e.getCause());
        }

        return choice;
    }



}


