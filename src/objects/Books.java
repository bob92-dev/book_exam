package objects;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Books {
    private String title;
    private int publishedYear;
    private String editorName;
    private String reference;

    // reference en final ?
// -------------------------------------------- CONSTRUCTOR------------------------------------------------------------//
    /**
     * constructor method. Initialization.
     * @param title title of the book
     * @param publishedYear date of publication
     * @param editorName name of the editor
     * @param reference unique key for each book. 4 characters, no more, no less.
     */
    public Books(String title, int publishedYear, String editorName, String reference) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.editorName = editorName;
        this.reference = reference;
    }

    //---------------------------------------------- GETTERS AND SETTERS ---------------------------------------------------------------------------------------------//

    /**
     * set title book
     * @param title booktitle
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *  set Published Year of the book
     * @param publishedYear int
     */

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    /**
     * set editor name of the book
     * @param editorName string type. Not limited in character.
     */

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    /**
     * Unique reference for each book
     * @param reference Maximum 4 characters. Begin by a letter, then 3 numbers. String type.
     */

    public void setReference(String reference) {
        this.reference = reference;
    }


    /**
     * getter for title of books
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter for the year of publication
     * @return int
     */
    public int getPublishedYear() {
        return publishedYear;
    }

    /**
     * getter for the editor name
     * @return string . Not limited.
     */

    public String getEditorName() {
        return editorName;
    }

    /**
     * getter of the unique reference of the book
     * @return String
     */

    public String getReference() {
        return reference;
    }

    //-----------------------------------------------   OVERIDING ---------------------------------------------------------------------------------------------------------------//

    /**
     * Rewriting of toString method sa as to cast (or access)  other types objects
     * @return String
     */
    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", publishedYear=" + publishedYear +
                ", editorName='" + editorName + '\'' +
                ", reference='" + reference + '\'' +
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
        if (!(o instanceof Books)) return false;
        Books books = (Books) o;
        return getPublishedYear() == books.getPublishedYear() &&
                Objects.equals(getTitle(), books.getTitle()) &&
                Objects.equals(getEditorName(), books.getEditorName()) &&
                Objects.equals(getReference(), books.getReference());
    }

    /**
     * Rewriting of the the method that deal with the memory
     * @return hascode so an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPublishedYear(), getEditorName(), getReference());
    }



}
//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//