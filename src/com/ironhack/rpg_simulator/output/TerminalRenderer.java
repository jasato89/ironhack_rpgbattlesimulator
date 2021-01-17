package com.ironhack.rpg_simulator.output;

import java.io.IOException;

public class TerminalRenderer {

    private final String DEFAULT = (char) 27 + "[0m";
    private final String RED = (char) 27 + "[31m";
    private final String GREEN = (char) 27 + "[32m";
    private final String GREEN_BCK = (char) 27 + "[42m";
    private final String MAGENTA_BCK = (char) 27 + "[30;45m";
    private final String RED_BCK = (char) 27 + "[41m";

    private final String BLOCK = "  ";
    private final String BLACK_POINT = DEFAULT;
    private final String GREEN_POINT = GREEN_BCK;
    private final String PURPLE_POINT = MAGENTA_BCK;
    private final String RED_POINT = RED_BCK;

    SchemaToRender stc = null;
    private String textToPrompt;
    private String teamAName;
    private String teamBName;
    private String charString;

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public void setCharString(String charString) {
        this.charString = charString;
    }

    public void setTextToPrompt(String textToPrompt) {
        this.textToPrompt = textToPrompt;
    }

    public TerminalRenderer() {
    }

    public TerminalRenderer(SchemaToRender stc) {
        this.stc = stc;
    }

    public void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }



    public void drawScreen(char[][] map) {
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                if (map[i][j] == ' ')
                    System.out.print(BLACK_POINT + BLOCK + DEFAULT);
                else if (map[i][j] == 'N' && map[i][j + 1] == 'A'){
                    System.out.print(stc.getTeamCurrentSize(1) + "/" + stc.getTeamCurrentSize(1));
                    j += 1;
                }
                else if (map[i][j] == 'N' && map[i][j + 1] == 'B'){
                    System.out.print(stc.getTeamCurrentSize(1) + "/" + stc.getTeamMaxSize(1));
                    j += 1;
                }
                else if (map[i][j] == 'E' && map[i][j + 1] == 'n'){
                    System.out.print("Team: " + teamAName);
                    j += teamAName.length() / 2;
                }
                else if (map[i][j] == 'C' && map[i][j + 1] == 'h'){
                    System.out.print("Character: " + charString);
                    j += charString.length() / 2;
                }
                else if (map[i][j] == 'S' && map[i][j + 1] == 'A'){
                    System.out.print("smaAtt");
                    j += 2;
                }
                else if (map[i][j] == 'S' && map[i][j + 1] == 'B'){
                    System.out.print("bigAtt");
                    j += 2;
                }
                else if (map[i][j] == 'S' && map[i][j + 1] == 'C'){
                    System.out.print("icebal");
                    j += 2;
                }
                else if (map[i][j] == 'B' && map[i][j + 1] == '7'){
                    System.out.print(RED_POINT + BLOCK + DEFAULT);
                }
                else if (map[i][j] == 'B' ){
                    if (map[i][j + 1] == '1')
                        System.out.print(RED_POINT + "   PLAY   " + DEFAULT);
                    else if (map[i][j + 1] == '2')
                        System.out.print(RED_POINT + " OPTIONS  " + DEFAULT);
                    else if (map[i][j + 1] == '3')
                        System.out.print(RED_POINT + "   EXIT   " + DEFAULT);
                    else if (map[i][j + 1] == '7'){
                        System.out.print(RED_POINT + BLOCK + BLOCK + BLOCK + BLOCK + DEFAULT);
                    }
                    j += 4;
                }
                else if (map[i][j] == 'P' ){
                    if (map[i][j + 1] == '1')
                        System.out.print(RED_POINT + " RND TEAM " + DEFAULT);
                    else if (map[i][j + 1] == '2')
                        System.out.print(RED_POINT + "SLCT TEAM " + DEFAULT);
                    else if (map[i][j + 1] == '3')
                        System.out.print(RED_POINT + " NEW TEAM " + DEFAULT);
                    else if (map[i][j + 1] == '4')
                        System.out.print(RED_POINT + "   EXIT   " + DEFAULT);
                    j += 4;
                }

                else if (map[i][j] == 'I'){
                    System.out.print(DEFAULT + textToPrompt + DEFAULT);
                    j += 7;
                }
                else if (map[i][j] == 'S' && map[i][j + 1] == 'D'){
                    System.out.print("firbal");
                    j += 2;
                }
                else if (map[i][j] == 'H' && map[i][j + 1] == 'l'){
                    System.out.print(RED + stc.getDamageA() + DEFAULT);
                    j += 1;
                }
                else if (map[i][j] == 'H' && map[i][j + 1] == 'r'){
                    System.out.print(RED + stc.getDamageB() + DEFAULT);
                    j += 1;
                }
                else if (map[i][j] == 'T'){
                    if (map[i][j + 1] == 'T'){
                        System.out.println("RPG SIMULATOR");
                        j += 4;
                    } else if (map[i][j + 1] == 'n'){
                        System.out.print("TEAM E");
                        j += 2;
                    } else {
                        System.out.println("RPG SIMULATOR");
                        j += 4;
                    }
                }
                else if (map[i][j] == 't'){
                    System.out.print("presents");
                    j += 3;
                }

                else if (map[i][j] == 'G'){
                    System.out.print(PURPLE_POINT + '+' + DEFAULT + ' ');
//                    j += 1;
                }
                else if (map[i][j] == '1')
                    System.out.print(GREEN_POINT + BLOCK + DEFAULT);
                else if (map[i][j] == '2')
                    System.out.print(PURPLE_POINT + BLOCK + DEFAULT);
                else if (map[i][j] == 'a'){
                    System.out.print(RED_POINT + " opti a " + DEFAULT);
                    j += 3;
                }
                else if (map[i][j] == 'b'){
                    System.out.print(RED_POINT + " opti b " + DEFAULT);
                    j += 3;
                }
                else if (map[i][j] == 'c'){
                    System.out.print(RED_POINT + " opti c " + DEFAULT);
                    j += 3;
                }
                else if (map[i][j] == 'd'){
                    System.out.print(RED_POINT + " opti d " + DEFAULT);
                    j += 3;
                }
            }
            System.out.println();
        }
    }



}
