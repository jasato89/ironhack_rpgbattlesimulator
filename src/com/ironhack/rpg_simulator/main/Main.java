package com.ironhack.rpg_simulator.main;


import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Party;
import com.ironhack.rpg_simulator.fight.classes.AttackStats;
import com.ironhack.rpg_simulator.fight.classes.Battle;
import com.ironhack.rpg_simulator.fight.classes.RoundStats;
import com.ironhack.rpg_simulator.output.OutputTerminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        OutputTerminal output = new OutputTerminal();
        playBattle(output);
//        startGame(output);
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

    private static void playOptionsMenu(OutputTerminal output) throws IOException, InterruptedException {
        System.out.println("Option menu, 1 to import, 2 to export, 3 to exit");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine();
        switch (selection){
            case "1":
                //TODO Import from CSV
                break;
            case "2":
                //TODO Export to CSV
                break;
            case "3":
                //TODO EXIT
                break;
            default:
                playOptionsMenu(output);
        }
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

    private static void playCreateTeam(OutputTerminal output) throws IOException, InterruptedException {
        String teamNamePrompt = "Type new team name:";
        String[] teamName = output.createTeamRoutine(teamNamePrompt, "" , "");
        //TODO CREATE TEAM WITH NAME

        String charNamePrompt = "Type new character 'name':";
        String[] charName = output.createTeamRoutine(charNamePrompt, Arrays.toString(teamName), "" );
        String charClassPrompt = "Type new character 'class':";
        String[] charClass = output.createTeamRoutine(charClassPrompt, Arrays.toString(teamName), Arrays.toString(charName) );
        String charStatsPrompt = "Type: 'hp main_stats second_stats' values:";
        String charString = Arrays.toString(charName) + Arrays.toString(charClass);
        String[] charStats = output.createTeamRoutine(charStatsPrompt, Arrays.toString(teamName), charString);
        charString += Arrays.toString(charStats);

        //TODO ADD CHAR TO TEAM

        //TODO OUTPUT WITH ALL TEAM
        String continueCreateCharPrompt = "";
        String[] selection = output.createTeamRoutine(continueCreateCharPrompt, Arrays.toString(teamName), charString);

        switch (selection[0]){
            case "1":
                //TODO ADD ONE MORE
                break;
            case "2":
                playMainMenu(output);
                break;

            default:
                playMainMenu(output);
        }
    }

    private static void playTeamSelection(OutputTerminal output) throws IOException, InterruptedException {

        int indexTeamA = 0, indexTeamB = 0;

        //TODO Print all team INDEX + NAME

        //TODO Ask for index

        //TODO save decision

        //TODO Print all team INDEX + NAME

        //TODO Ask for index

        //TODO save decision


        //playBattle(output, indexTeamA, indexTeamB);

    }

    private static void playBattle(OutputTerminal output, int indexTeamA, int indexTeamB) throws IOException, InterruptedException {
        //TODO IMPLEMENTS FIGHTS

        System.out.println("Options...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine();
        switch (selection){
            case "1":
                //todo pick fighters
                playNextRound(output);
                break;
            case "2":
                //TODO fast battle
                break;
            case "3":
                //TODO NADA
                break;
            case "4":
                playMainMenu(output);
                break;
            default:
                //TODO see case 1
        }
    }

    private static void playBattle(OutputTerminal output) throws IOException, InterruptedException {
        //TODO IMPLEMENTS AN OUTPUT FOR BATTLE IS OVER AND IMPLEMENTS A MENU TO GO BACK TO MAIN MENU

        Party teamA = new Party(5);
        Party teamB = new Party(5);

        Battle battle = new Battle(teamA, teamB);

        //TODO output 2 team and options to start fight

        output.enterBattleRoutine(teamA, teamB);


        //TODO IMPLEMENTS FIGHTS BETWEEN TO RANDOM GENERATED TEAMS
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine();
        switch (selection){
            case "1":
                //todo pick fighters
                Character fighterTeamA = pickFighter(output, teamA);
                Character fighterTeamB = pickFighter(output, teamB);
                playNextRound(output, battle, fighterTeamA, fighterTeamB );
                //TODO output fight
                break;
            case "2":
                //TODO fast battle
                break;
            case "3":
                //TODO NADA
                break;
            case "4":
                playMainMenu(output);
                break;
            default:
                //TODO see case 1
        }
    }

    private static void playNextRound(OutputTerminal output, Battle battle, Character fighterTeamA, Character fighterTeamB) throws IOException, InterruptedException {
        RoundStats roundStats = battle.fight(fighterTeamA, fighterTeamB);
        List<AttackStats> attackStats = roundStats.getAttackLogs();
        for (AttackStats attack : attackStats ) {
            output.roundRoutine(battle, fighterTeamA, fighterTeamB, attack);
        }
    }

    private static Character pickFighter(OutputTerminal output, Party teamA) throws IOException, InterruptedException {
        output.pickFighterRoutine(teamA);
        System.out.println("Enter the index of the fighter u want to pick:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String r = br.readLine();
        String [] rArray = r.split(" ");
        int selection = Integer.parseInt(rArray[0]);
        return teamA.getMemberFromList(selection);
    }

    private static void playNextRound(OutputTerminal output) {



        //print
    }

    private static void playIntro(OutputTerminal output) throws IOException, InterruptedException {
        output.introRoutine();
    }

}
