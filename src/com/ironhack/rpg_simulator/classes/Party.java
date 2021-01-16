package com.ironhack.rpg_simulator.classes;

import java.util.ArrayList;
import java.util.Random;

public class Party {

    private final int PARTY_LIMIT = 10;
    private ArrayList<Character> party;
    private String teamName;

    public Party(ArrayList<Character> party, String teamName) {
        this.party = party;
        this.teamName = teamName;
    }

    public Party(String teamName) {
        this.teamName = teamName;
        party = new ArrayList<>();
    }

    public void getAllMembers() {
        int i = 0;
        for (Character character : party) {
            System.out.println(i + " - " + character.toString());
            i++;
        }
    }

    public Character getMemberById(int id) {
        return party.get(id);
    }

    public ArrayList<Character> getParty() {
        return party;

    }

    public void addMember(Character member) {
        party.add(member);
    }

    public void removeMember(int id) {
        party.remove(id);
    }

    public void removeLast() {
        party.remove(party.size());
    }

    public ArrayList<Character> generateRandomParty() {
        party = new ArrayList<Character>();
        for (int i = 0; i < PARTY_LIMIT; i++) {
            boolean bool = new Random().nextBoolean();
            if (bool) {
                Character warrior = RandomCharacterDatabase.getRandomWarrior();
                if (!party.isEmpty()) {
                    for (Character name : party) {
                        if (warrior.getName().equals(name.getName())) {
                            warrior.setName(warrior.getName() + " Jr.");
                        }
                    }
                }
                party.add(warrior);
            } else {
                Character wizard = RandomCharacterDatabase.getRandomWizard();
                if (!party.isEmpty()) {
                    for (Character name : party) {
                        if (wizard.getName().equals(name.getName())) {
                            wizard.setName(wizard.getName() + " Jr.");
                        }
                    }
                }
                party.add(wizard);
            }
        }

        return party;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}
