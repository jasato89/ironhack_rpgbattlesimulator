package com.ironhack.rpg_simulator.output_lib;

import com.ironhack.rpg_simulator.classes.Party;

import java.io.IOException;
import java.util.List;

public class Output {
    private static final String DEFAULT = (char) 27 + "[0m";
    private static final String BLACK = (char) 27 + "[30m";
    private static final String BLUE = (char) 27 + "[34m";
    private static final String MAGENTA = (char) 27 + "[35m";
    private static final String RED = (char) 27 + "[31m";
    private static final String GREEN = (char) 27 + "[32m";
    private static final String GREEN_BCK = (char) 27 + "[42m";
    private static final String BLUE_BCK = (char) 27 + "[44m";
    private static final String MAGENTA_BCK = (char) 27 + "[30;45m";
    private static final String RED_BCK = (char) 27 + "[41m";
    private static final String YELLOW_BCK = (char) 27 + "[30;43m";
    private static final String WHITE_BCK = (char) 27 + "[30;47m";
    private static final String BLOCK = " ";

    private static final String CYAN_BCK = (char) 27 + "[46m";



    public static void printMainMenu(String [] menu) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(25) +  PreRendering.getTitle());
        System.out.println();
        printLogo();
        System.out.println();
        for (int i = 0; i < menu.length; i++){
            System.out.println(fillWithSpaces(15) + MAGENTA_BCK + BLOCK + (i + 1) + BLOCK + insertText(menu[i], 20, 0) + BLOCK + DEFAULT);
            System.out.println();
        }
    }

    public static void printCentralMenu(String [] menu) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(25) +  PreRendering.getTitle());
        printEmptyLines(5);
        for (int i = 0; i < menu.length; i++){
            System.out.println(fillWithSpaces(15) + RED_BCK + BLOCK + (i + 1) + BLOCK + insertText(menu[i], 20, 0) + BLOCK + DEFAULT);
            System.out.println();
        }
    }

    public static void printHeader(String header) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(25) +  PreRendering.getTitle());
        printEmptyLines(3);
        printElementListLike(header, 1);
        printEmptyLines(8);

    }

    public static void printGraveyard(int graveyardSize){
        printEmptyLines(1);
        System.out.print(fillWithSpaces(5) + "Graveyard:  ");

        for (int i = 0; i < graveyardSize; i++){
            System.out.print(BLUE_BCK + "+" + DEFAULT + BLOCK);
        }
        printEmptyLines(2);
    }

    public static void printHeader(String header, boolean emptyLines) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(25) +  PreRendering.getTitle());
        printEmptyLines(2);
        printElementListLike(header, 1);
        System.out.println();
        if (emptyLines == true) printEmptyLines(8);

    }

    public static void printIntro() throws IOException, InterruptedException {
        printDisclaimer();
        printPresentation();
        printGameName();

    }

    private static void printGameName() throws IOException, InterruptedException {
        clearConsole();
        Output.printEmptyLines(3);
        Output.printElementListLike(fillWithSpaces(13) + "RPG BATTLE SIMULATOR", 99);
        printLogo();
        Output.printEmptyLines(2);
        Output.printElementListLike(fillWithSpaces(13) + "RPG BATTLE SIMULATOR", 99);
        Output.printEmptyLines(2);
        Thread.sleep(2000);
        clearConsole();
    }

    private static void printPresentation() throws IOException, InterruptedException {
        Output.clearConsole();
        Output.printEmptyLines(7);
        Output.printElementListLike(fillWithSpaces(13 ) + GREEN + "The" + MAGENTA + " Exe" + BLUE + "ption" + RED + "alist" + DEFAULT, 99);
        Output.printEmptyLines(9);
        Thread.sleep(1000);
        clearConsole();
        Output.printEmptyLines(7);
        Output.printElementListLike(fillWithSpaces(13 ) + GREEN + "The" + MAGENTA + " Exe" + BLUE + "ption" + RED + "alist" + DEFAULT, 99);
        Output.printElementListLike(fillWithSpaces(18) + "present", 0);
        Output.printEmptyLines(9);
        Thread.sleep(1000);
    }

    private static void printDisclaimer() throws IOException, InterruptedException {
        Output.clearConsole();
        Output.printEmptyLines(7);
        System.out.println(fillWithSpaces(10) + "For a better experience resize your terminal");
        Output.printEmptyLines(9);
        Thread.sleep(1000);
    }

    public static void printLogo(){
        char[][] logo = {
                {' ',' ', ' ',' ',' ', ' ',' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ',' ', ' ',' ',' ', ' ',' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ',' ', ' ',' ',' ', ' ',' ', 'R', 'R','R', ' ', 'R','R', 'R', ' ','R', 'R', 'R',' ', ' ', ' ','G', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ',' ', ' ',' ',' ', ' ',' ', 'R', ' ','R', ' ', 'R',' ', 'R', ' ','R', ' ', ' ',' ', ' ', ' ','G', 'G', 'G', 'Y', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
                {' ',' ', ' ',' ',' ', ' ',' ', 'R', 'R','p', ' ', 'R','R', 'p', ' ','R', 'r', 'R',' ', ' ', ' ','G', ' ', ' ', 'Y', ' ', ' ', ' ', 'B', 'B', 'B', 'B', ' ', ' ', ' '},
                {' ',' ', ' ',' ',' ', ' ',' ', 'R', ' ','R', ' ', 'R',' ', ' ', ' ','R', ' ', 'R',' ', ' ', ' ',' ', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ',' ', ' ',' ',' ', ' ',' ', 'R', ' ','R', ' ', 'R',' ', ' ', ' ','R', 'R', 'R',' ', ' ', ' ',' ', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        for (int i = 0; i < logo.length; i++){
            for (int j = 0; j < logo[i].length; j++){
                switch (logo[i][j]){
                    case 'G':
                        System.out.print(BLUE_BCK + BLOCK + BLOCK + DEFAULT);
                        break;
                    case 'Y':
                        System.out.print(YELLOW_BCK + BLOCK + BLOCK + DEFAULT);
                        break;
                    case 'B':
                        System.out.print(WHITE_BCK + BLOCK + BLOCK + DEFAULT);
                        break;
                    case 'R':
                        System.out.print(RED_BCK + BLOCK + BLOCK + DEFAULT);
                        break;
                    case 'r':
                        System.out.print(BLOCK + RED_BCK + BLOCK + DEFAULT);
                        break;
                    case 'p':
                        System.out.print(RED_BCK + BLOCK + DEFAULT +  BLOCK);
                        break;
                    default:
                        System.out.print(BLOCK + BLOCK);
                }

            }
            System.out.println();
        }

    }



    public static void printBottomPrompt(String text){
        System.out.println(fillWithSpaces(15) + RED_BCK + BLOCK + insertText(text, 20, 0) + BLOCK + DEFAULT);
    }

    public static void printElementListLike(String text, int i){
        String colorBck = DEFAULT;

        switch (i) {
            case 1 -> colorBck = RED_BCK;
            case 3 -> colorBck = YELLOW_BCK;
            case 5 -> colorBck = GREEN_BCK;
            case 7 -> colorBck = WHITE_BCK;
        }
        System.out.println(fillWithSpaces(5) + colorBck + BLOCK + insertText(text, 50, 99) + BLOCK + DEFAULT);
    }



    public static void printTitleAndInstruction(String instruction) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(5) +  PreRendering.getTitle());
        printEmptyLines(3);
        System.out.println(fillWithSpaces(5) +  instruction);
    }




    public static void combatAnimation(char[][] screen) throws InterruptedException, IOException {
        printScreen(PreRendering.prepareScreenCombat1(PreRendering.getScreenEmpty()));
        Thread.sleep(500);
        printScreen(PreRendering.prepareScreenCombat2(PreRendering.getScreenEmpty()));
        Thread.sleep(1000);
        printScreen(PreRendering.prepareScreenCombat3(PreRendering.getScreenEmpty()));
        Thread.sleep(500);
    }
    public static void printCentralBottomUniqueMenu(String str){
        System.out.println(Output.fillWithSpaces(10) + RED_BCK + BLOCK + str + BLOCK + DEFAULT);
    }
    public static void printEmptyLines(int lines){
        for (int i = 0; i < lines; i++)
            System.out.println();
    }
    public static void printStringCentered(String str, int leftOffset){
        System.out.println(Output.fillWithSpaces(leftOffset) + str + Output.fillWithSpaces(leftOffset + str.length()));
    }
    public static void printScreen(char [][] screen) {
        for (int i = 0; i < screen.length; i++){
            for (int j = 0; j < screen[i].length; j++){
                switch (screen[i][j]){
                    case 'R':
                        System.out.print(RED_BCK + BLOCK + BLOCK + DEFAULT);
                        break;
                    case 'T':
                        j+= printText(PreRendering.getTitle(), 20, 0);
                        break;
                    case 'N':
                        j+= printText(PreRendering.getTeamA(), 10, 0);
                        break;
                    case 'n':
                        j+= printText(PreRendering.getTeamB(), 10, 0);
                        break;
                    case 'S':
                        j+= printText(PreRendering.getStatusA(), 9, 0);
                        break;
                    case 's':
                        j+= printText(PreRendering.getStatusB(), 9, 0);
                        break;
                    case 'A':
                        j+= printText(PreRendering.getAbilityA(), 9, 0);
                        break;
                    case 'a':
                        j+= printText(PreRendering.getAbilityB(), 9, 0);
                        break;
                    case 'D':
                        j+= printText(PreRendering.getDamageA(), 5, 0);
                        break;
                    case 'd':
                        j+= printText(PreRendering.getStatusB(), 5, 0);
                        break;
                    case 'H':
                        j+= printHealth(PreRendering.getCurrentLifeA(), PreRendering.getMaxLifeA());
                        break;
                    case 'h':
                        j+= printHealth(PreRendering.getCurrentLifeB(), PreRendering.getMaxLifeB());
                        break;
                    case 'G':
                        System.out.print(GREEN_BCK + BLOCK + BLOCK + DEFAULT);
                        break;
                    case 'Y':
                        System.out.print(GREEN_BCK + '+' + DEFAULT+ BLOCK);
                        break;
                    case 'y':
                        System.out.print(RED_BCK + '+' + DEFAULT+ BLOCK);
                        break;
                    case 'M':
                        switch (screen[i][j + 1]){
                            case '1':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] + BLOCK
                                        + insertText(PreRendering.getMenuOption1(), 25, 0) + BLOCK + DEFAULT);
                                j+= 11;
                                break;
                            case '2':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] + BLOCK
                                        + insertText(PreRendering.getMenuOption2(), 25, 0) + BLOCK + DEFAULT);
                                j+= 11;
                                break;
                            case '3':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] + BLOCK
                                        + insertText(PreRendering.getMenuOption3(), 25, 0) + BLOCK + DEFAULT);
                                j+= 11;
                                break;
                            case '4':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] + BLOCK
                                        + insertText(PreRendering.getMenuOption4(), 25, 0) + BLOCK + DEFAULT);
                                j+= 11;
                                break;
                        }
                    case 'm':
                        switch (screen[i][j + 1]){
                            case '1':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] + BLOCK
                                        + insertText(PreRendering.getMenuOption1(), 6, 1) + BLOCK + DEFAULT);
                                j+= 7;
                                break;
                            case '2':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] +BLOCK
                                        + insertText(PreRendering.getMenuOption2(), 6, 1) + BLOCK + DEFAULT);
                                j+= 7;
                                break;
                            case '3':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] +BLOCK
                                        + insertText(PreRendering.getMenuOption3(), 6, 1) + BLOCK + DEFAULT);
                                j+= 7;
                                break;
                            case '4':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] +BLOCK
                                        + insertText(PreRendering.getMenuOption4(), 6, 1) + BLOCK + DEFAULT);
                                j+= 7;
                                break;
                        }
                    default:
                        System.out.print(BLOCK + BLOCK);
                }

            }
            System.out.println();
        }
    }
    public static String insertText(String text, int len, int side){
        int strLen = text.length();
        String rString = "";
        text = strLen > len ? text.substring(0, len) : text;
        if (side < 0) rString += text + Output.fillWithSpaces(len - strLen) + Output.fillWithSpaces(len);
        else if (side == 0) rString += Output.fillWithSpaces(len /2) + text + Output.fillWithSpaces(len - strLen) + Output.fillWithSpaces(len /2);
        else if (side == 99) rString += Output.fillWithSpaces(3) + text + Output.fillWithSpaces(len - strLen) + Output.fillWithSpaces(3);
        else rString += Output.fillWithSpaces(len) + text + Output.fillWithSpaces(len - strLen);
        return rString;
    }
    public static int printText(String text, int len, int side){
        int strLen = text.length();
        text = strLen > len ? text.substring(0, len) : text;
        if (side == 0) System.out.print(text + Output.fillWithSpaces(len - strLen ) + Output.fillWithSpaces(len));
        else if (side == 1) System.out.print(Output.fillWithSpaces(len) + text + Output.fillWithSpaces(len - strLen ));
        return len - 1;
    }
    public static int printHealth(int health, int maxHealth){
        int percentage = health * 100 /maxHealth;
        int strLen = percentage / 10;
        System.out.print(GREEN_BCK + Output.fillWithSpaces(strLen) + RED_BCK + Output.fillWithSpaces(10 - strLen) + DEFAULT + Output.fillWithSpaces(10));
        return 9;
    }
    public static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static String fillWithSpaces(int len) {
        String r = "";
        if (len > 0) {
            for (int i = 0; i < len; i++) r += " ";
        }
        return r;
    }
}




