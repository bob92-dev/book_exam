package objects;

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



}



//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//

