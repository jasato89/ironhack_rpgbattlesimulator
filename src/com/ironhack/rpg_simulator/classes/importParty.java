package com.ironhack.rpg_simulator.classes;


import java.io.File;   //Import File package to receive by parameter the CSV file to be read
import java.io.FileNotFoundException;   //Import File Exception to manage exception if the file wasn't found
import java.util.Scanner;   //Import Scanner package to read the CSV file
import java.util.ArrayList;   //Import ArrayList package to manage ArrayList

public class importParty {

    //Constructor required but the class isn't going to be initialized so it's private
    private importParty() {}

    //The only method in the class. It'll return a Party object created from the information in the CSV file
    //that we'll pass as a parameter
    public static Party importPartyCsv(File csvFile) {
        //To control the appearance of Exceptions, specifically if file isn't found, we start with a 'try'
        //to make sure that the code will be executed if no exceptions appear
        try {
            //Initializes the Scanner and ArrayList objects
            Scanner scannerCsv = new Scanner(csvFile);
            ArrayList<Character> partyArray = new ArrayList<Character>();

            //Skips the first line of the CSV with the field names
            scannerCsv.nextLine();
            //The following will be repeated for each line of data
            while(scannerCsv.hasNextLine()) {
                //Gets all the Character data and separates them into a String[] for each data
                String stringCharacter = scannerCsv.nextLine();
                String[] dataCharacter = stringCharacter.split(", ");

                if(dataCharacter[6].equals("")) {   //If it's a Warrior
                    //Creates a Warrior with the stats obtained and add them to the Character's Array
                    Warrior warrior = new Warrior(dataCharacter[2], Integer.parseInt(dataCharacter[3]), true,
                            Integer.parseInt(dataCharacter[4]), Integer.parseInt(dataCharacter[5]));
                    partyArray.add(warrior);
                } else {   //If it's a Wizard
                    //Creates a Wizard with the stats obtained and add them to the Character's Array
                    Wizard wizard = new Wizard(dataCharacter[2], Integer.parseInt(dataCharacter[3]), true,
                            Integer.parseInt(dataCharacter[6]), Integer.parseInt(dataCharacter[7]));
                    partyArray.add(wizard);
                }
            }
            //Closes the Scanner and returns the Party
            scannerCsv.close();
            Party partyCsv = new Party(partyArray);
            return partyCsv;

        } catch (FileNotFoundException e) {   //If the file isn't found, it prints an error message and returns null
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
