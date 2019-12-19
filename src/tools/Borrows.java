package tools;

import com.company.IAddIt;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Borrows  {
    private String borrowerFirstName;
    private String borrowerName;
    private String bookReference;
    private String borrowDate;
    private String borrowReturn;
// -------------------------------------------- CONSTRUCTOR------------------------------------------------------------//

    /**
     * constructor methdo. initalization.
     * @param borrowerName
     * @param borrowerFirstName
     * @param bookReference
     * @param borrowDate
     * @param borrowReturn
     */
    public Borrows(String borrowerFirstName, String borrowerName, String bookReference, String borrowDate, String borrowReturn) {
        this.borrowerFirstName = borrowerFirstName;
        this.borrowerName = borrowerName;
        this.bookReference = bookReference;
        this.borrowDate = borrowDate;
        this.borrowReturn = borrowReturn;
    }
    //---------------------------------------------- GETTERS AND SETTERS ---------------------------------------------------------------------------------------------//

    //getters and setters
    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerFirstName() {
        return borrowerFirstName;
    }

    public void setBorrowerFirstName(String borrowerFirstName) {
        this.borrowerFirstName = borrowerFirstName;
    }

    public String getBookReference() {
        return bookReference;
    }

    public void setBookReference(String bookReference) {
        this.bookReference = bookReference;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBorrowReturn() {
        return borrowReturn;
    }

    public void setBorrowReturn(String borrowReturn) {
        this.borrowReturn = borrowReturn;
    }

    //-----------------------------------------------   OVERIDING ---------------------------------------------------------------------------------------------------------------//

    @Override
    public String toString() {
        return "Borrows{" +
                "borrowerName='" + borrowerName + '\'' +
                ", borrowerFirstName='" + borrowerFirstName + '\'' +
                ", bookReference='" + bookReference + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", borrowReturn='" + borrowReturn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrows)) return false;
        Borrows borrows = (Borrows) o;
        return Objects.equals(getBorrowerName(), borrows.getBorrowerName()) &&
                Objects.equals(getBorrowerFirstName(), borrows.getBorrowerFirstName()) &&
                Objects.equals(getBookReference(), borrows.getBookReference()) &&
                Objects.equals(getBorrowDate(), borrows.getBorrowDate()) &&
                Objects.equals(getBorrowReturn(), borrows.getBorrowReturn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBorrowerName(), getBorrowerFirstName(), getBookReference(), getBorrowDate(), getBorrowReturn());
    }
}
