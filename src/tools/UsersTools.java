package tools;

import objects.Books;
import coreSystem.Order;
import objects.Users;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class UsersTools {

//--------------------------------------------- CREATION OF USERS - INPUT - IN DATABASE - COMMAND 3---------------------------------------------------------------------------------------------//


    public static java.util.List<Users> addIt(java.util.List<Users> usersList, java.util.List<Books> booksList, Map borrowedMap  ) {

        String name ="";
        String firstName ="";
        Integer dayBirth = 0;
        Integer monthBirth = 0;
        Integer yearBirth = 0;
        boolean isUserTheSame =false;

        Users user = new Users(firstName, name, dayBirth, monthBirth, yearBirth);

        //do {
        System.out.println("You want to susbcribe" +
                "=> Please enter your name:");
        name = Tools.scanString(name);
        user.setName(name);

        System.out.println("Please enter your firstName: \n");
        firstName = Tools.scanString(firstName);
        user.setFirstName(firstName);

        isUserTheSame = Tools.isSameUser(usersList, firstName, name, isUserTheSame);
        if (isUserTheSame == true) {
            System.out.println("This user already exist. Please retry with another name.");
            Order.runApp(1, usersList,booksList, borrowedMap);
        }
        //} while (isUserTheSame == true) ;


        do {

            try {
                System.out.println("Please enter the day of your birth (between 1 and 31 included): \n");
                dayBirth = Tools.scanInt(dayBirth);

                if (dayBirth <= 0 || dayBirth > 31) {
                    System.out.println("Don't forget, a month cannot have more than 31 days !");
                }
                user.setBirthDay(dayBirth);

            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 31 included");
            }

        } while (dayBirth <= 0 || dayBirth > 31);


        do {
            try {
                System.out.println("Please enter the month of your birth: \n");
                monthBirth = Tools.scanInt(monthBirth);

                if (monthBirth <= 0 || monthBirth > 12) {
                    System.out.println("Don't forget, a year can't have more than 12 months.");
                }
                user.setBirthMonth(monthBirth);
            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
            }

        } while (monthBirth <= 0 || monthBirth > 12);

        do {
            try {
                System.out.println("Please enter the year of your birth: \n");
                yearBirth = Tools.scanInt(yearBirth);

                if (yearBirth <= 0 || yearBirth < 1900 || yearBirth > 2019) {
                    System.out.println("erreur dans l'année");
                }
                user.setBirthYear(yearBirth);

            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
            }
        } while (yearBirth <= 0 || yearBirth < 1900 || yearBirth > 2019);


        // ajout utilisateur à la liste
        usersList.add(user);
        //sauvagarde de la liste dans la database avec le nouvel utilisateur
        FilesHandler f = new FilesHandler();
        f.writeInFile(usersList, "usersDatabase");
        //test
        return usersList;
    }


//---------------------------------------------  UPDATING IN DATABASE ---------------------------------------------------------------------------------------------//

    public static java.util.List<Users> updateList(java.util.List<Users> usersList, List<Books> booksList, Map borrowedMap) throws IOException {
        String name = "";
        String firstName = "";
        Integer dayBirth = 0;
        Integer monthBirth = 0;
        Integer yearBirth = 0;
        boolean isUserInuserslist=false;

        Users userUpdated = new Users(firstName, name, dayBirth, monthBirth, yearBirth);

        //rcehercher un utilisateur avec exactement le patronyme utilisé


        // verification du même patronyme
        do {
            System.out.println("You want to update a user" +
                    "=> Please enter your name:");
            name = Tools.scanString(name);
            userUpdated.setName(name);

            System.out.println("Please enter your firstName: \n");
            firstName = Tools.scanString(firstName);
            userUpdated.setFirstName(firstName);

            isUserInuserslist = Tools.isSameUser(usersList, firstName, name, isUserInuserslist);
            //TODO a completer = > isuserInMapuser
            if (isUserInuserslist == true) {
                System.out.println("User founded. Let's update");
                Users usertoremove = Tools.getSimilarReference(usersList,firstName, name);
                usersList.remove(usertoremove);
            }
            else {
                System.out.println("User not present in our database. You can't update it. Please type 3 to create a new user");
                //rerun the process
                Order.processCmd(1, usersList,booksList,borrowedMap);
            }

        } while (isUserInuserslist == false) ;


        // UPDATING DATAS

        do {

            try {
                System.out.println("Please update your birthday): \n");
                dayBirth = Tools.scanInt(dayBirth);

                if (dayBirth <= 0 || dayBirth > 31) {
                    System.out.println("Don't forget, a month cannot have more than 31 days !");
                }
                userUpdated.setBirthDay(dayBirth);

            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 31 included");
            }

        } while (dayBirth <= 0 || dayBirth > 31);


        do {
            try {
                System.out.println("Please update the month of your birth: \n");
                monthBirth = Tools.scanInt(monthBirth);

                if (monthBirth <= 0 || monthBirth > 12) {
                    System.out.println("Don't forget, a year can't have more than 12 months.");
                }
                userUpdated.setBirthMonth(monthBirth);
            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
            }

        } while (monthBirth <= 0 || monthBirth > 12);

        do {
            try {
                System.out.println("Please enter the year of your birth: \n");
                yearBirth = Tools.scanInt(yearBirth);

                if (yearBirth <= 0 || yearBirth < 1900 || yearBirth > 2019) {
                    System.out.println("Wrong year. You are too old to be alive or you're not born");
                }
                userUpdated.setBirthYear(yearBirth);

            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
            }
        } while (yearBirth <= 0 || yearBirth < 1900 || yearBirth > 2019);

        usersList.add(userUpdated);
        System.out.println(usersList);
        FilesHandler f = new FilesHandler();
        f.writeInFile(usersList, "usersDatabase");
        return usersList;

    }



 /*
 public static List <Users> removeUser (List<Users> usersList, String firstName, String name, boolean isUserTheSame){
     String name = "";
     String firstName = "";
     Integer dayBirth = 0;
     Integer monthBirth = 0;
     Integer yearBirth = 0;

     Users usertoFind = new Users(firstName, name, dayBirth, monthBirth, yearBirth);

     // verification du même patronyme
     do {
         System.out.println(
                 "=> Please enter your name:");
         name = Tools.scanString(name);
         usertoFind.setName(name);

         System.out.println("Please enter your firstName: \n");
         firstName = Tools.scanString(firstName);
         usertoFind.setFirstName(firstName);
         boolean isUserInuserslist=false;
         isUserInuserslist = Tools.isSameUser(usersList, firstName, name, isUserInuserslist);


         //TODO a completer = > isuserInMapuser
         if (isUserInuserslist == true) {
             System.out.println("User founded. Let's update");
             Users usertoremove = Tools.getSimilarReference(usersList,firstName, name);
             usersList.remove(usertoremove);
         }
         else {
             System.out.println("User not present in our database. You can't update it. Please type 3 to create a new user");
             //rerun the process
             Order.processCmd(1, usersList,booksList,borrowedMap);
         }

     } while (isUserInuserslist == false) ;









        for (Users user1 : usersList) {
             if (user1.getFirstName().equals(firstName) && user1.getName().equals(name)) {
                 isUserTheSame = true;
             } else {
                 isUserTheSame = false;
                 System.out.println("OK give us other informations");

             }
         }
         return isUserTheSame;
     }


 }*/

}
