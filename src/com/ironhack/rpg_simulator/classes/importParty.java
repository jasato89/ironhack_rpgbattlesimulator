package com.ironhack.rpg_simulator.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class importParty {
    public importParty() {}

    public static Party importPartyCsv(File csvFile) {
        try {
            Scanner scannerCsv = new Scanner(csvFile);
            ArrayList<Character> partyArray = new ArrayList<Character>();

            scannerCsv.nextLine();
            while(scannerCsv.hasNextLine()) {
                String stringCharacter = scannerCsv.nextLine();
                String[] dataCharacter = stringCharacter.split(", ");
                if(dataCharacter[6].equals("")) {
                    Warrior warrior = new Warrior(dataCharacter[2], Integer.parseInt(dataCharacter[3]), true,
                            Integer.parseInt(dataCharacter[4]), Integer.parseInt(dataCharacter[5]));
                    partyArray.add(warrior);
                } else {
                    Wizard wizard = new Wizard(dataCharacter[2], Integer.parseInt(dataCharacter[3]), true,
                            Integer.parseInt(dataCharacter[6]), Integer.parseInt(dataCharacter[7]));
                    partyArray.add(wizard);
                }
            }
            scannerCsv.close();
            Party partyCsv = new Party(partyArray);
            return partyCsv;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
