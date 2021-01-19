package com.ironhack.rpg_simulator.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Party {
    private String name;
    private int partySize;
    private List<Character> partyMembers;
    private List<Character> aliveMembers;

    public Party(String name, List<Character> party) {
        this.name = name;
        this.partyMembers = party;
        aliveMembers = partyMembers;
    }


    public Party(int partySize) {
        this.name = RandomDatabaseGenerator.getRandomName();
        this.partySize = partySize;
        partyMembers = generateRandomParty(partySize);
        aliveMembers = partyMembers;
    }


    public List<Character> getAliveMembers() {
        return aliveMembers;
    }

    public void setAliveMembers(List<Character> aliveMembers) {
        this.aliveMembers = aliveMembers;
    }

    public void updateAliveMember(Character updatedMember, int index) {
        this.aliveMembers.set(index, updatedMember);
    }

    public int getPartyMaxSize() {
        return partySize;
    }

    public void removeAliveMember() {
        List<Character> temp = new ArrayList<>();
        for (Character character : aliveMembers) {
            if (character.isAlive())
                temp.add(character);
        }
        aliveMembers = temp;
    }

    public List<Character> generateRandomParty(int partySize) {
        partyMembers = new ArrayList<>();

        for (int i = 0; i < partySize; i++) {
            boolean bool = new Random().nextBoolean();
            if (bool) {
                Character warrior = RandomDatabaseGenerator.getRandomWarrior();
                if (!partyMembers.isEmpty()) {
                    for (Character name : partyMembers) {
                        if (warrior.getName().equals(name.getName())) {
                            warrior.setName(warrior.getName() + " Jr.");
                        }
                    }
                }
                partyMembers.add(warrior);
            } else {
                Character wizard = RandomDatabaseGenerator.getRandomWizard();
                if (!partyMembers.isEmpty()) {
                    for (Character name : partyMembers) {
                        if (wizard.getName().equals(name.getName())) {
                            wizard.setName(wizard.getName() + " Jr.");
                        }
                    }
                }
                partyMembers.add(wizard);
            }
        }

        return partyMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getMemberFromList(int index) {
        return partyMembers.get(index);
    }

    public Character getMemberFromAliveList(int index) {
        return aliveMembers.get(index);
    }

    public List<Character> getPartyMembers() {
        return partyMembers;

    }

    public void exportParty() throws IOException {
        File dir = new File("src/com/ironhack/rpg_simulator/csv_files");
        String fileName = getName() + ".csv";
        String[] pathNames = dir.list();
        int counter = 0;

        for (String path : pathNames) {
            if (path.toString().equals(fileName)) {
                counter++;
            }
        }
        if (counter > 0) {
            fileName += "_" + counter;
        }

        File file = new File("src/com/ironhack/rpg_simulator/csv_files/" + fileName);
        //file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("id, name, hp, stamina, strength, mana, intelligence\n");


        for (Character character : partyMembers) {
            if (character instanceof Warrior) {
                Warrior warrior = (Warrior) character;
                fileWriter.write(String.format("%s, %s, %d, %d, %d, 0, 0\n", warrior.getId(), warrior.getName(), warrior.getHp(), warrior.getStamina(), warrior.getStrength()));
            } else if (character instanceof Wizard) {
                Wizard wizard = (Wizard) character;
                fileWriter.write(String.format("%s, %s, %d, 0, 0, %d, %d\n", wizard.getId(), wizard.getName(), wizard.getHp(), wizard.getMana(), wizard.getIntelligence()));
            }

        }
        fileWriter.close();
    }

    public String aliveMembersString() {
        String result = "Party: " + name + "\n";
        int memberCount = 1;
        for (Character member : aliveMembers) {
            result += memberCount++ +": " + member.toString() + "\n";
        }
        return result;
    }
}
