package com.ironhack.rpg_simulator.classes.database;

import com.ironhack.rpg_simulator.classes.character_management.Character;
import com.ironhack.rpg_simulator.classes.character_management.Party;
import com.ironhack.rpg_simulator.classes.character_management.Warrior;
import com.ironhack.rpg_simulator.classes.character_management.Wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ImportParty {

    //Constructor required but the class isn't going to be initialized so it's private
    private ImportParty() {}

    //The only method in the class. It'll return a Party object created from the information in the CSV file
    //that we'll pass as a parameter
    public static Party importPartyCsv(File csvFile) {
        try {
            Scanner scannerCsv = new Scanner(csvFile);
            ArrayList<Character> partyArray = new ArrayList<>();
            //Saves the Party name from the File name without '.csv'
            String partyName = csvFile.getName().substring(0, csvFile.getName().length() - 5);
            //Skips the first line of the CSV with the field names
            scannerCsv.nextLine();
            //The following will be repeated for each line of data
            while(scannerCsv.hasNextLine()) {
                //Gets all the Character data and separates them into a String[] for each data
                String stringCharacter = scannerCsv.nextLine();
                String[] dataCharacter = stringCharacter.split(", ");

                if(dataCharacter[5].equals("0")) {   //If it's a Warrior
                    //Creates a Warrior with the stats obtained and add them to the Character's Array
                    Warrior warrior = new Warrior(dataCharacter[1], Integer.parseInt(dataCharacter[2]),
                            Integer.parseInt(dataCharacter[3]), Integer.parseInt(dataCharacter[4]));
                    partyArray.add(warrior);
                } else {   //If it's a Wizard
                    //Creates a Wizard with the stats obtained and add them to the Character's Array
                    Wizard wizard = new Wizard(dataCharacter[1], Integer.parseInt(dataCharacter[2]),
                            Integer.parseInt(dataCharacter[5]), Integer.parseInt(dataCharacter[6]));
                    partyArray.add(wizard);
                }
            }
            //Closes the Scanner and returns the Party
            scannerCsv.close();
            return new Party(partyName, partyArray);

        } catch (FileNotFoundException e) {   //If the file isn't found, it prints an error message and returns null
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
