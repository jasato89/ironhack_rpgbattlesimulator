package com.ironhack.rpg_simulator.fight.classes;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Party;

import java.util.List;

public class Battle {
    private int roundNumber;
    private Graveyard graveyard;
    private Party party1;
    private Party party2;

    public Battle(Party party1, Party party2) {
        this.party1 = party1;
        this.party2 = party2;
        setRoundNumber(0);
        this.graveyard = new Graveyard();
    }

    public RoundStats fight(int fighterIndex1, int fighterIndex2) {
        RoundStats round = new RoundStats(party1.getAliveMembers().get(fighterIndex1),
                party2.getAliveMembers().get(fighterIndex2), party1.getName(), party2.getName(),
                party1.getAliveMembers().get(fighterIndex1).getName(), party2.getAliveMembers().get(fighterIndex2).getName(), getRoundNumber());
        if(round.isValidRound()) {
            Character fighter1 = party1.getAliveMembers().get(fighterIndex1);
            Character fighter2 = party2.getAliveMembers().get(fighterIndex2);
            while(fighter1.isAlive() && fighter2.isAlive()) {
                AttackStats attackStats = new AttackStats(fighter1.getHp(), fighter2.getHp());
                int[] damageValue1 = fighter1.attack(); //Saving the attack value of each soldier
                int[] damageValue2 = fighter2.attack();
                fighter1.damage(damageValue2[0]); //Damaging the soldiers
                fighter2.damage(damageValue1[0]);
                attackStats.setAttackValue1(damageValue1[0]); //Saving the attack value to attackStats
                attackStats.setAttackValue2(damageValue2[0]);
                attackStats.setAttackType1(damageValue1[1]); //Saving type of attack, 1 for heavy and 2 for weak
                attackStats.setAttackType2(damageValue2[1]);
                attackStats.setFinalHp1(fighter1.getHp()); //Saving final hp of each soldier
                attackStats.setFinalHp2(fighter2.getHp());
                round.addtoAttackLogs(attackStats);
            }
            round.setLoser(findLoserAndSendToGraveyard(fighter1, fighter2, fighterIndex1, fighterIndex2));
            //System.out.println(round.getRoundWinner(fighter1.getName(), fighter2.getName()));
            setRoundNumber(getRoundNumber() + 1);
        }
        return round;
    }

    private int findLoserAndSendToGraveyard(Character fighter1, Character fighter2, int fighterIndex1, int fighterIndex2) {
        int loser = 0;
        //if (party1.getAliveMembers().size() > 0) {
            if(!fighter1.isAlive()) {
                graveyard.addSoldier(fighter1, 1);
                party1.removeAliveMember();
                loser = 1;
            } else{
                party1.updateAliveMember(fighter1, fighterIndex1);
            }
        //}
        //if (party2.getAliveMembers().size() > 0) {
            if (!fighter2.isAlive()) {
                graveyard.addSoldier(fighter2, 2);
                party2.removeAliveMember();
                if (loser == 1) { //In case both die at the same time, loser value is 3
                    loser = 3;
                } else {
                    loser = 2;
                }
            } else {
                party2.updateAliveMember(fighter2, fighterIndex2);
            }
        //}
        return loser;
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

    public String toString() {
        return "Battle{" +
                "roundNumber=" + roundNumber +
                ", graveyard=" + graveyard +
                ", party1=" + party1 +
                ", party2=" + party2 +
                '}';
    }
}
