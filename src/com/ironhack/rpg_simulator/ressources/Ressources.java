package com.ironhack.rpg_simulator.ressources;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//We use this class to get method that's help us in the flow of the game
public abstract class Ressources {

    //We use this function to validate a menu
    public static int validateMenu(String arg) {
        Scanner scanner = new Scanner(System.in);
        int selection;

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println("The value introduced is not correct:");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        return selection = Integer.parseInt(input);
    }

}
