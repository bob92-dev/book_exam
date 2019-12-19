package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FilesHandler {

    /**
     * this method create the database, as a text file (if it doesn't exist). It is called in the init function.
     *
     * @throws IOException due to presence of interactions with files
     */
    public void createFile(String databaseName) throws IOException {

        File database = new File("/Users/boriscassel/IdeaProjects/books_exam/src/database/"+databaseName + ".txt");
        // check if the file exist
        if (!database.exists()) {

            //if not, create a file for the database
            try {
                database.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * this method read the database.
     */
    public void readFile(String databaseName) {

        try {
            File f = new File("/Users/boriscassel/IdeaProjects/books_exam/src/database/"+databaseName + ".txt");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    /**
     * this method is build for writing and saving our data in our database.txt
     *
     * @param myDataList
     */
    public void writeInFile(List myDataList, String databaseName) {

        try {
            FileWriter myWriter = new FileWriter("/Users/boriscassel/IdeaProjects/books_exam/src/database/"+databaseName + ".txt");
            // pas sur de ce bout de code là.
            myWriter.write(String.valueOf(myDataList));
            myWriter.close();
            System.out.println("Successfully saved in the database.");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

}