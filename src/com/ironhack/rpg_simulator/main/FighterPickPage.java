package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Party;
import com.ironhack.rpg_simulator.fight.classes.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FighterPickPage implements Page{

    String title = "Fighter Pick Page";
    String prompt = "1 to continue, 3 to main menu";
    List<Party> parties;
    List<Character> fighters;
    Battle battle;

    public FighterPickPage(Battle battle, List<Party> parties) throws IOException {
        this.parties = parties;
        this.battle = battle;
    }

    @Override
    public void render() throws IOException {
        System.out.println(title);
    }

    @Override
    public void navigation() throws IOException {
        System.out.println(prompt);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine().split(" ")[0];
        Page nextPage;

        switch (selection) {
            case "1":
                nextPage = new RoundPage(battle, parties, fighters);
                break;
            case "2":
                ; //navigate to ->
                break;
            case "3":
                nextPage = new MainMenu();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + selection);
        }
    }

    private void showParty(Party party){
        party.printAllMembers();
    }

    public List<Character> getFighters() throws IOException {

        showParty(parties.get(0));
        fighters.add(parties.get(0).getMemberFromList(selectFighter()));

        showParty(parties.get(1));
        fighters.add(parties.get(1).getMemberFromList(selectFighter()));

        return fighters;
    }

    private int selectFighter() throws IOException {
        System.out.println("Chose a fighter from this list: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine().split(" ")[0]);
    }
}
