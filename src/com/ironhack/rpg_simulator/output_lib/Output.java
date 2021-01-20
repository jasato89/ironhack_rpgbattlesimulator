package com.ironhack.rpg_simulator.output_lib;

import java.io.IOException;

public class Output {
    private static final String DEFAULT = (char) 27 + "[0m";
    private static final String RED = (char) 27 + "[31m";
    private static final String GREEN = (char) 27 + "[32m";
    private static final String GREEN_BCK = (char) 27 + "[42m";
    private static final String MAGENTA_BCK = (char) 27 + "[30;45m";
    private static final String RED_BCK = (char) 27 + "[41m";
    private static final String BLOCK = " ";







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
                                        + insertText(PreRendering.getMenuOption1(), 10, 1) + BLOCK + DEFAULT);
                                j+= 11;
                                break;
                            case '2':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] + BLOCK
                                        + insertText(PreRendering.getMenuOption2(), 10, 1) + BLOCK + DEFAULT);
                                j+= 11;
                                break;
                            case '3':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] + BLOCK
                                        + insertText(PreRendering.getMenuOption3(), 10, 1) + BLOCK + DEFAULT);
                                j+= 11;
                                break;
                            case '4':
                                System.out.print(RED_BCK + BLOCK + screen[i][j + 1] + BLOCK
                                        + insertText(PreRendering.getMenuOption4(), 10, 1) + BLOCK + DEFAULT);
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
        if (side < 1) rString += text + Output.fillWithSpaces(len - strLen) + Output.fillWithSpaces(len);
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




