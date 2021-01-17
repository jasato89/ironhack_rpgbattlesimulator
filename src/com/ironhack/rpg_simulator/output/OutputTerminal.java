package com.ironhack.rpg_simulator.output;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Party;
import com.ironhack.rpg_simulator.fight.classes.AttackStats;
import com.ironhack.rpg_simulator.fight.classes.Battle;
import com.ironhack.rpg_simulator.fight.classes.RoundStats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class OutputTerminal implements Output{


    MapStorage  mapStorage = new MapStorage();
    char[][] map = mapStorage.blankMap;
    MapBuilder mapBuilder = new MapBuilder();
    private TerminalRenderer terminalRenderer;



    //map 24*15


    public void introRoutine() throws InterruptedException, IOException {

        terminalRenderer = new TerminalRenderer();
        terminalRenderer.clearScreen();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Thread.sleep(1000);
        terminalRenderer.clearScreen();
        System.out.println("\n\n\n\n");
        System.out.println("             TEAM A");
        System.out.println("\n\n\n\n\n");
        Thread.sleep(500);
        terminalRenderer.clearScreen();
        System.out.println("\n\n\n\n");
        System.out.println("             TEAM A");
        System.out.println("            presents");
        System.out.println("\n\n\n\n");
        Thread.sleep(1000);
        terminalRenderer.clearScreen();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Thread.sleep(500);
        terminalRenderer.clearScreen();
        System.out.println("\n\n\n\n\n");
        System.out.println("        RPG BATTLE SIMULATOR");
        System.out.println("\n\n\n\n\n");
        Thread.sleep(1500);
        terminalRenderer.clearScreen();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Thread.sleep(500);
    }

    public String mainMenuRoutine() throws IOException, InterruptedException {
        terminalRenderer = new TerminalRenderer();
        terminalRenderer.clearScreen();
        terminalRenderer.drawScreen(mapStorage.mainMenu);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String r = br.readLine();
        String [] rArray = r.split(" ");
        return rArray[0];
    }
    public String playMenuRoutine() throws IOException, InterruptedException {
        terminalRenderer = new TerminalRenderer();
        terminalRenderer.clearScreen();
        terminalRenderer.drawScreen(mapStorage.playMenuMap);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String r = br.readLine();
        String [] rArray = r.split(" ");
        return rArray[0];
    }

    public String[] createTeamRoutine(String textToPrompt, String teamName, String charString) throws IOException, InterruptedException {
        String menuEnter = "Enter to continue";
        terminalRenderer = new TerminalRenderer();
        terminalRenderer.clearScreen();
        System.out.println();
        System.out.println("  RPG BATTLE SIMULATOR");
        System.out.println("\n");
        System.out.println("   Team name: " + teamName);
        System.out.println();
        System.out.println("   Character: " + charString);
        System.out.println();
        System.out.println( textToPrompt);
        System.out.println("\n\n\n");
        System.out.println((char) 27 + "[41m" + "                                " + menuEnter  + (char) 27 + "[0m");
        System.out.println("\n\n\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String r = br.readLine();
        String [] rArray = r.split(" ");
        return rArray;
    }

    public String[] seeTeamRoutine(String textToPrompt, String teamName, String charString) throws IOException, InterruptedException {
        terminalRenderer = new TerminalRenderer();
        terminalRenderer.clearScreen();
        System.out.println("  Team name: " + teamName);
        System.out.println();
        System.out.println("  Character" + charString);
        System.out.println();
        System.out.println( textToPrompt);
        System.out.println((char) 27 + "[41m" + "                                                  " + (char) 27 + "[0m");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String r = br.readLine();
        String [] rArray = r.split(" ");
        return rArray;
    }



    public String routineOne() throws IOException, InterruptedException {
        MapBuilder mapBuilder = new MapBuilder();
        SchemaToRender stc = new SchemaToRender();
        terminalRenderer = new TerminalRenderer(stc);
        terminalRenderer.clearScreen();
        mapBuilder.prepareBoard(stc, mapStorage.map);
        terminalRenderer.drawScreen(mapBuilder.prepareBoard(stc, mapStorage.map));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String r = br.readLine();
        String [] rArray = r.split(" ");
        return rArray[0];
    }


    public void enterBattleRoutine(Party teamA, Party teamB) throws IOException, InterruptedException {
        MapBuilder mapBuilder = new MapBuilder();
        SchemaToRender stc = new SchemaToRender(teamA, teamB);
        terminalRenderer = new TerminalRenderer(stc);
        terminalRenderer.clearScreen();
        terminalRenderer.drawScreen(mapBuilder.prepareBoard(stc, mapStorage.enterBattleMap));
    }

    public void pickFighterRoutine(Party teamA) throws IOException, InterruptedException {
        terminalRenderer = new TerminalRenderer();
        terminalRenderer.clearScreen();
        System.out.println("   " + "Pick Fighter for " + teamA.getName());
        System.out.println("\n\n");
        teamA.printAllMembers();
    }

    public void roundRoutine(Battle battle, RoundStats roundStats, Character fighterTeamA, Character fighterTeamB, AttackStats attackStats) throws IOException, InterruptedException {
        terminalRenderer.clearScreen();
        int maxSize1 = battle.getParty1().getPartyMaxSize();
        //need current size
        int maxSize2 = battle.getParty2().getPartyMaxSize();
        //need current size
        int currentRound = battle.getRoundNumber();
        String name1 = fighterTeamA.getName();
        String name2 = fighterTeamB.getName();
        String class1 = roundStats.getClass1() < 2 ? "Warrior" : "Wizard";
        String class2 = roundStats.getClass2() < 2 ? "Warrior" : "Wizard";
        String attackType1;
        String attackType2;
        if(class1.equals("Warrior")){
            attackType1 = attackStats.getAttackType1() < 2 ? "heavy attack" : "light attack";
        } else {
            attackType1 = attackStats.getAttackType1() < 2 ? "fireball" : "staff attack";
        }

        if(class2.equals("Warrior")){
            attackType2 = attackStats.getAttackType2() < 2 ? "heavy attack" : "light attack";
        } else {
            attackType2 = attackStats.getAttackType2() < 2 ? "fireball" : "staff attack";
        }

        int attackValue1 = attackStats.getAttackValue1();
        int attackValue2 = attackStats.getAttackValue2();
        System.out.println(name1 + " did " + attackValue1 + " damage using " + attackType1 + ".");
        System.out.println(name2 + " did " + attackValue2 + " damage using " + attackType2 + ".");

    }
}
