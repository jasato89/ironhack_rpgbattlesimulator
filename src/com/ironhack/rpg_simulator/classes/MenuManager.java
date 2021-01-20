package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.fight.classes.Battle;
import com.ironhack.rpg_simulator.fight.classes.RoundStats;
import com.ironhack.rpg_simulator.main.StoredParties;
import com.ironhack.rpg_simulator.ressources.Ressources;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//We will manage all the menus in this class
public class MenuManager {

    //Properties
    Scanner scanner = new Scanner(System.in);
    Party teamA;
    Party teamB;
    Battle battle;
    StoredParties storedParties;

    //This class doesn't need any constructor.

    //This method manage the main menu
    public void mainMenu() {
        //Here we print the main menu.
        //We insert the menu into a String so we can recall it in future if something goes wrong
        String mainMenuString = "Welcome to RPG Battle Simulator \n " +
                "Choose your option: \n " +
                "1.Play With Random Teams. \n " +
                "2.Play With Custom Teams. \n " +
                "3.Create New Team. \n " +
                "4.Exit the game.";
        System.out.println(mainMenuString);

        //This switch let us drive around the menu
        switch (Ressources.validateMenu("Elige una opcion correcta \n\n" + mainMenuString, "1|2|3|4")) {
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
                //finish the program
                System.out.println("Thanks for playing!");
                break;
            default:
                mainMenu();
        }
    }

    //This menu appear, when we choose a fight with customs or randoms teams
    public void modeMenu() {

        //Here we print modeMenu
        String modeMenuString = "Choose game mode: \n " +
                "1.Normal Mode (Choose your fighters). \n " +
                "2.Fast Mode (The fighters will be chosen randomly). \n " +
                "3.Return to Main Menu.";
        System.out.println(modeMenuString);


        //This switch let us drive around the menu
        switch (Ressources.validateMenu("Choose a correct option " + modeMenuString, "1|2|3")) {
            case 1:
                //show battleMenu (where you can select your fighters and see results of each encounter)
                battleMenu();
                break;
            case 2:
                //show battle results
                fastBattleMenu();
                break;
            case 3:
                mainMenu();
            default:
                Ressources.validateMenu("Choose a correct option", "1|2|3");
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

    //This menu let us create an own fighter
    public Character createCharacterMenu() {

        //add a name to our fighter
        System.out.println("Name: ");
        String name = scanner.nextLine();
        //Choose between a Warrior or a Wizard
        System.out.println("Choose 1 for a Warrior or 2 a Wizard: " );
        String className = null;
        switch (Ressources.validateMenu("Choose 1 for a Warrior or 2 a Wizard: ", "1|2")) {
            case 1:
                //show battleMenu (where you can select your fighters and see results of each encounter)
                className = "Warrior";
                break;
            case 2:
                //show battle results
                className = "Wizard";
                break;
            default:
                Ressources.validateMenu("Choose 1 for a Warrior or 2 a Wizard: ", "1|2");
        }

        //we add a Health to our fighter
        System.out.println("Health: ");
        int health = 0;

        //Here we validate a good Health for our fighter, depending on the class
        switch (className) {
            case "Warrior":
                //TODO: que no haya que hacer dos enter si el numero no es correcto
                String warriorHealthString = "Choose a life for your warrior, it should be bethween " + RandomDatabaseGenerator.getHpWarriorMin() + " and " + RandomDatabaseGenerator.getHpWarriorMax();
                System.out.println(warriorHealthString);
                health = Ressources.validateMenu("Choose a correct option \n" + warriorHealthString,"[0-9]+");
                if(Ressources.validateMenu("[0-9]+") > RandomDatabaseGenerator.getHpWarriorMax() || Ressources.validateMenu("[0-9]+") < RandomDatabaseGenerator.getHpWarriorMin()){
                    health = Ressources.validateMenu("Choose a correct option " + warriorHealthString,"[0-9]+");
                }
                break;
            case "Wizard":
                String wizardHealthString = "Choose a life for your warrior, it should be bethween " + RandomDatabaseGenerator.getHpWizardMin() + " and " + RandomDatabaseGenerator.getHpWizardMax();
                System.out.println(wizardHealthString);
                health = Ressources.validateMenu("Choose a correct option \n" + wizardHealthString,"[0-9]+");
                if(Ressources.validateMenu("[0-9]+") > RandomDatabaseGenerator.getHpWizardMax() || Ressources.validateMenu("[0-9]+") < RandomDatabaseGenerator.getHpWizardMin()){
                    health = Ressources.validateMenu("Choose a correct option","[0-9]+");
                }
                break;
            default:
                Ressources.validateMenu("Choose a correct option \n","[0-9]+");
        }


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
        announceTeamWinner(battle);
        introToReturnToMainMenu();
        }

    private void fastBattleMenu() {
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
        introToReturnToMainMenu();
    }

    public void announceTeamWinner(Battle battle) {
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

    public void introToReturnToMainMenu() {
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
