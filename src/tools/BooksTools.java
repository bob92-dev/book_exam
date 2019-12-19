package tools;

import coreSystem.Order;
import objects.Books;
import objects.Users;

import javax.tools.Tool;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class BooksTools {

    //--------------------------------------------- ADDBOOK - INPUT - IN DATABASE - COMMAND 7---------------------------------------------------------------------------------------------//

    public static List<Books> addBook(List<Users> usersList, List<Books> booksList, List<Borrows> borrowedList) {
        String title = "";
        int publishedYear = 0;
        String editorName = "";
        String reference = "";
        boolean isBookTheSame = false;


        Books book = new Books(title, publishedYear, editorName, reference);

        // check if the reference is the booklist
        do {
        System.out.println("Enter the reference of the book : 1 letter followed by 3 numbers (example :B218)");
        reference = Tools.scanString(reference);
        Tools.checkReference(reference);
        } while (reference.length()!=4);

        book.setReference(reference);


        isBookTheSame = Tools.isSameBook(booksList, reference, isBookTheSame);

        if (isBookTheSame == true) {
            System.out.println("This book already exist in our database. Please retry with another reference.");
            Order.runApp(1, usersList, booksList, borrowedList );
        } else {
            System.out.println("Enter the title of the book \n");
            title = Tools.scanString(title);
            book.setTitle(title);

            do {
                try {

                    System.out.println("Please enter the year of publication: enter a number");
                    publishedYear = Tools.scanInt(publishedYear);
                        if (publishedYear > 2019) {
                            System.out.println("We don't believe in space time travel. Please type a real date");
                        }

                    } catch (NoSuchElementException eNse) {
                        System.out.println("Not a number. Please enter a valid number that is to say "+eNse.getCause());
                }
            } while (publishedYear > 2019 || publishedYear == 0);

            book.setPublishedYear(publishedYear);


            System.out.println("Please enter the name of the editor : \n");
            editorName = Tools.scanString(editorName);
            book.setEditorName(editorName);

            booksList.add(book);

            System.out.println(booksList);
            FilesHandler f = new FilesHandler();
            f.writeInFile(booksList, "booksDatabase");

        }
        return booksList;
    }


    //---------------------------------------------  EDIT BOOK - UPDATING DATABASE - COMMAND 8 ---------------------------------------------------------------------------------------------//


    public static List<Books> editBook(List<Users> usersList, List<Books> booksList, List<Borrows> borrowedList ) throws IOException {
        String title = "";
        int publishedYear = 0;
        String editorName = "";
        String reference = "";
        boolean isHeIn=false;

        Books bookUpdated = new Books(title, publishedYear, editorName, reference);

        boolean isBookTheSame = false;

            System.out.println("You want to update a book" +
                    "=> Please enter the reference of your book:");
            reference = Tools.scanString(reference);
            bookUpdated.setReference(reference);

        isHeIn = Tools.isTheBookInThirdList(borrowedList,reference,isHeIn);
        if (isHeIn=true){
            System.out.println("User founded in borrower database.Impossible to remove it.Return to help.");
            Order.processCmd(1, usersList,booksList,borrowedList);
        }



            isBookTheSame = Tools.isSameBook(booksList, reference, isBookTheSame);

            if (isBookTheSame == true) {
                System.out.println("Book found. Let's update");
            } else {
                System.out.println("Book is not present in our database. You can't update it. Please type 7 to create a new book");
                //rerun the process
                Order.processCmd(1, usersList, booksList,  borrowedList );
            }




        // UPDATING DATAS

        try {
            System.out.println("Please confirm your reference: \n");
            reference = Tools.scanString(reference);
            bookUpdated.setReference(reference);

            System.out.println("Please update the title");
            title = Tools.scanString(title);
            bookUpdated.setTitle(title);

            System.out.println("Please update your the editor name): \n");
            editorName = Tools.scanString(editorName);
            bookUpdated.setEditorName(editorName);
        } catch (Exception ex) {
            System.out.println("problem with your updating. Please retry" + ex.getCause());
        }

        try {
            do {
                System.out.println("Please update the year of publication: enter a number");
                publishedYear = Tools.scanInt(publishedYear);
                if (publishedYear > 2019) {
                    System.out.println("We don't believe in space time travel. Please type a real date");
                }
            } while (publishedYear > 2019);
            bookUpdated.setPublishedYear(publishedYear);

        } catch (NoSuchElementException eNse) {
            System.out.println("Not a number. Please enter a valid number that is to say between 1 and 12 included");
        }


        booksList.add(bookUpdated);
        System.out.println(booksList);
        FilesHandler f = new FilesHandler();
        f.writeInFile(booksList, "booksDatabase");
        return booksList;
    }


    //---------------------------------------------  REMOVEBOOK - COMMAND 9//---------------------------------------------------------------------------------------------//

    public static List<Books> removeBook(List<Users> usersList, List<Books> booksList, List<Borrows> borrowedList) throws IOException {
        String title = "";
        int publishedYear = 0;
        String editorName = "";
        String reference = "";
        boolean isBookTheSame = false;

        Books bookToRemove = new Books(title, publishedYear, editorName, reference);

        System.out.println(" WARNING : YOU WILL DELETE THIS BOOK => enter the book reference:");
        reference = Tools.scanString(reference);
        //bookToRemove.setReference(reference);
        isBookTheSame = Tools.isSameBook(booksList, reference, isBookTheSame);
        //TODO a completer = > isuserInMapuser

        if (isBookTheSame == true) {

                System.out.println("Book found. Let's suppress it");
                bookToRemove = Tools.getSimilarReferenceForBook(booksList, reference);
                booksList.remove(bookToRemove);
            System.out.println("This user has been removed from our database");


        } else {
                System.out.println("Book not present in our database. You can't suppress it ! Please type 3 to create a new user");
                //rerun the process
                Order.processCmd(1, usersList, booksList,  borrowedList );
            }

        // STEP 3 : saving of our new data
        System.out.println(booksList);
        FilesHandler f = new FilesHandler();
        f.writeInFile(booksList, "booksDatabase");
        return booksList;
    }
}



//---------------------------------------- END OF CLASS --------------------------------------------------------------------------------//

