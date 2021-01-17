package com.ironhack.rpg_simulator.output;

public class MapBuilder {



    public char[][] prepareBoard(SchemaToRender stc, char[][] map){
        map = prepareTeamA(stc, map);
        map = prepareTeamB(stc, map);
//        map = prepareSpellA(stc, map, 3);
//        map = prepareSpellB(stc, map, 1);
//        map = prepareDamageA(stc,map);
//        map = prepareDamageB(stc,map);

        return map;
    }

    private char[][] prepareDamageA(SchemaToRender stc, char[][] map) {
        map[8][8] = 'H';
        map[8][9] = 'l';

        return map;
    }

    private char[][] prepareDamageB(SchemaToRender stc, char[][] map) {
        map[8][13] = 'H';
        map[8][14] = 'r';

        return map;
    }

    // 8.8 8.15
    private char[][] prepareSpellA(SchemaToRender stc, char[][] map, int spellId) {
        map[4][8] = 'S';
        if (spellId == 1) map[4][9] = 'A';
        else if (spellId == 2) map[4][9] = 'B';
        return map;
    }

    private char[][] prepareSpellB(SchemaToRender stc, char[][] map, int spellId) {
        map[4][13] = 'S';
        if (spellId == 1) map[4][14] = 'C';
        else if (spellId == 2) map[4][14] = 'D';
        return map;
    }

    private char[][] prepareTeamA(SchemaToRender stc, char[][] map){
        int size = stc.getTeamMaxSize(0);
        int i = 0;
        while (i < size && i < 5){
            switch (i){
                case 0: map[4][1] = '1';
                    break;
                case 1: map[6][1] = '1';
                    break;
                case 2: map[8][1] = '1';
                    break;
                case 3: map[5][3] = '1';
                    break;
                case 4: map[7][3] = '1';
                    break;
            }
            i++;
        }
        return map;
    }

    private char[][] prepareTeamB(SchemaToRender stc, char[][] map){
        int size = stc.getTeamMaxSize(1);
        int i = 0;
        char[][] rMap = map;
        while (i < size && i < 5){
            switch (i){
                case 0: rMap[4][22] = '2';
                    break;
                case 1: rMap[6][22] = '2';
                    break;
                case 2: rMap[8][22] = '2';
                    break;
                case 3: rMap[5][20] = '2';
                    break;
                case 4: rMap[7][20] = '2';
                    break;
            }
            i++;
        }
        return rMap;
    }
}
