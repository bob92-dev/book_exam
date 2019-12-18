package com.company;

import java.util.*;

public class Users {

    private String firstName;
    private String name;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

// -------------------------------------------- CONSTRUCTOR------------------------------------------------------------//

    /**
     * constructor method. Initialization.
     *
     * @param firstName
     * @param name
     * @param birthDay
     * @param birthMonth
     * @param birthYear
     */
    public Users(String firstName, String name, int birthDay, int birthMonth, int birthYear) {
        /*if (birthDay < 32) {
            throw new LibraryException("Please enter a number between 1 and 31 (included)");
        }
        if (birthMonth < 13) {
            throw new LibraryException("Please enter a number between 1 and 31 (included)");
        }
        if (birthYear < 1919 || birthYear > 2019) {
            throw new LibraryException("Impossible year of birth. Please enter a valid one.");
        } else {*/
        this.firstName = firstName;
        this.name = name;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    //-----------------------------------------------   OVERIDING ---------------------------------------------------------------------------------------------------------------//
    //overidal of the to string sclass
    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", birthMonth=" + birthMonth +
                ", birthYear=" + birthYear +
                '}';
    }

    // equals a verifier
    //TODO a verifier le rewriting de la classe equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getBirthDay() == users.getBirthDay() &&
                getBirthMonth() == users.getBirthMonth() &&
                getBirthYear() == users.getBirthYear() &&
                getFirstName().equals(users.getFirstName()) &&
                getName().equals(users.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getName(), getBirthDay(), getBirthMonth(), getBirthYear());
    }


    //--------------------------------------------- GETTERS AND SETTERS ---------------------------------------------------------------------------------------------//
    // getters ands setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    //--------------------------------------------- CREATION OF USERS - INPUT - OUTPUT - IN DATABASE ---------------------------------------------------------------------------------------------//


    public static List<Users> addIt(List<Users> usersList) {
        // j'imprime els instructions
        String name = "";
        String firstName = "";
        Integer dayBirth = 0;
        Integer monthBirth = 0;
        Integer yearBirth = 0;

        Users user = new Users(firstName, name, dayBirth, monthBirth, yearBirth);

        // do while to deal with exceptions

        System.out.println("\n" +
                "You want to susbcribe" +
                "=> Please enter your name: \n");
        //test
        System.out.println(usersList);
        // je scanne ce qui est tapé
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println(name);
        user.setName(name);

        System.out.println("Please enter your firstNname: \n");
        Scanner sc1 = new Scanner(System.in);
        firstName = sc1.nextLine();
        System.out.println(firstName);
        user.setFirstName(firstName);

        for (Users user1:usersList) {
            if (user1.getFirstName().equals(firstName) && user1.getName().equals(name)) {
                System.out.println("You are already registered!");
                return null;
            }

        }


        do {

            try {
                System.out.println("Please enter the day of your birth: \n");
                Scanner sc2 = new Scanner(System.in);
                dayBirth = sc2.nextInt();
                System.out.println(dayBirth);
                if (dayBirth > 31) {
                    System.out.println("erreur dans le jour");
                }
                user.setBirthDay(dayBirth);

            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 31 included");
            }

        } while (dayBirth == 0 || dayBirth > 31);


        do {
            try {
                System.out.println("Please enter the month of your birth: \n");
                Scanner sc3 = new Scanner(System.in);
                monthBirth = sc3.nextInt();
                System.out.println(monthBirth);
                if (monthBirth > 12) {
                    System.out.println("erreur dans le mois");

                }
                user.setBirthMonth(monthBirth);
            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
            }

        } while (monthBirth == 0 || monthBirth > 12);


        do {
            try {
                System.out.println("Please enter the year of your birth: \n");
                Scanner sc4 = new Scanner(System.in);
                yearBirth = sc4.nextInt();
                if (yearBirth < 1919 || yearBirth > 2019) {
                    System.out.println("erreur dans l'année");
                }
                user.setBirthYear(yearBirth);
                System.out.println(yearBirth);

            } catch (NoSuchElementException eNse) {
                System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
            }
        } while (yearBirth == 0 || yearBirth < 1919 || yearBirth > 2019);


        // creation nouvel utilisateur

        System.out.println(user.name);

        // verification des homonymies par le nom et homonymie par le prénom

        // ajout utilisateur
        usersList.add(user);
        //test
        System.out.println(usersList);

            return usersList;
        }


    public static List <Users> updateList(List <Users> usersList){

        //rcehercher un utilisateur avec exactement le patronyme utilisé
        boolean inside = false;
        // verification du même patronyme

        String name = "";
        String firstName = "";
        Integer dayBirth = 0;
        Integer monthBirth = 0;
        Integer yearBirth = 0;

        Users user = new Users(firstName, name, dayBirth, monthBirth, yearBirth);

        // do while to deal with exceptions

        System.out.println(
                "=> Please enter your name: \n");
        //test
        System.out.println(usersList);
        // je scanne ce qui est tapé
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println(name);
        user.setName(name);

        System.out.println("Please enter your firstNname: \n");
        Scanner sc1 = new Scanner(System.in);
        firstName = sc1.nextLine();
        System.out.println(firstName);
        user.setFirstName(firstName);

        for (Users user1:usersList) {
            if (user1.getFirstName().equals(user.firstName) && user1.getName().equals(user.name)) {
                inside = true;
                System.out.println("You are registered. Lets updating your datas");

                do {

                    try {
                        System.out.println("Please update the day of your birth: \n");
                        Scanner sc2 = new Scanner(System.in);
                        dayBirth = sc2.nextInt();
                        System.out.println(dayBirth);
                        if (dayBirth > 31) {
                            System.out.println("erreur dans le jour");
                        }
                        user.setBirthDay(dayBirth);

                    } catch (NoSuchElementException eNse) {
                        System.out.println("Not a number. Please enter a valid number that is to say between 1 and 31 included");
                    }

                } while (dayBirth == 0 || dayBirth > 31);

                do {

                    try {
                        System.out.println("Please enter the month of your birth: \n");
                        Scanner sc3 = new Scanner(System.in);
                        monthBirth = sc3.nextInt();
                        System.out.println(monthBirth);
                        if (monthBirth > 12) {
                            System.out.println("erreur dans le mois");

                        }
                        user.setBirthMonth(monthBirth);
                    } catch (NoSuchElementException eNse) {
                        System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
                    }

                } while (monthBirth == 0 || monthBirth > 12);

                do {

                    try {
                        System.out.println("Please enter the year of your birth: \n");
                        Scanner sc4 = new Scanner(System.in);
                        yearBirth = sc4.nextInt();
                        if (yearBirth < 1919 || yearBirth > 2019) {
                            System.out.println("erreur dans l'année");
                        }
                        user.setBirthYear(yearBirth);
                        System.out.println(yearBirth);

                    } catch (NoSuchElementException eNse) {
                        System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
                    }
                } while (yearBirth == 0 || yearBirth < 1919 || yearBirth > 2019);


                            // ajout utilisateur
               else{



               }
            }             usersList.add(user);
                            //test
                            System.out.println(usersList);

                            return usersList;
            }



            }
}

// rcehercher un utilisateur avec excatement le patronme utilisé



       /* #4] edituser <firstname> <lastname>
                - la commande va modifier un utilisateur déjà enregistré
                - la commande recherche un utilisateur avec exactement le patronyme rentré.
                Si l'utilisateur existe, alors la commande demande d'entrer tous les nouveaux paramètres un à un.
        Si pour un paramètre on entre une chaine vide, on garde la valeur précédente


        - la commande va ensuite vérifier les nouvelles informations entrées (comme le fait adduser) et enregistrer les modifications de l'utilisateur DANS LE MEME OBJET (on modifie l'utilisateur, on n'en créé pas de nouveau).

        SI une erreur est survenue dans la saisie des nouvelles valeurs (ex : le nouveau nom et le nouveau prénom existent deja, ou bien un champ de type entier qui contient des lettres) alors on ne modifie pas l'utilisateur et on affiche un message d'erreur.
        */

       - si l'utilisateur recherché n'existe pas dans la liste, alors on affiche un message d'erreur.
               - si l'utilisateur est utilisé dans la troisième table (emprunts, locations, enchères, livraisons, actions, transactions), alors la modification de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché




//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//

