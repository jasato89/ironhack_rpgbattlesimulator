package com.ironhack.rpg_simulator.fight.classes;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Warrior;
import com.ironhack.rpg_simulator.classes.Wizard;
import com.ironhack.rpg_simulator.interfaces.Atacker;

public class Battle {
    private int roundNumber;
    private Graveyard graveyard;
    private Party party1;
    private Party party2;

    public Battle(Party party1, Party party2) {
        this.party1 = party1;
        this.party2 = party2;
        setRoundNumber(0);
        //Output.announceTeam(party1, party2);
    }

    public void fight(Warrior soldier1, Warrior soldier2) {
        //Output.announceFighters(soldier1, soldier2)
        while(soldier1.isAlive() && soldier2.isAlive()) {
            int damageValue1 = soldier1.attack();
            int damageValue2 = soldier2.attack();
            soldier1.damage(damageValue2);
            soldier2.damage(damageValue1);
            //Output.announceRound(soldier1, soldier2, String.valueOf(damageValue1), String.valueOf(damageValue2));
        }
        if(!soldier1.isAlive()) {
            graveyard.addSoldier(1,soldier1);
            party1.removeMemberById(soldier1.getId());
            //Output.announceDeath(1, soldier1.getName);
        }
        if(!soldier2.isAlive()) {
            graveyard.addSoldier(2,soldier2);
            party1.removeMemberById(soldier2.getId());
            //Output.announceDeath(2, soldier2.getName);
        }
        //String endAnnouncement = "Round " + getRoundNumber() + "has ended";
        //Output.announceEnd(endAnnouncement);
    }

    public void fight(Warrior soldier1, Wizard soldier2) {
        //Output.announceFighters(soldier1, soldier2)
        while(soldier1.isAlive() && soldier2.isAlive()) {
            int damageValue1 = soldier1.attack();
            int damageValue2 = soldier2.attack();
            soldier1.damage(damageValue2);
            soldier2.damage(damageValue1);
            //Output.announceRound(soldier1, soldier2, String.valueOf(damageValue1), String.valueOf(damageValue2));
        }
        if(!soldier1.isAlive()) {
            graveyard.addSoldier(1,soldier1);
            party1.removeMemberById(soldier1.getId());
            //Output.announceDeath(1, soldier1.getName);
        }
        if(!soldier2.isAlive()) {
            graveyard.addSoldier(2,soldier2);
            party1.removeMemberById(soldier2.getId());
            //Output.announceDeath(2, soldier2.getName);
        }
        //String endAnnouncement = "Round " + getRoundNumber() + "has ended";
        //Output.announceEnd(endAnnouncement);
    }

    public void fight(Wizard soldier1, Warrior soldier2) {
        //Output.announceFighters(soldier1, soldier2)
        while(soldier1.isAlive() && soldier2.isAlive()) {
            int damageValue1 = soldier1.attack();
            int damageValue2 = soldier2.attack();
            soldier1.damage(damageValue2);
            soldier2.damage(damageValue1);
            //Output.announceRound(soldier1, soldier2, String.valueOf(damageValue1), String.valueOf(damageValue2));
        }
        if(!soldier1.isAlive()) {
            graveyard.addSoldier(1,soldier1);
            party1.removeMemberById(soldier1.getId());
            //Output.announceDeath(1, soldier1.getName);
        }
        if(!soldier2.isAlive()) {
            graveyard.addSoldier(2,soldier2);
            party1.removeMemberById(soldier2.getId());
            //Output.announceDeath(2, soldier2.getName);
        }
        //String endAnnouncement = "Round " + getRoundNumber() + "has ended";
        //Output.announceEnd(endAnnouncement);
    }

    public void fight(Wizard soldier1, Wizard soldier2) {
        //Output.announceFighters(soldier1, soldier2)
        while(soldier1.isAlive() && soldier2.isAlive()) {
            int damageValue1 = soldier1.attack();
            int damageValue2 = soldier2.attack();
            soldier1.damage(damageValue2);
            soldier2.damage(damageValue1);
            //Output.announceRound(soldier1, soldier2, String.valueOf(damageValue1), String.valueOf(damageValue2));
        }
        if(!soldier1.isAlive()) {
            graveyard.addSoldier(1,soldier1);
            party1.removeMemberById(soldier1.getId());
            //Output.announceDeath(1, soldier1.getName);
        }
        if(!soldier2.isAlive()) {
            graveyard.addSoldier(2,soldier2);
            party1.removeMemberById(soldier2.getId());
            //Output.announceDeath(2, soldier2.getName);
        }
        //String endAnnouncement = "Round " + getRoundNumber() + "has ended";
        //Output.announceEnd(endAnnouncement);
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(Graveyard graveyard) {
        this.graveyard = graveyard;
    }

    public Party getParty1() {
        return party1;
    }

    public void setParty1(Party party1) {
        this.party1 = party1;
    }

    public Party getParty2() {
        return party2;
    }

    public void setParty2(Party party2) {
        this.party2 = party2;
    }
}
