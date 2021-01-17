package com.ironhack.rpg_simulator.output;

import com.ironhack.rpg_simulator.classes.Party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
        SchemaToRender stc = new SchemaToRender();
        terminalRenderer = new TerminalRenderer(stc);
        terminalRenderer.clearScreen();
        mapBuilder.prepareBoard(stc, mapStorage.enterBattleMap);
    }
}
