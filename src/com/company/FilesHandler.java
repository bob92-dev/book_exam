package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class FilesHandler {

    /**
     * this method create the database, as a csv file (if it doesn't exist). It is called in the init function.
     * @throws IOException
     */
    public void createFile () throws IOException {

        File database = new File("database.csv");
        // check if the file exist
        if(!database.exists()){

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
    public void readFile() {

        try {
            File f = new File("database.csv");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data); }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); }

    }


    //TODO vérifier ce bout de code, notamment ligne myWriter.write(String.valueOf(myDataMap));

    /**
     * this method is build for writing and saving our data in our database.csv
     * @param myDataMap
     */
    public void writeInFile(Map myDataMap){

        try {
            FileWriter myWriter = new FileWriter("database.csv");
            // pas sur de ce bout de code là.
            myWriter.write(String.valueOf(myDataMap));
            myWriter.close();
            System.out.println("Successfully wrote into the file.");
        } catch (IOException e) {
            System.out.println("An error occurred"); e.printStackTrace();
        }
    }

    }
