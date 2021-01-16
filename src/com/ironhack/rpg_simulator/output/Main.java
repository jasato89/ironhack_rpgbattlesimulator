package com.ironhack.rpg_simulator.output;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        OutputTerminal output = new OutputTerminal();
        startGame(output);
    }

    private static void startGame(OutputTerminal output) throws InterruptedException, IOException {
        playIntro(output);
        playMainMenu(output);


    }

    private static void playMainMenu(OutputTerminal output) throws IOException, InterruptedException {
        String selection = output.mainMenuRoutine();
        switch (selection){
            case "1":
                startPlayMenu(output);
                break;
            case "2":
                playOptionsMenu(output);
                break;
            case "3":
                //TODO EXIT
                break;
            default:
                playMainMenu(output);
        }

    }

    private static void playOptionsMenu(OutputTerminal output) {
        //TODO OPTION OUTPUT
    }

    private static void startPlayMenu(OutputTerminal output) throws IOException, InterruptedException {
        String selection = output.playMenuRoutine();
        switch (selection){
            case "1":
                playBattle(output);
                break;
            case "2":
                playTeamSelection(output);
                break;
            case "3":
                playCreateTeam(output);
                break;
            case "4":
                playMainMenu(output);
                break;
            default:
                startPlayMenu(output);
        }
    }

    private static void playCreateTeam(OutputTerminal output) {
        //TODO TEAM CREATION OUTPUT
        String selection = null;
        //TODO CALL OUTPUT UPDATED WITH TEAM NAME
        selection = null;
        //TODO analize the string to construct the player to add
        //TODO ADD A SWITCH TO ADD ONE MORE OR EXIT TO MAIN MENU
    }

    private static void playTeamSelection(OutputTerminal output) throws IOException, InterruptedException {
        //TODO TEAM SELECTION OUTPUT
        String selection = null;
        int indexTeamA = Integer.getInteger(selection);
        //TODO SELECTION TEAM TWO OUTPUT
        selection = null;
        int indexTeamB = Integer.getInteger(selection);
        playBattle(output, indexTeamA, indexTeamB);
    }

    private static void playBattle(OutputTerminal output, int indexTeamA, int indexTeamB) throws IOException, InterruptedException {
        //TODO IMPLEMENTS FIGHTS BETWEEN TO RANDOM GENERATED TEAMS
        String selection = null;
        switch (selection){
            case "1":
                playNextRound(output);
                break;
            case "2":
                //TODO
                break;
            case "3":
                playCreateTeam(output);
                break;
            case "4":
                playMainMenu(output);
                break;
            default:
                playBattle(output);
        }
    }

    private static void playBattle(OutputTerminal output) throws IOException, InterruptedException {
        //TODO IMPLEMENTS AN OUTPUT FOR BATTLE IS OVER AND IMPLEMENTS A MENU TO GO BACK TO MAIN MENU


        //TODO IMPLEMENTS FIGHTS BETWEEN TO RANDOM GENERATED TEAMS
        String selection = null;
        switch (selection){
            case "1":
                playNextRound(output);
                break;
            case "2":
                //TODO
                break;
            case "3":
                playCreateTeam(output);
                break;
            case "4":
                playMainMenu(output);
                break;
            default:
                playBattle(output);
        }
    }

    private static void playNextRound(OutputTerminal output) {
    }

    private static void playIntro(OutputTerminal output) throws IOException, InterruptedException {
        output.introRoutine();
    }

}
