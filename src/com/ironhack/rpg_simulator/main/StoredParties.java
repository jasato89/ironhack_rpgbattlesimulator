package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.Party;

import java.util.ArrayList;
import java.util.List;

public class StoredParties {

    private StoredParties() {
        initializeStoredParties();
    }

    private static List<Party> theList;

    public static void initializeStoredParties(){
        theList = new ArrayList<>();
    }

    public static void add (Party partyToAdd){
        theList.add(partyToAdd);
    }

    public static List<Party> getTheList() {
        return theList;
    }


    //TODO IMPORT FROM CSV

    //TODO EXPORT FROM CSV

}
