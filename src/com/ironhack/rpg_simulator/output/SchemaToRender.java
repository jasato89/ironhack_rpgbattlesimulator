package com.ironhack.rpg_simulator.output;

import com.ironhack.rpg_simulator.classes.Party;

public class SchemaToRender {
    Party teamA;
    Party teamB;

    Party[] battleParticipants;
    Graveyard graveyard;

    public SchemaToRender(Party teamA, Party teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        battleParticipants = new Party[]{teamA, teamB};
    }

    public SchemaToRender() {
    }

//    public int getTeamMaxSize(int team){
//        return 0;
//    }

    public int getTeamMaxSize(int teamToPick){
        return battleParticipants[teamToPick].getPartyMaxSize();
    }

    public String getTeamName(int teamToPick){
        return battleParticipants[teamToPick].getName();
    }


    public String getDamageA() {
        return "  12";
    }

    public String getDamageB() {
        return "   8";
    }
}
