package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Party;
import com.ironhack.rpg_simulator.fight.classes.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GamePage implements Page{

    String title = "Game Page";
    String prompt = "Pick 1 to start fight, 2 to fast fight, 3 to exit";
    Battle battle;
    List<Party> parties;
    List<Character> fighters;
    public GamePage(List<Party> parties) throws IOException {
        render();
        battle = new Battle(parties.get(0), parties.get(1));
        parties = parties;
        navigation();

    }

    @Override
    public void render() throws IOException {
        System.out.println(prompt);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine().split(" ")[0];
        Page nextPage;

        switch (selection){
            case "1":
                nextPage = new FighterPickPage(battle, parties);
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

    @Override
    public void navigation() throws IOException {

    }
}
