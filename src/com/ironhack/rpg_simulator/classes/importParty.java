package com.ironhack.rpg_simulator.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class importParty {
    public importParty() {}

    public static Party importPartyCsv(File csvFile) {
        try {
            Scanner scannerCsv = new Scanner(csvFile);
            Party partyCsv = new Party();

            scannerCsv.nextLine();
            while(scannerCsv.hasNextLine()) {
                String stringCharacter = scannerCsv.nextLine();
                String[] dataCharacter = stringCharacter.split(", ");
                if(dataCharacter[6].equals("")) {
                    Warrior warrior = new Warrior(dataCharacter[2], Integer.parseInt(dataCharacter[3]), true,
                            Integer.parseInt(dataCharacter[4]), Integer.parseInt(dataCharacter[5]));
                    partyCsv.addCharacter(warrior);
                } else {
                    Wizard wizard = new Wizard(dataCharacter[2], Integer.parseInt(dataCharacter[3]), true,
                            Integer.parseInt(dataCharacter[6]), Integer.parseInt(dataCharacter[7]));
                    partyCsv.addCharacter(wizard);
                }
            }
            scannerCsv.close();
            return partyCsv;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}
