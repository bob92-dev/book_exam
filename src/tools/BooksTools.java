package tools;

import coreSystem.Order;
import objects.Books;
import objects.Users;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BooksTools {

    //--------------------------------------------- ADDBOOK - INPUT - IN DATABASE - COMMAND 7---------------------------------------------------------------------------------------------//

    public Books bookDescription(List<Users> usersList, List<Books> booksList, Map borrowedMap ) {
            String title = "";
            int publishedYear = 0;
            String editorName ="";
            String reference="";

        Books book = new Books(title, publishedYear, editorName, reference);

        // check if the refrence is not already borrowed
        System.out.println("Enter the reference of the book : 1 letter followed by 3 numbers (example :B218)");
        reference = Tools.scanString(reference);
        book.setReference(reference);

        boolean isBookTheSame=true;
        isBookTheSame = Tools.isSameBook(booksList, reference, title, publishedYear, editorName, isBookTheSame);

        if (isBookTheSame == true) {
            System.out.println("This user already exist. Please retry with another name.");
            Order.runApp(1, usersList,booksList, borrowedMap);
        }

       /* atten te de réponse ne pas supprimer : methode pour récupérer dans la hasmap
        try{

            if (borrowedMap.containsKey(reference)) {
                System.out.println("This book is already borrowed. Please try another command");
                // bookList.add(book);
                Order.runApp(1, List< Users > usersList, java.util.List<Books> booksList, Map borrowedMap LisusersList);
            }
        }catch(Exception e){
            System.out.println("ERROR IN BOOK TOOLS"+e.getCause());
        }*/

        //do {
        System.out.println("Enter the title of the book")
        title = Tools.scanString(title);
        book.setTitle(title);

        System.out.println("Please enter your firstName: \n");
        firstName = Tools.scanString(firstName);
        user.setFirstName(firstName);

    }



        public List<Books> addBook(List<Books> bookList, Map borrowedMap, ) throws IOException {
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
