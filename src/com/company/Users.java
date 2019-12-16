package com.company;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Users implements IAddIt {

    private String firstName;
    private String name;
    private int birthDay;
    private int birthMonth;
    private int birthYear;


    /**
     * constructor method. Initialization.
     * @param firstName
     * @param name
     * @param birthDay
     * @param birthMonth
     * @param birthYear
     */
    public Users(String firstName, String name, int birthDay, int birthMonth, int birthYear) {
        this.firstName = firstName;
        this.name = name;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

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

    @Override
    public Map addIt(Map usersMap, Map borrowedMap) {
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
            System.out.println("You are already registered in the database");
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
