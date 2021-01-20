package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.fight.classes.Battle;
import com.ironhack.rpg_simulator.fight.classes.RoundStats;
import com.ironhack.rpg_simulator.main.StoredParties;
import com.ironhack.rpg_simulator.output_lib.Output;
import com.ironhack.rpg_simulator.output_lib.PreRendering;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuManager {
    Scanner scanner = new Scanner(System.in);
    Party teamA;
    Party teamB;
    Battle battle;
    StoredParties storedParties;

    public void mainMenu() throws IOException, InterruptedException {
        char [][] screen = PreRendering.prepareScreenMenuCentral(PreRendering.getScreenEmpty(),
                new String []{
                        "Play Random Teams.",
                        "Play selected Teams.",
                        "Create a new Team.",
                        "Exit the game."});
        PreRendering.setTitle("RPG BATTLE SIMULATOR");
        Output.clearConsole();
        Output.printScreen(screen);
//        System.out.println("Welcome to RPG Battle Simulator");
//        System.out.println("Choose your option: ");
//        System.out.println("1.Play With Random Teams.");
//        System.out.println("2.Play With Custom Teams.");
//        System.out.println("3.Create New Team.");
//        System.out.println("4.Exit the game.");

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
                //generate two random teams and show modeMenu
                mainMenuOption1();
                break;
            case 2:
                //select two teams from database and show modeMenu
                mainMenuOption2();
                break;
            case 3:
                //show teamCustomization
                mainMenuOption3();
                break;
            case 4:
                System.out.println("Thanks for playing!");
                System.exit(0);
                break;
            default:
                mainMenu();
        }
    }

    public void modeMenu() throws IOException, InterruptedException {
        char [][] screen = PreRendering.prepareScreenMenuCentral(PreRendering.getScreenEmpty(),
                new String []{
                        "Normal Mode (Choose your fighters)",
                        "Fast Mode (The fighters will be chosen randomly)",
                        "Return to Main Menu",});
        PreRendering.setTitle("RPG BATTLE SIMULATOR");
        Output.clearConsole();
        Output.printScreen(screen);
//        System.out.println("Choose game mode:");
//        System.out.println("1.Normal Mode (Choose your fighters).");
//        System.out.println("2.Fast Mode (The fighters will be chosen randomly).");
//        System.out.println("3.Return to Main Menu.");

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("1|2|3");
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println("The value introduced is not correct:");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        int selection = Integer.parseInt(input);

        switch (selection) {
            case 1:
                //show battleMenu (where you can select your fighters and see results of each encounter)
                battleMenu();
                break;
            case 2:
                //show battle results
                fastBattleMenu();
                break;
            default:
                mainMenu();
        }
    }

    public void selectTeamsFromDatabaseMenu() throws IOException, InterruptedException {
        Party teamA;
        Party teamB;
        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
//        System.out.println("Select Team A");
        int i = 1;
        for (Party party : storedParties.getTheList()) {
            Output.printStringCentered(i++ + "." + party.getName(), 6);
//            System.out.println(i++ + "." + party.getName());
        }
        Output.printEmptyLines(1);
        Output.printCentralBottomUniqueMenu("Select Team A");
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches() && Integer.parseInt(input) <= storedParties.getTheList().size()) {
            System.out.println("The value introduced is not correct:");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        int selection = Integer.parseInt(input);
        teamA = storedParties.getTheList().get(selection - 1);
        int selectionA = Integer.parseInt(input);

        teamA = storedParties.getTheList().get(selectionA - 1);

        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
//        System.out.println("Select Team B");
        i = 1;
        for (Party party : storedParties.getTheList()) {
            if (i == selectionA) {   //We don't want to print the Team A selected
                //We can't change 'i' cause we use it on the print so we change the selection for Team A
                //to not enter on a infinite loop
                selectionA = 0;
            } else {
                Output.printStringCentered(i++ + "." + party.getName(), 6);
            }
        }
        Output.printEmptyLines(1);
        Output.printCentralBottomUniqueMenu("Select Team A");

        //We need to recover the selection to Team A to select correctly the Team B from storedParties
        selectionA = Integer.parseInt(input);

        input = scanner.nextLine();
        pattern = Pattern.compile("\\d");
        matcher = pattern.matcher(input);
        while (!matcher.matches() && Integer.parseInt(input) <= storedParties.getTheList().size()) {
            System.out.println("The value introduced is not correct:");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        int selectionB = Integer.parseInt(input);

        if(selectionB < selectionA) {
            teamB = storedParties.getTheList().get(selectionB - 1);
        } else {
            teamB = storedParties.getTheList().get(selectionB + 1 - 1);
        }
        battle = new Battle(teamA, teamB);
        modeMenu();
    }

    public void createTeamMenu() throws IOException, InterruptedException {
        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
        Output.printStringCentered("Introduce the name of the team: ", 6);
        Output.printEmptyLines(10);
//        System.out.println("Introduce the name of the team: ");
        String name = scanner.nextLine();
        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
        Output.printStringCentered("Introduce the size of the team: ", 6);
        Output.printEmptyLines(10);
//        System.out.println("Introduce the size of the team");
        int size = Integer.parseInt(scanner.nextLine());
        List<Character> members = new ArrayList<>();
        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
        for (int i = 0; i<size; i++) {
            Output.printStringCentered("Creation of member " + (i+1) + ": ", 6);
//            System.out.println("Creation of member " + (i+1) + ":");
            members.add(createCharacterMenu());
        }
        Party newParty = new Party(name, members);
        storedParties.add(newParty);
        newParty.exportParty();
        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
        Output.printStringCentered("The team " + name + " has been created succesfully.", 6);
        Output.printEmptyLines(10);
//        System.out.println("The team " + name + " has been created succesfully.");
    }

    public Character createCharacterMenu() throws IOException, InterruptedException {
        //TODO need to refactor this method in shorter ones also it would be good to print the character while is being created with a to string

        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
        Output.printStringCentered("Name: ", 6);
        Output.printEmptyLines(10);
//        System.out.println("Name: ");
        String name = scanner.nextLine();
        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
        Output.printStringCentered("Class (Warrior/Wizard): ", 6);
        Output.printEmptyLines(10);
//        System.out.println("Class (Warrior/Wizard): " );
        String className = scanner.nextLine();
        while (!className.equals("Warrior") && !className.equals("Wizard")) {
            System.out.println("Incorrect class, please enter again: ");
            className = scanner.nextLine();
        }
        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
        Output.printStringCentered("Health: ", 6);
        Output.printEmptyLines(10);
//        System.out.println("Health: ");
        int health = Integer.parseInt(scanner.nextLine());
        if (className.equals("Warrior")) {
            Output.clearConsole();
            Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
            Output.printEmptyLines(3);
            Output.printStringCentered("Stamina: ", 6);
            Output.printEmptyLines(10);
//            System.out.println("Stamina: ");
            int stamina = Integer.parseInt(scanner.nextLine());
            Output.clearConsole();
            Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
            Output.printEmptyLines(3);
            Output.printStringCentered("Strength: ", 6);
            Output.printEmptyLines(10);
//            System.out.println("Strength: ");
            int strength = Integer.parseInt(scanner.nextLine());
            return new Warrior(name, health, stamina, strength);
        } else if (className.equals("Wizard")) {
            Output.clearConsole();
            Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
            Output.printEmptyLines(3);
            Output.printStringCentered("Mana: ", 6);
            Output.printEmptyLines(10);
//            System.out.println("Mana: ");
            int mana = Integer.parseInt(scanner.nextLine());
            Output.clearConsole();
            Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
            Output.printEmptyLines(3);
            Output.printStringCentered("Intelligence: ", 6);
            Output.printEmptyLines(10);
//            System.out.println("Intelligence: ");
            int intelligence = Integer.parseInt(scanner.nextLine());
            return new Warrior(name, health, mana, intelligence);
        }
        return null;
    }

    public void battleMenu() throws IOException, InterruptedException {
        int teamBIndex = 0;
        System.out.println("Battle Menu");
        while (battle.getParty1().getAliveMembers().size() > 0 && battle.getParty2().getAliveMembers().size() > 0) {
            System.out.println("The team B fighter is a " + battle.getParty2().getMemberFromAliveList(teamBIndex).getClassName()+ " called " +
                    battle.getParty2().getMemberFromAliveList(teamBIndex).getName());
            System.out.println("Select your fighter: ");
            System.out.println(battle.getParty1().aliveMembersString());
            int teamAIndex = Integer.parseInt(scanner.nextLine());
            System.out.println("Starting fight...");
            RoundStats roundStats = battle.fight(teamAIndex - 1, teamBIndex);
            roundStats.printAttackLogs();
            introToContinue();
        }
        announceTeamWinner(battle);
        loadPartiesFromDatabase();
        introToReturnToMainMenu();
        }

    private void fastBattleMenu() throws IOException, InterruptedException {
        System.out.println("Starting Fast Battle...");
        while (battle.getParty1().getAliveMembers().size() > 0 && battle.getParty2().getAliveMembers().size() > 0) {
            System.out.println("The team A fighter is a " + battle.getParty1().getMemberFromAliveList(0).getClassName()+ " called " +
                    battle.getParty1().getMemberFromAliveList(0).getName());
            System.out.println("The team B fighter is a " + battle.getParty2().getMemberFromAliveList(0).getClassName()+ " called " +
                    battle.getParty2().getMemberFromAliveList(0).getName());
            System.out.println("Starting round " + battle.getRoundNumber() + "...");
            RoundStats roundStats = battle.fight(0, 0);
            roundStats.printAttackLogs();
        }
        announceTeamWinner(battle);
        loadPartiesFromDatabase();
        introToReturnToMainMenu();
    }

    public void announceTeamWinner(Battle battle) {
        if (battle.getParty1().getAliveMembers().size() == 0) {
            System.out.println("Team " + battle.getParty2().getName() + " has won!!");
        } else if (battle.getParty2().getAliveMembers().size() == 0) {
            System.out.println("Team " + battle.getParty1().getName() + " has won!!");
        }
    }
    public void mainMenuOption1() throws IOException, InterruptedException {
        teamA = new Party(5);
        teamB = new Party(5);
        battle = new Battle(teamA, teamB);
        modeMenu();
    }

    public void mainMenuOption2() throws IOException, InterruptedException {
        selectTeamsFromDatabaseMenu();
        modeMenu();
    }

    public void mainMenuOption3() throws IOException, InterruptedException {
        createTeamMenu();
        mainMenu();
    }

    public void introToContinue() {
        System.out.println("Press intro to select the next fighter");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public void introToReturnToMainMenu() throws IOException, InterruptedException {
        System.out.println("Press intro to return to Main Menu");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        mainMenu();
    }

    public void loadPartiesFromDatabase() {
        storedParties = new StoredParties();

        try {
            String fileName = "src/com/ironhack/rpg_simulator/csv_files/";
            File databaseDir = new File(fileName);

            File[] partiesFiles = databaseDir.listFiles();
            for (File f : partiesFiles) {
                storedParties.add(ImportParty.importPartyCsv(f));
            }
        } catch (Exception e) {
            System.out.println("Database not found");
        }

    }
}
