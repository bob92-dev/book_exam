package com.company;

import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Scanner;


/** this class is used to manipulate the database
 *
  */
    public class BookSituation {
    private Map<String, Users> usersMap;
    //TODO a voir si j'utilise private Date enrolmentDay;

    public BookSituation(Map<String, Users> usersMap) {
        this.usersMap = usersMap;
    }


    public Map addUser(Map usersMap) {
        // j'imprime els instructions
        System.out.println("\n" +
                "You want to susbcribe" +
                "=> Please enter your name: \n");
        // je scanne ce qui est tapé
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Please enter your firstNname: \n");
        Scanner sc1 = new Scanner(System.in);
        String firstName = sc1.nextLine();

        System.out.println("Please enter the day of your birth: \n");
        Scanner sc2 = new Scanner(System.in);
        int dayBirth = sc2.nextInt();

        System.out.println("Please enter the month of your birth: \n");
        Scanner sc3 = new Scanner(System.in);
        int monthBirth = sc3.nextInt();

        System.out.println("Please enter the year of your birth: \n");
        Scanner sc4 = new Scanner(System.in);
        int yearBirth = sc4.nextInt();


        // creation nouvel utilisateur
        Users user = new Users(firstName, name, dayBirth, monthBirth, yearBirth);
        // verification des homonymies par le nom et homonymie par le prénom
        if (usersMap.containsKey(user.getName()) && usersMap.containsValue(user.getFirstName())) {
            System.out.println("You are already in the database");
        } else {

            // verification des entiers
            if ((dayBirth < 32) && (monthBirth < 13) && (yearBirth > 1919 && yearBirth < 2019)) {
                // inscription dans le dictionnaire
                usersMap.put(name, user);
            } else {
                System.out.println("erreur dans l'enregistrement");
            }
        }
        return usersMap;
    }
}
