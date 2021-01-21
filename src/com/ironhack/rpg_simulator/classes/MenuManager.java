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
        switch (Ressources.validateIntMenu("Elige una opcion correcta \n\n" + mainMenuString, "1|2|3|4")) {
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
                System.exit(0);
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
        switch (Ressources.validateIntMenu("Choose a correct option " + modeMenuString, "1|2|3")) {
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

    public void selectTeamsFromDatabaseMenu() {
        Party teamA;
        Party teamB;
        System.out.println("Select Team A");
        int i = 1;
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
        int selectionA = Integer.parseInt(input);

        teamA = storedParties.getTheList().get(selectionA - 1);

        System.out.println("Select Team B");
        i = 1;
        for (Party party : storedParties.getTheList()) {
            if (i == selectionA) {   //We don't want to print the Team A selected
                //We can't change 'i' cause we use it on the print so we change the selection for Team A
                //to not enter on a infinite loop
                selectionA = 0;
            } else {
                System.out.println(i++ + "." + party.getName());
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

    public void createTeamMenu() {
        System.out.println("Introduce the name of the team: ");
        String name = Ressources.validateStringMenu("Name must only contain letters. Please choose a valid name:", "[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+");
        System.out.println("Introduce the size of the team");
        int size = Ressources.validateIntMenu("Size must be an integer. Please choose a valid size:", "[0-9]+");
        List<Character> members = new ArrayList<>();
        for (int i = 0; i<size; i++) {
            System.out.println("Creation of member " + (i+1) + ":");
            members.add(createCharacterMenu());
        }
        Party newParty = new Party(name, members);
        storedParties.add(newParty);
        newParty.exportParty();
        System.out.println("The team " + name + " has been created succesfully.");
    }

    //This menu let us create an own fighter
    public Character createCharacterMenu() {

        //properties
        String name;
        int health = 0;
        int stamina = 0;
        int strength = 0;
        int mana = 0;
        int intelligence = 0;
        String className = null;

        //add a name to our fighter
        System.out.println("Name: ");
        name = Ressources.validateStringMenu("Name must only contain letters. Please choose a valid name:", "[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+");
        //Choose between a Warrior or a Wizard
        System.out.println("Choose 1 for a Warrior or 2 a Wizard: ");
        switch (Ressources.validateIntMenu("Invalid selection.\nChoose 1 for a Warrior or 2 a Wizard: ", "1|2")) {
            case 1:
                //show battleMenu (where you can select your fighters and see results of each encounter)
                className = "Warrior";
                break;
            case 2:
                //show battle results
                className = "Wizard";
                break;
            default:
                Ressources.validateIntMenu("Choose 1 for a Warrior or 2 a Wizard: ", "1|2");
        }

        //we add a Health to our fighter
        System.out.println("Health: ");
        //Here we validate a good Health for our fighter, depending on the class
        switch (className) {
            case "Warrior":
                String warriorHealthString = "Choose the health for your warrior, it should be between " + RandomDatabaseGenerator.getHpWarriorMin() + " and " + RandomDatabaseGenerator.getHpWarriorMax();
                System.out.println(warriorHealthString);
                health = Ressources.validateIntMenu("Choose a correct option \n" + warriorHealthString, "[0-9]+");
                while (health > RandomDatabaseGenerator.getHpWarriorMax() || health < RandomDatabaseGenerator.getHpWarriorMin()) {
                    System.out.println("Choose a correct option");
                    health = Ressources.validateIntMenu( warriorHealthString, "[0-9]+");
                }

                break;
            case "Wizard":
                String wizardHealthString = "Choose the health for your Wizard, it should be between " + RandomDatabaseGenerator.getHpWizardMin() + " and " + RandomDatabaseGenerator.getHpWizardMax();
                System.out.println(wizardHealthString);
                health = Ressources.validateIntMenu("Choose a correct option \n" + wizardHealthString, "[0-9]+");
                while (health > RandomDatabaseGenerator.getHpWizardMax() || health < RandomDatabaseGenerator.getHpWizardMin()) {
                    System.out.println("Choose a correct option");
                    health = Ressources.validateIntMenu(wizardHealthString, "[0-9]+");
                }
                break;
            default:
                Ressources.validateIntMenu("Choose a correct option \n", "[0-9]+");
        }

        //we add Stamina + Strength if we get a warrior or Mana + Inteligence if we get a Wizard
        switch (className) {
            case "Warrior":
                //we check the stamina
                String staminaString = "Add stamina to your warrior, it should be between " + RandomDatabaseGenerator.getStaminaMin() + " and " + RandomDatabaseGenerator.getStaminaMax();
                System.out.println(staminaString);
                stamina = Ressources.validateIntMenu("Choose a correct option \n" + staminaString, "[0-9]+");
                while (stamina > RandomDatabaseGenerator.getStaminaMax() || stamina < RandomDatabaseGenerator.getStaminaMin()) {
                    System.out.println("Choose a correct option");
                    stamina = Ressources.validateIntMenu(staminaString, "[0-9]+");
                }

                //we check the strength
                String strengthString ="Add Strength to your warrior, it should be between " + RandomDatabaseGenerator.getStrengthMin() + " and " + RandomDatabaseGenerator.getStrengthMax();
                System.out.println(strengthString);
                strength = Ressources.validateIntMenu("Choose a correct option \n" + strengthString, "[0-9]+");
                while (strength > RandomDatabaseGenerator.getStrengthMax() || strength < RandomDatabaseGenerator.getStrengthMin()) {
                    System.out.println("Choose a correct option");
                    strength = Ressources.validateIntMenu(strengthString, "[0-9]+");
                }
                break;
            case "Wizard":
                //we check the mana
                String manaString ="Add Mana to your Wizard, it should be between " + RandomDatabaseGenerator.getManaMin() + " and " + RandomDatabaseGenerator.getManaMax();
                System.out.println(manaString);
                mana = Ressources.validateIntMenu("Choose a correct option \n" + manaString, "[0-9]+");
                while (mana > RandomDatabaseGenerator.getManaMax() || mana < RandomDatabaseGenerator.getManaMin()) {
                    System.out.println("Choose a correct option");
                    mana = Ressources.validateIntMenu(manaString, "[0-9]+");
                }
                //we check the intelligence
                String intelligenceString ="Add Intelligence to your Wizard, it should be between " + RandomDatabaseGenerator.getIntelligenceMin() + " and " + RandomDatabaseGenerator.getIntelligenceMax();
                System.out.println(intelligenceString);
                intelligence = Ressources.validateIntMenu("Choose a correct option \n" + "Intelligence", "[0-9]+");
                while (intelligence > RandomDatabaseGenerator.getIntelligenceMax() || intelligence < RandomDatabaseGenerator.getIntelligenceMin()) {
                    System.out.println("Choose a correct option");
                    intelligence = Ressources.validateIntMenu(intelligenceString, "[0-9]+");
                }
                break;
            default:
                System.out.println("Error in the class.");
        }

        if (className.equals("Warrior")) {
            return new Warrior(name, health, stamina, strength);
        } else if (className.equals("Wizard")) {
            return new Wizard(name, health, mana, intelligence);
        }
        return null;
    }

    public void battleMenu() {
        int teamBIndex = 0;
        int graveyardOption = 1;
        System.out.println("Battle Menu");
        while (battle.getParty1().getAliveMembers().size() > 0 && battle.getParty2().getAliveMembers().size() > 0 && graveyardOption == 1) {
            System.out.println("The team B fighter is a " + battle.getParty2().getMemberFromAliveList(teamBIndex).getClassName()+ " called " +
                    battle.getParty2().getMemberFromAliveList(teamBIndex).getName());
            System.out.println("Select your fighter: ");
            System.out.println(battle.getParty1().aliveMembersString());
            int teamAIndex = Ressources.validateIntMenu("Invalid index.", "[0-9]+");
            while (teamAIndex > battle.getParty1().getAliveMembers().size() || teamAIndex <= 0) {
                System.out.println("Invalid index.");
                teamAIndex = Ressources.validateIntMenu("Invalid index.", "[0-9]+");
            }
            System.out.println("Starting fight...");
            RoundStats roundStats = battle.fight(teamAIndex - 1, teamBIndex);
            roundStats.printAttackLogs();
            if (battle.getParty1().getAliveMembers().size() > 0 && battle.getParty2().getAliveMembers().size() > 0) {
                graveyardOption = battleMenuWithGraveyard();
                while ( graveyardOption == 2 ) {
                    showGraveyard();
                    graveyardOption = battleMenuWithGraveyard();
                }
            }
        }
        if (graveyardOption == 3) {
            loadPartiesFromDatabase();
            mainMenu();
        } else {
            announceTeamWinner(battle);
            introToReturnToMainMenu();
        }
        }

    private int battleMenuWithGraveyard() {
        System.out.println("Battle Menu");
        //Here we print battleMenuWithGraveyard
        String battleMenuWithGraveyardString = "Choose your option: \n " +
                "1.Select next fighter. \n " +
                "2.Check the graveyard. \n " +
                "3.Return to Main Menu.";
        System.out.println(battleMenuWithGraveyardString);

        //This switch let us drive around the menu
        switch (Ressources.validateIntMenu("Choose a correct option.\n" + battleMenuWithGraveyardString, "1|2|3")) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 3;
        }
    }

    private void showGraveyard() {
        System.out.println("Graveyard of Team " + battle.getParty1().getName() + ":");
        if (battle.getGraveyard().getGraveyard1().size()>0) {
            for (Character soldier: battle.getGraveyard().getGraveyard1()) {
                System.out.println(soldier.getName());
            }
        } else {
            System.out.println("No deaths.");
        }
        System.out.println();
        System.out.println("Graveyard of Team " + battle.getParty2().getName() + ":");
        if (battle.getGraveyard().getGraveyard2().size()>0) {
            for (Character soldier: battle.getGraveyard().getGraveyard2()) {
                System.out.println(soldier.getName());
            }
        } else {
            System.out.println("No deaths.");
        }
        System.out.println();

        introToContinue();

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

    public void introToContinue() {
        System.out.println("Press intro to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
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
