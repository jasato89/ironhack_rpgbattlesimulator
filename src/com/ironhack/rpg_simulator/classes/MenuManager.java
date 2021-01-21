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
import java.util.Locale;
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

        PreRendering.setTitle("RPG BATTLE SIMULATOR");
        Output.printCentralMenu(new String []{
                "Play Random Teams.",
                "Play selected Teams.",
                "Create a new Team.",
                "Exit the game."});
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
        PreRendering.setTitle("RPG BATTLE SIMULATOR");
        Output.printCentralMenu(new String []{
                "Normal Mode",
                "Fast Mode",
                "Back",});

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
        //TODO I dont know why this doest work in terminal
        Party teamA;
        Party teamB;
        Output.printHeader("Select Team A", false);
//        System.out.println("Select Team A");
        int i = 1;
        for (Party party : storedParties.getTheList()) {
//            System.out.println((i++) + "." + party.getName());
            Output.printElementListLike((i++) + "." + party.getName(), 0);
        }


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


//        System.out.println("Select Team B");
        Output.printHeader("Select Team B", false);
        i = 1;
        for (Party party : storedParties.getTheList()) {
            if (i == selectionA) {   //We don't want to print the Team A selected
                //We can't change 'i' cause we use it on the print so we change the selection for Team A
                //to not enter on a infinite loop
                selectionA = 0;
            } else {
                Output.printElementListLike((i++) + "." + party.getName(), 0);
            }
        }


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
        Output.printHeader("Introduce team name: ");
//        System.out.println("Introduce the name of the team: ");
        String name = scanner.nextLine();
//        System.out.println("Introduce the size of the team");
        Output.printHeader("Introduce team size: ");
        int size = Integer.parseInt(scanner.nextLine());
        List<Character> members = new ArrayList<>();
        Output.clearConsole();
        Output.printStringCentered("RPG BATTLE SIMULATOR", 20);
        Output.printEmptyLines(3);
        for (int i = 0; i<size; i++) {
            Output.printHeader("Creation of member " + (i+1) + ": ");
            Thread.sleep(1000);
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

      Output.printHeader("Name:");
//        System.out.println("Name: ");
        String name = scanner.nextLine();
        Output.printHeader("Class (Warrior/Wizard): ");
//        System.out.println("Class (Warrior/Wizard): " );
        String className = scanner.nextLine();
        while (!className.equals("Warrior") && !className.equals("Wizard")) {
            System.out.println("Incorrect class, please enter again: ");
            className = scanner.nextLine();
        }
        Output.printHeader("Health: ");
//        System.out.println("Health: ");
        int health = Integer.parseInt(scanner.nextLine());
        if (className.equals("Warrior")) {
           Output.printHeader("Stamina: ");
//            System.out.println("Stamina: ");
            int stamina = Integer.parseInt(scanner.nextLine());
            Output.printHeader("Strength: ");
//            System.out.println("Strength: ");
            int strength = Integer.parseInt(scanner.nextLine());
            return new Warrior(name, health, stamina, strength);
        } else if (className.equals("Wizard")) {
            Output.printHeader("Mana: ");
//            System.out.println("Mana: ");
            int mana = Integer.parseInt(scanner.nextLine());
            Output.printHeader("Intelligence: ");
//            System.out.println("Intelligence: ");
            int intelligence = Integer.parseInt(scanner.nextLine());
            return new Warrior(name, health, mana, intelligence);
        }
        return null;
    }

    public void battleMenu() throws IOException, InterruptedException {
        int teamBIndex = 0;
        Output.printHeader("Battle Menu", false);
//        System.out.println("Battle Menu");
        while (battle.getParty1().getAliveMembers().size() > 0 && battle.getParty2().getAliveMembers().size() > 0) {
            Output.printHeader("Battle Menu", false);
            Output.printElementListLike(("Team B fighter is a " + battle.getParty2().getMemberFromAliveList(teamBIndex).getClassName()+ " name: " +
                    battle.getParty2().getMemberFromAliveList(teamBIndex).getName()).toUpperCase(Locale.ROOT),3);
//            System.out.println("Select your fighter: ");
            battle.getParty1().aliveMembersString();
//            System.out.println(battle.getParty1().aliveMembersString());
            Output.printElementListLike("Select your fighter: ", 1);
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
        Output.printHeader("Starting Fast Battle...");
//        System.out.println("Starting Fast Battle...");
        while (battle.getParty1().getAliveMembers().size() > 0 && battle.getParty2().getAliveMembers().size() > 0) {
            Output.printElementListLike("The team A fighter is a " + battle.getParty1().getMemberFromAliveList(0).getClassName()+ " called " +
                    battle.getParty1().getMemberFromAliveList(0).getName(), 0);
//            System.out.println("The team A fighter is a " + battle.getParty1().getMemberFromAliveList(0).getClassName()+ " called " +
//                    battle.getParty1().getMemberFromAliveList(0).getName());
            Output.printElementListLike("The team B fighter is a " + battle.getParty2().getMemberFromAliveList(0).getClassName()+ " called " +
                    battle.getParty2().getMemberFromAliveList(0).getName(), 0);
//            System.out.println("The team B fighter is a " + battle.getParty2().getMemberFromAliveList(0).getClassName()+ " called " +
//                    battle.getParty2().getMemberFromAliveList(0).getName());
            System.out.println();
            Output.printElementListLike("Starting round " + battle.getRoundNumber() + "...", 7);
//            System.out.println("Starting round " + battle.getRoundNumber() + "...");
            introToNextFight();
            RoundStats roundStats = battle.fight(0, 0);
            roundStats.printAttackLogs();
        }
        announceTeamWinner(battle);
        loadPartiesFromDatabase();
        introToReturnToMainMenu();
    }

    public void announceTeamWinner(Battle battle) {
        if (battle.getParty1().getAliveMembers().size() == 0) {
            System.out.println();
            Output.printElementListLike("Team " + battle.getParty2().getName() + " has won!!", 5);
            System.out.println();
//            System.out.println("Team " + battle.getParty2().getName() + " has won!!");
        } else if (battle.getParty2().getAliveMembers().size() == 0) {
            System.out.println();
            Output.printElementListLike("Team " + battle.getParty1().getName() + " has won!!", 5);
            System.out.println();
//            System.out.println("Team " + battle.getParty1().getName() + " has won!!");
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

    public void introToContinue() throws IOException, InterruptedException {
        Output.printElementListLike("Press intro to select the next fighter",1);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void introToNextFight() throws IOException, InterruptedException {
        Output.printElementListLike("Press intro to go to next fight",1);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void introToReturnToMainMenu() throws IOException, InterruptedException {
        Output.printElementListLike("Press intro to return to Main Menu", 1);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        mainMenu();
    }

    public void loadPartiesFromDatabase() {
        storedParties = new StoredParties();

        try {
            String fileName = "C:\\Users\\salva\\IdeaProjects\\IronHack-Java\\ironhack_rpgFINAL\\src\\com\\ironhack\\rpg_simulator\\csv_files";
//            String fileName = "src/com/ironhack/rpg_simulator/csv_files/";
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
