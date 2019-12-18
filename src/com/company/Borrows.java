package com.company;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Borrows implements IAddIt{
    private String borrowerName;
    private String borrowerFirstName;
    private String bookReference;
    private String borrowDate;
    private String borrowReturn;

    /**
     * constructor methdo. initalization.
     * @param borrowerName
     * @param borrowerFirstName
     * @param bookReference
     * @param borrowDate
     * @param borrowReturn
     */
    public Borrows(String borrowerName, String borrowerFirstName, String bookReference, String borrowDate, String borrowReturn) {
        this.borrowerName = borrowerName;
        this.borrowerFirstName = borrowerFirstName;
        this.bookReference = bookReference;
        this.borrowDate = borrowDate;
        this.borrowReturn = borrowReturn;
    }

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

    @Override
    public Map addIt(List usersList, Map borrowedMap) {
        return null;
    }
}
