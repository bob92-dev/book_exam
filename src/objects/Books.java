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
     * @param title
     * @param publishedYear
     * @param editorName
     * @param reference
     */
    public Books(String title, int publishedYear, String editorName, String reference) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.editorName = editorName;
        this.reference = reference;
    }

    //---------------------------------------------- GETTERS AND SETTERS ---------------------------------------------------------------------------------------------//

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }



    public String getTitle() {
        return title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public String getEditorName() {
        return editorName;
    }

    public String getReference() {
        return reference;
    }

    //-----------------------------------------------   OVERIDING ---------------------------------------------------------------------------------------------------------------//

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", publishedYear=" + publishedYear +
                ", editorName='" + editorName + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPublishedYear(), getEditorName(), getReference());
    }



}
//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//