package com.ironhack.rpg_simulator.classes.database;

import com.ironhack.rpg_simulator.classes.character_management.Party;

import java.util.ArrayList;
import java.util.List;

public class StoredParties {

    private List<Party> theList;

    public StoredParties() {
        this.theList = new ArrayList<>();
    }

    public void add (Party partyToAdd){
        theList.add(partyToAdd);
    }

    public List<Party> getPartyList() {
        return theList;
    }

    public void setTheList(List<Party> theList) {
        this.theList = theList;
    }

    public String toString() {
        return "StoredParties{" +
                "theList=" + theList +
                '}';
    }
}
