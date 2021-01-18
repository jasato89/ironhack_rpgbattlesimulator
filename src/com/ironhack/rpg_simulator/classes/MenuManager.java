package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.fight.classes.Battle;
import com.ironhack.rpg_simulator.main.StoredParties;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuManager {
    Scanner scanner = new Scanner(System.in);
    Party teamA;
    Party teamB;
    Battle battle;
    StoredParties storedParties;

    public void mainMenu() {
        System.out.println("Welcome to RPG Battle Simulator");
        System.out.println("Choose your option: ");
        System.out.println("1.Play With Random Teams.");
        System.out.println("2.Play With Custom Teams.");
        System.out.println("3.Create New Team.");
        System.out.println("4.Exit the game.");

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("1|2|3|4");
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println("The value introduced is not correct:");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        int selection = Integer.parseInt(input);

        switch (selection) {
            case 1:
                mainMenuOption1();
                break;
            case 2:
                //TODO: select two teams from database and show modeMenu
                mainMenuOption2();
                break;
            case 3:
                //TODO show teamCustomization
                break;
            case 4:
                System.out.println("Thanks for playing!");
                break;
            default:
                mainMenu();
        }
    }

    public void modeMenu() {
        System.out.println("Choose game mode:");
        System.out.println("1.Choose your fighters.");
        System.out.println("2.The fighters will be chosen randomly.");
        System.out.println("3.Return to Main Menu.");

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("1|2|3|4");
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println("The value introduced is not correct:");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        int selection = Integer.parseInt(input);

        switch (selection) {
            case 1:
                //TODO: show battleMenu (where you can select your fighters and see results of each encounter)
                break;
            case 2:
                //TODO: select two teams from database and show gameType
                break;
            case 3:
                //TODO show teamCustomization
                break;
            case 4:
                System.out.println("Thanks for playing!");
                break;
            default:
                mainMenu();
        }
    }

    public void selectTeamsFromDatabaseMenu() {

        System.out.println("Select Team A");
        for (Party party: storedParties) {

        }
    }


    public void mainMenuOption1() {
        teamA = new Party(5);
        teamB = new Party(5);
        battle = new Battle(teamA, teamB);
        modeMenu();
    }

    public void mainMenuOption2() {
        selectTeamsFromDatabaseMenu();
    }
}
