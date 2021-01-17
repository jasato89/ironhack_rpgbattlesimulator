package com.ironhack.rpg_simulator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu implements Page{

    private String title = "Main Menu";
    private String prompt = "select 1 to play 2 to option 3 to exit";

    public MainMenu() throws IOException {
        render();
        navigation();
    }

    @Override
    public void render() {
        System.out.println(title);
    }

    @Override
    public void navigation() throws IOException {
        System.out.println(prompt);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine().split(" ")[0];
        Page nextPage;

        switch (selection){
            case "1":
                nextPage = new PlayMenu();
                break;
            case "2":
                ; //navigate to ->
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + selection);
        }
    }
}
