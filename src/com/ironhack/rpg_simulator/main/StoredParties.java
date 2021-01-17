package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.Party;

import java.util.ArrayList;
import java.util.List;

public static class StoredParties {

    private List<Party> theList;

    public static StoredParties() {
        this.theList = new ArrayList<>();
    }


    public void add (Party partyToAdd){
        theList.add(partyToAdd);
    }

    public List<Party> getTheList() {
        return theList;
    }

    public void setTheList(List<Party> theList) {
        this.theList = theList;
    }
}
