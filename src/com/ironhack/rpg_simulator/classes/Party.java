package com.ironhack.rpg_simulator.classes;

import java.util.ArrayList;

public class Party {
    ArrayList<Character> party = new ArrayList<Character>();

    public Party(ArrayList<Character> party) {
        this.party = party;
    }

    public void getAllMembers() {
        int i = 0;
        for (Character character : party) {
            System.out.println(i + " - " + character.toString());
            i++;
        }
    }

    public Character getMemberById(int id) {
        return party.get(id);
    }

    public ArrayList<Character> getParty() {
        return party;
    }

    public ArrayList<Character> generateRandomParty() {

   /*The Boulder
    The Corrupter
    The Skeleton
    The Exalted
    The Flurry
    Ironfang
    Phoenixgrip
    Storm Tongue
    Fire Blood
    Raven Stride
    The Jester
    The Surgeon
    The Temper
    The Deserter
    The Honorbound
    Deathfury
    Hellsword
    Giantblade
    Demon Brow
    Bearcleaver
    The Sentinel
    The Widow Maker
    The Savage
    The Delirious
    The Honorless
    Boulder Song
    Gorefist
    Goreblood
    Fistshade
    Firethorn*/


        return null;
    }


}
