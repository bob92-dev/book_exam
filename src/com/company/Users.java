package com.company;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Users {

    private String firstName;
    private String name;
    private int birthDay;
    private int birthMonth;
    private int birthYear;


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

    //}
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
                Objects.equals(getFirstName(), users.getFirstName()) &&
                Objects.equals(getName(), users.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getName(), getBirthDay(), getBirthMonth(), getBirthYear());
    }

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

    public static Map addIt(Map usersMap) {
        // j'imprime els instructions
        System.out.println("\n" +
                "You want to susbcribe" +
                "=> Please enter your name: \n");
        // je scanne ce qui est tapé
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name);

        System.out.println("Please enter your firstNname: \n");
        Scanner sc1 = new Scanner(System.in);
        String firstName = sc1.nextLine();
        System.out.println(firstName);

        System.out.println("Please enter the day of your birth: \n");
        Scanner sc2 = new Scanner(System.in);
        int dayBirth = sc2.nextInt();
        System.out.println(dayBirth);

        System.out.println("Please enter the month of your birth: \n");
        Scanner sc3 = new Scanner(System.in);
        int monthBirth = sc3.nextInt();
        System.out.println(monthBirth);

        System.out.println("Please enter the year of your birth: \n");
        Scanner sc4 = new Scanner(System.in);
        int yearBirth = sc4.nextInt();
        System.out.println(yearBirth);



        // creation nouvel utilisateur
        Users user = new Users(firstName, name, dayBirth, monthBirth, yearBirth);

        System.out.println(user.name);

        // verification des homonymies par le nom et homonymie par le prénom
        if (usersMap.containsKey(user.getName()) && usersMap.containsValue(user.getFirstName())) {
            System.out.println("You are already registered in the database");
        } else {

            //verification des entiers
            // deja fait dna sle constructeur :
            if (dayBirth > 31){
                System.out.println("erreur dans le jour");
            }
            if (monthBirth > 12){
                System.out.println("erreur dans le mois");
            }
            if (yearBirth < 1919 || yearBirth > 2019){
                System.out.println("erreur dans l'année");

            }
            if ((dayBirth < 32 )&& (monthBirth < 13) && (yearBirth > 1919 && yearBirth < 2019)) {
                // inscription dans le dictionnaire
                usersMap.put(name, user);
            }
        }
        return usersMap;
    }
}
