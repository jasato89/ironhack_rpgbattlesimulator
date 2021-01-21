package com.ironhack.rpg_simulator.output;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Output {
    private static final String DEFAULT = (char) 27 + "[0m";
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
    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static void printMainMenu(String[] menu) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(25) + "RPG BATTLE SIMULATOR");
        System.out.println();
        printLogo();
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.println(fillWithSpaces(15) + MAGENTA_BCK + BLOCK + (i + 1) + BLOCK + insertText(menu[i], 20, 0) + BLOCK + DEFAULT);
            System.out.println();
        }
    }

    public static void printCentralMenu(String[] menu) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(25) + "RPG BATTLE SIMULATOR");
        printEmptyLines(5);
        for (int i = 0; i < menu.length; i++) {
            System.out.println(fillWithSpaces(15) + RED_BCK + BLOCK + (i + 1) + BLOCK + insertText(menu[i], 20, 0) + BLOCK + DEFAULT);
            System.out.println();
        }
    }

    public static void printHeader(String header) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(25) + "RPG BATTLE SIMULATOR");
        printEmptyLines(3);
        printElementListLike(header, 1);
        printEmptyLines(8);

    }

    public static void printGraveyard(int graveyardSize) {
        printEmptyLines(1);
        System.out.print(fillWithSpaces(5));

        for (int i = 0; i < graveyardSize; i++) {
            System.out.print(BLUE_BCK + "+" + DEFAULT + BLOCK);
        }
        printEmptyLines(2);
    }

    public static void printHeader(String header, boolean emptyLines) throws IOException, InterruptedException {
        Output.clearConsole();
        System.out.println(fillWithSpaces(25) + "RPG BATTLE SIMULATOR");
        printEmptyLines(2);
        printElementListLike(header, 1);
        System.out.println();
        if (emptyLines) printEmptyLines(8);

    }

    /**
     * Display an Intro timed using the sleep() method
     *
     * @throws IOException
     * @throws InterruptedException
     */
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
        Output.printElementListLike(fillWithSpaces(13) + GREEN + "The" + MAGENTA + " Exe" + BLUE + "ption" + RED + "alist" + DEFAULT, 99);
        Output.printEmptyLines(9);
        Thread.sleep(1000);
        clearConsole();
        Output.printEmptyLines(7);
        Output.printElementListLike(fillWithSpaces(13) + GREEN + "The" + MAGENTA + " Exe" + BLUE + "ption" + RED + "alist" + DEFAULT, 99);
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

    public static void printLogo() {
        char[][] logo = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'R', 'R', 'R', ' ', 'R', 'R', 'R', ' ', 'R', 'R', 'R', ' ', ' ', ' ', 'G', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'R', ' ', 'R', ' ', 'R', ' ', 'R', ' ', 'R', ' ', ' ', ' ', ' ', ' ', 'G', 'G', 'G', 'Y', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'R', 'R', 'p', ' ', 'R', 'R', 'p', ' ', 'R', 'r', 'R', ' ', ' ', ' ', 'G', ' ', ' ', 'Y', ' ', ' ', ' ', 'B', 'B', 'B', 'B', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'R', ' ', 'R', ' ', 'R', ' ', ' ', ' ', 'R', ' ', 'R', ' ', ' ', ' ', ' ', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'R', ' ', 'R', ' ', 'R', ' ', ' ', ' ', 'R', 'R', 'R', ' ', ' ', ' ', ' ', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        for (char[] chars : logo) {
            for (char aChar : chars) {
                switch (aChar) {
                    case 'G' -> System.out.print(BLUE_BCK + BLOCK + BLOCK + DEFAULT);
                    case 'Y' -> System.out.print(YELLOW_BCK + BLOCK + BLOCK + DEFAULT);
                    case 'B' -> System.out.print(WHITE_BCK + BLOCK + BLOCK + DEFAULT);
                    case 'R' -> System.out.print(RED_BCK + BLOCK + BLOCK + DEFAULT);
                    case 'r' -> System.out.print(BLOCK + RED_BCK + BLOCK + DEFAULT);
                    case 'p' -> System.out.print(RED_BCK + BLOCK + DEFAULT + BLOCK);
                    default -> System.out.print(BLOCK + BLOCK);
                }

            }
            System.out.println();
        }

    }

    /**
     * Print a line using a color background passed as int and determined through a switch
     *
     * @param text
     * @param i
     */
    public static void printElementListLike(String text, int i) {
        String colorBck = DEFAULT;

        switch (i) {
            case 1 -> colorBck = RED_BCK;
            case 3 -> colorBck = YELLOW_BCK;
            case 5 -> colorBck = GREEN_BCK;
            case 7 -> colorBck = WHITE_BCK;
        }
        System.out.println(fillWithSpaces(5) + colorBck + BLOCK + insertText(text, 50, 99) + BLOCK + DEFAULT);
    }

    public static void printEmptyLines(int lines) {
        for (int i = 0; i < lines; i++)
            System.out.println();
    }

    public static void printStringCentered(String str, int leftOffset) {
        System.out.println(Output.fillWithSpaces(leftOffset) + str + Output.fillWithSpaces(leftOffset + str.length()));
    }

    /**
     * Insert a text and balance white space around it up to a max len. It uses the side param to determine the justify.
     *
     * @param text
     * @param len
     * @param side
     * @return
     */
    public static String insertText(String text, int len, int side) {
        int strLen = text.length();
        String rString = "";
        text = strLen > len ? text.substring(0, len) : text;
        if (side < 0) rString += text + Output.fillWithSpaces(len - strLen) + Output.fillWithSpaces(len);
        else if (side == 0)
            rString += Output.fillWithSpaces(len / 2) + text + Output.fillWithSpaces(len - strLen) + Output.fillWithSpaces(len / 2);
        else if (side == 99)
            rString += Output.fillWithSpaces(3) + text + Output.fillWithSpaces(len - strLen) + Output.fillWithSpaces(3);
        else rString += Output.fillWithSpaces(len) + text + Output.fillWithSpaces(len - strLen);
        return rString;
    }

    /**
     * Method to clear the console usable only on Windows os
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public static void clearConsole() throws IOException, InterruptedException {
        if (isWindows())
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static String fillWithSpaces(int len) {
        StringBuilder r = new StringBuilder();
        if (len > 0) r.append(" ".repeat(len));
        return r.toString();
    }

    public static void playSound(String filePath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Clip clip;
        AudioInputStream audioInputStream;
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();


    }
}
