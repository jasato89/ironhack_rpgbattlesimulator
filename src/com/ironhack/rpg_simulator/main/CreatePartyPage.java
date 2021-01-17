package com.ironhack.rpg_simulator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreatePartyPage implements Page {


    //pedir el nombre
    //create first char
    //store temp list
    //loop
    //ask for more
    //create first char
    //store temp list
    //exit loop
    //create party
    //add party to store
    //prompt exit navigation

    private String promptForNewParty() throws IOException {
        System.out.println("Type team name:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    private Character createACharacter(){
        return null;
    }


    @Override
    public void render() throws IOException {

    }

    @Override
    public void navigation() throws IOException {

    }
}
