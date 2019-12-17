package com.company;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Tools {
    /**
     * this class is just there offered some usefull tools.
     *
     * @return
     */


//TODO : gestion de l'exception à vérifier
    public static int getChoice() throws Exception {

        int choice = 1;
        System.out.println("\n" +
                "=> Please enter a valid command number : \n");

        Scanner sc = new Scanner(System.in);

        try {
            choice = sc.nextInt();
        }
            // erreur pour ceux qui laissent le champs vide
        catch (NumberFormatException enbr){
            System.out.println("this is not a number. Please enter a number"+enbr.getCause());
        }
        catch (NullPointerException enp){
            System.out.println("You write nothing ! Please enter a valid number"+ enp.getCause());
        }
        // erreur pour gérer les gens qui tapent au delà du nombre maximum de commandes
        catch (IndexOutOfBoundsException e) {
            System.out.println("This number is not permitted. Please enter a valid number"+ e.getCause());
        }
        // erreur voiture balais
        catch (Exception ex){
            System.out.println("OOPS : syntax error. Please enter a valid number"+ex.getCause()+ex.getMessage()+ex.getStackTrace());
        }

        return choice;
    }



}


