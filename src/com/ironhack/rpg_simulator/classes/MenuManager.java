package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.fight.classes.Battle;
import com.ironhack.rpg_simulator.fight.classes.RoundStats;
import com.ironhack.rpg_simulator.main.StoredParties;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
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
                battleMenu();
                break;
            case 2:
                //TODO: show battle results
                fastBattleMenu();
                break;
            default:
                mainMenu();
        }
    }

    public void selectTeamsFromDatabaseMenu() {
        Party teamA;
        Party teamB;

        System.out.println("Select Team A");
        int i = 0;
        for (Party party : storedParties.getTheList()) {
            System.out.println(i++ + "." + party.getName());
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

        System.out.println("Select Team B");
        i = 0;
        for (Party party : storedParties.getTheList()) {
            System.out.println(i++ + "." + party.getName());
        }

        input = scanner.nextLine();
        pattern = Pattern.compile("\\d");
        matcher = pattern.matcher(input);
        while (!matcher.matches() && Integer.parseInt(input) <= storedParties.getTheList().size()) {
            System.out.println("The value introduced is not correct:");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        selection = Integer.parseInt(input);

        teamB = storedParties.getTheList().get(selection - 1);

        battle = new Battle(teamA, teamB);
        modeMenu();
    }

    public void createTeamMenu() {
        System.out.println("Introduce the name of the team: ");
        String name = scanner.nextLine();
        System.out.println("Introduce the size of the team");
        int size = Integer.parseInt(scanner.nextLine());
        List<Character> members = new ArrayList<>();
        for (int i = 0; i<size; i++) {
            System.out.println("Creation of member " + (i+1) + ":");
            members.add(createCharacterMenu());
        }
        storedParties.add(new Party(name, members));
        System.out.println("The team " + name + " has been created succesfully.");
    }

    public Character createCharacterMenu() {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Class (Warrior/Wizard): " );
        String className = scanner.nextLine();
        while (!className.equals("Warrior") && !className.equals("Wizard")) {
            System.out.println("Incorrect class, please enter again: ");
            className = scanner.nextLine();
        }
        System.out.println("Health: ");
        int health = Integer.parseInt(scanner.nextLine());
        if (className.equals("Warrior")) {
            System.out.println("Stamina: ");
            int stamina = Integer.parseInt(scanner.nextLine());
            System.out.println("Strength: ");
            int strength = Integer.parseInt(scanner.nextLine());
            return new Warrior(name, health, stamina, strength);
        } else if (className.equals("Wizard")) {
            System.out.println("Mana: ");
            int mana = Integer.parseInt(scanner.nextLine());
            System.out.println("Intelligence: ");
            int intelligence = Integer.parseInt(scanner.nextLine());
            return new Warrior(name, health, mana, intelligence);
        }
        return null;
    }

    public void battleMenu() {
        int teamBIndex = 0;
        System.out.println("Battle Menu");
        while (battle.getParty1().getAliveMembers().size() > 0 && battle.getParty2().getAliveMembers().size() > 0) {
            System.out.println("The team B fighter is a " + battle.getParty2().getMemberFromAliveList(teamBIndex).getClassName()+ " called " +
                    battle.getParty2().getMemberFromAliveList(teamBIndex).getName());
            System.out.println("Select your fighter: ");
            System.out.println(battle.getParty1().aliveMembersString());
            int teamAIndex = Integer.parseInt(scanner.nextLine());
            System.out.println("Starting fight...");
            RoundStats roundStats = battle.fight(teamAIndex, teamBIndex);
            roundStats.printAttackLogs();
        }
        announceTeamWinner();
        }

    private void fastBattleMenu() {

    }

    public void announceTeamWinner() {
        if (battle.getParty1().getAliveMembers().size() == 0) {
            System.out.println("Team " + battle.getParty2().getName() + " has won!!");
        } else if (battle.getParty2().getAliveMembers().size() == 0) {
            System.out.println("Team " + battle.getParty1().getName() + " has won!!");
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
        modeMenu();
    }

    public void mainMenuOption3() {
        createTeamMenu();
        mainMenu();
    }

    public void loadPartiesFromDatabase() {
        StoredParties storedParties = new StoredParties();
        File databaseDirParent = new File(".");
        databaseDirParent = databaseDirParent.getParentFile();
        File databaseDir = new File(databaseDirParent.getParentFile(),"/csv_files/");

        File[] partiesFiles = databaseDir.listFiles();
        for (File f: partiesFiles) {
            storedParties.add(ImportParty.importPartyCsv(f));
        }

    }
}
