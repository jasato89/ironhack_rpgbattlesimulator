package com.ironhack.rpg_simulator.output_lib;

import java.io.IOException;
import java.util.Arrays;

public class PreRendering {

    private static int currentLifeA;
    private static int currentLifeB;
    private static int maxLifeA;
    private static int maxLifeB;
    private static String title;
    private static String teamA;
    private static String teamB;
    private static String statusA;
    private static String statusB;
    private static String abilityA;
    private static String abilityB;
    private static String damageA;
    private static String damageB;
    private static String menuOption1;
    private static String menuOption2;
    private static String menuOption3;
    private static String menuOption4;
    private static String menuOption5;

    private static final char[][] screenEmpty = {
//          {'0','1','2','3','4','5','6','7','8','9','1','1','2','3','4','5','6','7','8','9','2','1','2','3','4','5','6','7','8','9','3','1','2','3','4','5','6','7','8','9','4','1','2','3','4','5','6','7','8','9','5','1','2','3','4','5','6','7','8','9'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'}};


    public static char[][] insertMenuCentral(char[][] canvas, String[] menu){
        int menuSize = menu.length;
        while (menuSize > 0){
            switch (menuSize) {
                case 1 -> {
                    setMenuOption1(menu[menuSize - 1]);
                    canvas[10][24] = 'M';
                    canvas[10][25] = '1';
                }
                case 2 -> {
                    setMenuOption2(menu[menuSize - 1]);
                    canvas[12][24] = 'M';
                    canvas[12][25] = '2';
                }
                case 3 -> {
                    setMenuOption3(menu[menuSize - 1]);
                    canvas[14][24] = 'M';
                    canvas[14][25] = '3';
                }
                case 4 -> {
                    setMenuOption4(menu[menuSize - 1]);
                    canvas[16][24] = 'M';
                    canvas[16][25] = '4';
                }
                case 5 -> {
                    setMenuOption5(menu[menuSize - 1]);
                    canvas[18][24] = 'M';
                    canvas[18][25] = '5';
                }
            }
            menuSize--;
        }
        return canvas;
    }

    public static char[][] insertMenuBottom(char[][] canvas, String[] menu){
        int menuSize = menu.length;
        while (menuSize > 0){
            switch (menuSize) {
                case 1 -> {
                    setMenuOption1(menu[menuSize - 1]);
                    canvas[18][3] = 'm';
                    canvas[18][4] = '1';
                }
                case 2 -> {
                    setMenuOption2(menu[menuSize - 1]);
                    canvas[18][17] = 'm';
                    canvas[18][18] = '2';
                }
                case 3 -> {
                    setMenuOption3(menu[menuSize - 1]);
                    canvas[18][31] = 'm';
                    canvas[18][32] = '3';
                }
                case 4 -> {
                    setMenuOption4(menu[menuSize - 1]);
                    canvas[18][45] = 'm';
                    canvas[18][46] = '4';
                }
            }
            menuSize--;
        }
        return canvas;
    }

    private static char[][] insertGraveyard(char[][] canvas, int graveyardSizeA, int graveyardSizeB) {
        graveyardSizeA = Math.min(graveyardSizeA, 5);
        graveyardSizeB = Math.min(graveyardSizeB, 5);
        while (graveyardSizeA > 0){
            switch (graveyardSizeA) {
                case 1 -> canvas[18][3] = 'Y';
                case 2 -> canvas[18][5] = 'Y';
                case 3 -> canvas[18][7] = 'Y';
                case 4 -> canvas[18][9] = 'Y';
                case 5 -> canvas[18][11] = 'Y';
            }
            graveyardSizeA--;
        }

        while (graveyardSizeB > 0){
            switch (graveyardSizeB) {
                case 1 -> canvas[18][56] = 'y';
                case 2 -> canvas[18][54] = 'y';
                case 3 -> canvas[18][52] = 'y';
                case 4 -> canvas[18][50] = 'y';
                case 5 -> canvas[18][48] = 'y';
            }
            graveyardSizeB--;
        }
        return canvas;
    }

    public static char[][] resetCanvas(char[][] canvas){
        for (char[] row : canvas) {
            Arrays.fill(row, '0');
        }
        return canvas;
    }

    public static char[][] insertTitle(char[][] canvas){
        int midCenter = canvas[0].length / 2;
        canvas[0][midCenter - 6] = 'T';
        return canvas;
    }

    public static char[][] insertTeamNames(char[][] canvas){
        canvas[1][3] = 'N';
        canvas[1][48] = 'n';
        return canvas;
    }

    public static char[][] insertTeamStatus(char[][] canvas){
        canvas[2][3] = 'S';
        canvas[2][48] = 's';
        return canvas;
    }

    public static char[][] insertFightersHealth(char[][] canvas){
        canvas[3][22] = 'H';
        canvas[3][32] = 'h';
        return canvas;
    }

    public static char[][] insertFightersAbilities(char[][] canvas){
        canvas[7][22] = 'A';
        canvas[7][32] = 'a';
        return canvas;
    }

    public static char[][] insertFightersDamageDone(char[][] canvas){
        canvas[15][22] = 'd';
        canvas[15][32] = 'D';
        return canvas;
    }

    public static char[][] insertFighters(char [][] canvas){
        canvas[10][23] = 'G';
        canvas[10][24] = 'G';
        canvas[11][23] = 'R';
        canvas[11][24] = 'R';
        canvas[12][23] = 'G';
        canvas[12][24] = 'G';
        canvas[13][23] = 'G';
        canvas[13][24] = 'G';

        canvas[10][32] = 'G';
        canvas[10][33] = 'G';
        canvas[11][32] = 'R';
        canvas[11][33] = 'R';
        canvas[12][32] = 'G';
        canvas[12][33] = 'G';
        canvas[13][32] = 'G';
        canvas[13][33] = 'G';

        return canvas;
    }

    public static char[][] insertFightersCombat(char[][] canvas){
        canvas[10][26] = 'G';
        canvas[10][27] = 'G';
        canvas[11][26] = 'R';
        canvas[11][27] = 'R';
        canvas[12][26] = 'G';
        canvas[12][27] = 'G';
        canvas[13][26] = 'G';
        canvas[13][27] = 'G';

        canvas[10][29] = 'G';
        canvas[10][30] = 'G';
        canvas[11][29] = 'R';
        canvas[11][30] = 'R';
        canvas[12][29] = 'G';
        canvas[12][30] = 'G';
        canvas[13][29] = 'G';
        canvas[13][30] = 'G';

        return canvas;
    }

    public static char[][] insertTeamOnMapA(char[][] canvas, int teamSize){
        teamSize = Math.min(teamSize, 5);
        while (teamSize > 0){
            switch (teamSize--) {
                case 5 -> {
                    canvas[9][3] = 'G';
                    canvas[9][4] = 'G';
                    canvas[9][5] = 'R';
                    canvas[10][3] = 'G';
                    canvas[10][4] = 'G';
                    canvas[10][5] = 'R';
                }
                case 4 -> {
                    canvas[12][3] = 'G';
                    canvas[12][4] = 'G';
                    canvas[12][5] = 'R';
                    canvas[13][3] = 'G';
                    canvas[13][4] = 'G';
                    canvas[13][5] = 'R';
                }
                case 3 -> {
                    canvas[15][3] = 'G';
                    canvas[15][4] = 'G';
                    canvas[15][5] = 'R';
                    canvas[16][3] = 'G';
                    canvas[16][4] = 'G';
                    canvas[16][5] = 'R';
                }
                case 2 -> {
                    canvas[10][7] = 'G';
                    canvas[10][8] = 'G';
                    canvas[10][9] = 'R';
                    canvas[11][7] = 'G';
                    canvas[11][8] = 'G';
                    canvas[11][9] = 'R';
                }
                case 1 -> {
                    canvas[13][7] = 'G';
                    canvas[13][8] = 'G';
                    canvas[13][9] = 'R';
                    canvas[14][7] = 'G';
                    canvas[14][8] = 'G';
                    canvas[14][9] = 'R';
                }
            }
        }
        return canvas;
    }

    public static char[][] insertTeamOnMapB(char[][] canvas, int teamSize){
        teamSize = Math.min(teamSize, 5);
        while (teamSize > 0){
            switch (teamSize--) {
                case 5 -> {
                    canvas[13][48] = 'R';
                    canvas[13][49] = 'G';
                    canvas[13][50] = 'G';
                    canvas[14][48] = 'R';
                    canvas[14][49] = 'G';
                    canvas[14][50] = 'G';
                }
                case 4 -> {
                    canvas[10][48] = 'R';
                    canvas[10][49] = 'G';
                    canvas[10][50] = 'G';
                    canvas[11][48] = 'R';
                    canvas[11][49] = 'G';
                    canvas[11][50] = 'G';
                }
                case 3 -> {
                    canvas[15][52] = 'R';
                    canvas[15][53] = 'G';
                    canvas[15][54] = 'G';
                    canvas[16][52] = 'R';
                    canvas[16][53] = 'G';
                    canvas[16][54] = 'G';
                }
                case 2 -> {
                    canvas[12][52] = 'R';
                    canvas[12][53] = 'G';
                    canvas[12][54] = 'G';
                    canvas[13][52] = 'R';
                    canvas[13][53] = 'G';
                    canvas[13][54] = 'G';
                }
                case 1 -> {
                    canvas[9][52] = 'R';
                    canvas[9][53] = 'G';
                    canvas[9][54] = 'G';
                    canvas[10][52] = 'R';
                    canvas[10][53] = 'G';
                    canvas[10][54] = 'G';
                }
            }
        }
        return canvas;
    }

    public static char[][] prepareScreenMenuCentral(char[][] screen, String[] menu) throws IOException, InterruptedException {
        Output.clearConsole();
        char[][] canvas = resetCanvas(screen);
        insertTitle(canvas);
        insertMenuCentral(canvas, menu);
        return canvas;
    }
    public static char[][] prepareScreenCombat1(char[][] screen) throws IOException, InterruptedException {
        Output.clearConsole();
        char[][] canvas = resetCanvas(screen);
        insertTitle(canvas);
        insertTeamNames(canvas);
        insertTeamStatus(canvas);
        insertFightersHealth(canvas);
        insertFighters(canvas);
        insertTeamOnMapA(canvas, 5);
        insertTeamOnMapB(canvas, 5);
        insertGraveyard(canvas, 5, 3);
        return canvas;
    }
    public static char[][] prepareScreenCombat2(char[][] screen) throws IOException, InterruptedException {
        Output.clearConsole();
        char[][] canvas = resetCanvas(screen);
        insertTitle(canvas);
        insertTeamNames(canvas);
        insertTeamStatus(canvas);
        insertFightersHealth(canvas);
        insertFightersAbilities(canvas);
        insertFightersCombat(canvas);
        insertFightersDamageDone(canvas);
        insertTeamOnMapA(canvas, 5);
        insertTeamOnMapB(canvas, 5);
        insertGraveyard(canvas, 5, 3);
        return canvas;
    }
    public static char[][] prepareScreenCombat3(char[][] screen) throws IOException, InterruptedException {
        Output.clearConsole();
        char[][] canvas = resetCanvas(screen);
        insertTitle(canvas);
        insertTeamNames(canvas);
        insertTeamStatus(canvas);
        insertFightersHealth(canvas);
        insertFightersAbilities(canvas);
        insertFighters(canvas);
        insertTeamOnMapA(canvas, 5);
        insertTeamOnMapB(canvas, 5);
        insertGraveyard(canvas, 5, 3);
        return canvas;
    }

    private static void simpleCentralMenuPage(char[][] screen, String[] menu) throws IOException, InterruptedException {
        Output.clearConsole();
        char[][] canvas = resetCanvas(screen);
        canvas = insertTitle(screenEmpty);
        insertMenuCentral(screenEmpty, menu);
        Output.printScreen(canvas);
    }

    private static void simpleBottomMenuPage(char[][] screen, String[] menu) throws IOException, InterruptedException {
        Output.clearConsole();
        char[][] canvas = resetCanvas(screen);
        canvas = insertTitle(screenEmpty);
        insertMenuBottom(screenEmpty, menu);
        Output.printScreen(canvas);
    }

    public static int getCurrentLifeA() {
        return currentLifeA;
    }

    public static void setCurrentLifeA(int currentLifeA) {
        PreRendering.currentLifeA = currentLifeA;
    }

    public static int getCurrentLifeB() {
        return currentLifeB;
    }

    public static void setCurrentLifeB(int currentLifeB) {
        PreRendering.currentLifeB = currentLifeB;
    }

    public static int getMaxLifeA() {
        return maxLifeA;
    }

    public static void setMaxLifeA(int maxLifeA) {
        PreRendering.maxLifeA = maxLifeA;
    }

    public static int getMaxLifeB() {
        return maxLifeB;
    }

    public static void setMaxLifeB(int maxLifeB) {
        PreRendering.maxLifeB = maxLifeB;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        PreRendering.title = title;
    }

    public static String getTeamA() {
        return teamA;
    }

    public static void setTeamA(String teamA) {
        PreRendering.teamA = teamA;
    }

    public static String getTeamB() {
        return teamB;
    }

    public static void setTeamB(String teamB) {
        PreRendering.teamB = teamB;
    }

    public static String getStatusA() {
        return statusA;
    }

    public static String getStatusB() {
        return statusB;
    }

    public static void setStatusA(int currentSize, int maxSize) {

        PreRendering.statusA = currentSize + " / " + maxSize;
    }

    public static void setStatusB(int currentSize, int maxSize) {

        PreRendering.statusB = currentSize + " / " + maxSize;
    }

    public static String getAbilityA() {
        return abilityA;
    }

    public static void setAbilityA(String abilityA) {
        PreRendering.abilityA = abilityA;
    }

    public static String getAbilityB() {
        return abilityB;
    }

    public static void setAbilityB(String abilityB) {
        PreRendering.abilityB = abilityB;
    }

    public static String getDamageA() {
        return damageA;
    }

    public static void setDamageA(String damageA) {
        PreRendering.damageA = damageA;
    }

    public static String getDamageB() {
        return damageB;
    }

    public static void setDamageB(String damageB) {
        PreRendering.damageB = damageB;
    }

    public static String getMenuOption1() {
        return menuOption1;
    }

    public static void setMenuOption1(String menuOption1) {
        PreRendering.menuOption1 = menuOption1;
    }

    public static String getMenuOption2() {
        return menuOption2;
    }

    public static void setMenuOption2(String menuOption2) {
        PreRendering.menuOption2 = menuOption2;
    }

    public static String getMenuOption3() {
        return menuOption3;
    }

    public static void setMenuOption3(String menuOption3) {
        PreRendering.menuOption3 = menuOption3;
    }

    public static String getMenuOption4() {
        return menuOption4;
    }

    public static void setMenuOption4(String menuOption4) {
        PreRendering.menuOption4 = menuOption4;
    }

    public static String getMenuOption5() {
        return menuOption5;
    }

    public static void setMenuOption5(String menuOption5) {
        PreRendering.menuOption5 = menuOption5;
    }

    public static char[][] getScreenEmpty() {
        return screenEmpty;
    }
}
