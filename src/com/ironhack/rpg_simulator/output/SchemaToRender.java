package com.ironhack.rpg_simulator.output;

public class SchemaToRender {
    Team teamA;
    Team teamB;
    Soldier soldierA;
    Soldier soldierB;
    Graveyard graveyard;

    public int getTeamMaxSize(int team){
        return 0;
    }

    public int getTeamCurrentSize(int team){
        return 3;
    }


    public String getDamageA() {
        return "  12";
    }

    public String getDamageB() {
        return "   8";
    }
}
