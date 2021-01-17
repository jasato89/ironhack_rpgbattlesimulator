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
    Battle battle;

    public FighterPickPage(Battle battle) throws IOException {
        this.battle = battle;
        render();
    }

    @Override
    public void render() throws IOException {
        System.out.println(title);
        Page nextPage = new RoundPage(battle, getFighters());
    }

    @Override
    public void navigation() throws IOException {
//
//        System.out.println(prompt);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String selection = br.readLine().split(" ")[0];
//        Page nextPage;
//
//        switch (selection) {
//            case "1":
//                nextPage = new RoundPage(battle, getFighters());
//                break;
//            case "2":
//                ; //navigate to ->
//                break;
//            case "3":
//                nextPage = new MainMenu();
//                break;
//
//            default:
//                throw new IllegalStateException("Unexpected value: " + selection);
//        }
    }



    public int[] getFighters() throws IOException {

        int[] fightersIndexes = new int[2];
        showParty(battle.getParty1());
        fightersIndexes[0] = selectFighter();

        showParty(battle.getParty2());
        fightersIndexes[1] = selectFighter();

        return fightersIndexes;
    }
    private void showParty(Party party){
        party.printAllMembers();
    }

    private int selectFighter() throws IOException {
        System.out.println("Chose a fighter from this list: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine().split(" ")[0]) - 1;
    }
}
