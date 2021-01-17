package com.ironhack.rpg_simulator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayMenu implements Page{
    String title = "Play Menu";
    String prompt = "select 1 to play 2 to option 3 to exit";

    public PlayMenu() throws IOException {
        render();
        navigation();
    }

    @Override
    public void render() {
        System.out.println(title);
    }


    public void navigation() throws IOException {
        System.out.println(prompt);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine().split(" ")[0];
        Page nextPage;

        switch (selection){
            case "1":
                nextPage = new GamePage(new RandomTeamGeneration().generateTwoRandomTeam() );
                break;
            case "2":
                ; //navigate to -> select from existent parties
                break;
            case "3":
//                create a new party
                nextPage = new CreatePartyPage();
                break;
            case "4":
                nextPage = new MainMenu();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + selection);
        }
    }
}
