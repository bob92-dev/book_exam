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



    // getters and setters
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

    // that's our addbook
    // TODO fonction à revoir

   public List<Books> addIt(List<Books> bookList, Map borrowedMap) throws IOException {
        // d'abord chercher si la référence est prèsente dans borrow
        // si la référence de l'objet n'existe pas, on la crée dans une liste
        Books book = new Books(title, publishedYear, editorName, reference);
        // s'il ne contient pas le livre à la réference
       // try {
            if (!borrowedMap.containsKey(book.getReference())) {
                bookList.add(book);
            }
       // }catch(IOException e2)
        //    {
        //        System.out.println("ceci est l'exception"+e2.getMessage());
        //    }
        //TODO gerer lexecption
        // lexception ne fonctionne pas

        return bookList;
    }
}