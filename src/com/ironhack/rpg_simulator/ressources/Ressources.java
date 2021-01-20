package com.ironhack.rpg_simulator.ressources;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//We use this class to get method that's help us in the flow of the game
public abstract class Ressources {

    //We use this function to validate a menu
    //here if we need a message
    public static int validateMenu(String sout, String arg) {
        Scanner scanner = new Scanner(System.in);
        int selection;

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println(sout);
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        selection = Integer.parseInt(input);
        return selection;
    }
    //here if we doesn't
    public static int validateMenu(String arg) {
        Scanner scanner = new Scanner(System.in);
        int selection;

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        selection = Integer.parseInt(input);
        return selection;
    }

}
