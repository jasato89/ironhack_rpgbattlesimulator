package com.ironhack.rpg_simulator.outputLib;

import java.io.IOException;

public class Output {
    private static final String DEFAULT = (char) 27 + "[0m";
    private static final String RED = (char) 27 + "[31m";
    private static final String GREEN = (char) 27 + "[32m";
    private static final String GREEN_BCK = (char) 27 + "[42m";
    private static final String MAGENTA_BCK = (char) 27 + "[30;45m";
    private static final String RED_BCK = (char) 27 + "[41m";

    private static final String[] COLORS_BCK = { DEFAULT, GREEN_BCK, MAGENTA_BCK, RED_BCK};

    private static String tenSpace = "          ";
    private static String fiveSpace = "     ";
    private static String threeSpace = "   ";
    private static String twoSpace = "  ";
    private static String oneSpace = " ";

    public static void printTitle(String title){
        System.out.println(fiveSpace + title);
    }

    public static void printCentralMenu(String[] centralMenu){
        System.out.println();
        for (int i = 0; i < centralMenu.length; i++){
            int strLen = centralMenu[i].length();
            centralMenu[i] = strLen > 10 ? centralMenu[i].substring(0, 10) : centralMenu[i];
            System.out.println(tenSpace + RED_BCK + oneSpace + i + oneSpace + centralMenu[i] + fillWithSpaces(10 - strLen ) + oneSpace + DEFAULT);
            System.out.println();
        }
        System.out.println();
    }

    public static void printCentralMenu(String[] centralMenu, int color){
        System.out.println();
        for (int i = 0; i < centralMenu.length; i++){
            int strLen = centralMenu[i].length();
            centralMenu[i] = strLen > 10 ? centralMenu[i].substring(0, 10) : centralMenu[i];
            System.out.println(tenSpace + COLORS_BCK[color] + oneSpace + i + oneSpace + centralMenu[i] + fillWithSpaces(10 - strLen ) +  oneSpace + DEFAULT);
            System.out.println();
        }
        System.out.println();
    }

    public static void printBottomMenu(String[] bottomMenu){
        System.out.println();
        for (int i = 0; i < bottomMenu.length; i++){
            int strLen = bottomMenu[i].length();
            bottomMenu[i] = strLen > 5 ? bottomMenu[i].substring(0, 5) : bottomMenu[i];
            System.out.print(twoSpace + RED_BCK + i + oneSpace + bottomMenu[i]  + fillWithSpaces(5 - strLen ) + oneSpace + DEFAULT);
        }
        System.out.println();
    }

    public static void printBottomMenu(String[] bottomMenu, int color){
        System.out.println();
        for (int i = 0; i < bottomMenu.length; i++){
            int strLen = bottomMenu[i].length();
            bottomMenu[i] = strLen > 5 ? bottomMenu[i].substring(0, 5) : bottomMenu[i];
            System.out.print(twoSpace + COLORS_BCK[color] + i + oneSpace + bottomMenu[i] + fillWithSpaces(5 - strLen )  + oneSpace + DEFAULT);
        }
        System.out.println();
    }

    public static void printMiddleScreen(String text, int space){
        for (int i = 0; i < space; i++)
            System.out.println();
        System.out.println(threeSpace + text);
        for (int i = 0; i < space; i++)
            System.out.println();
    }

    public static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }


    private static String fillWithSpaces(int len){
        String r = "";
        if (len > 0) {
            for (int i = 0; i < len; i++) r += " ";
        }
        return r;
    }

    public static void printBattleHeader(String teamNameA, String teamNameB, int currentSizeA, int currentSizeB, int maxSizeA, int maxSizeB){
        int teamALen = teamNameA.length();
        int teamBLen = teamNameB.length();
        teamNameA = teamALen > 10 ? teamNameA.substring(0, 10) : teamNameA;
        teamNameB = teamBLen > 10 ? teamNameB.substring(0, 10) : teamNameB;
        System.out.println(oneSpace + teamNameA + fillWithSpaces(30 - teamALen) + teamNameB);
        String teamAState = currentSizeA + "/" + maxSizeA;
        String teamBState = currentSizeB + "/" + maxSizeB;
        int stateALen = teamAState.length();
        System.out.println(oneSpace + teamAState + fillWithSpaces(30 - stateALen) + teamBState);
    }


    public static void printGraveyard(int graveyardTeamA, int graveyardTeamB){
        String tombA = (char) 27 + "[30;47m" + "+" + DEFAULT;
        String tombB = (char) 27 + "[30;47m" + "+" + DEFAULT;
        int z = 0;
        graveyardTeamA = graveyardTeamA > 5 ? 5 : graveyardTeamA;
        graveyardTeamB = graveyardTeamB > 5 ? 5 : graveyardTeamB;
        System.out.println();
        System.out.print(fillWithSpaces(3));
        for (int i = 0; i < graveyardTeamA; i++){
            System.out.print(tombA + oneSpace);
            z+= 2;
        }
        System.out.print(fillWithSpaces(30 - z - 3));
        for (int i = 0; i < graveyardTeamB; i++){
            System.out.print(tombB + oneSpace);
            z+= 2;
        }
        System.out.println();
    }
}




