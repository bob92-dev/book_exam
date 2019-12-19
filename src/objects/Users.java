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
     * constructor method.
     *
     * @param firstName first name of user
     * @param name name of user
     * @param birthDay day of birth of the user
     * @param birthMonth month of birth of the user
     * @param birthYear year of birth of the user
     */
    public Users(String firstName, String name, int birthDay, int birthMonth, int birthYear) {

        this.firstName = firstName;
        this.name = name;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }




    //--------------------------------------------- GETTERS AND SETTERS ---------------------------------------------------------------------------------------------//

    /**
     * getter of user first name
     * @return String first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter of user first name
     * @param firstName of the user
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter of the user name
     * @return string name
     */
    public String getName() {
        return name;
    }

    /**
     * setter of user name
     * @param name of the user
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter of the day of birth
     * @returnint birtday
     */

    public int getBirthDay() {
        return birthDay;
    }

    /**
     * setter of birthday
     * @param birthDay
     */
    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * getter of thge mont of birth
     * @return int birthmonth
     */
    public int getBirthMonth() {
        return birthMonth;
    }

    /**
     * setter of birtmonth
     * @param birthMonth
     */

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    /**
     * getter of birth year
     * @return int birth year
     */

    public int getBirthYear() {
        return birthYear;
    }

    /**
     * setter of birth year. no return
     * @param birthYear
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }



    //-----------------------------------------------   OVERIDING ---------------------------------------------------------------------------------------------------------------//
    /**
     *  Rewriting of toString method sa as to cast (or access)  other types objects
     */
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


    /**
     * Rewriting of the equals method that let us compare objects
     * @param o object
     * @return boolean
     */
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

    /**
     Rewriting of the the method that deal with the memory
     * @return int code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getName(), getBirthDay(), getBirthMonth(), getBirthYear());
    }





}
//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//




