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
        //Output.announceTeam(party1, party2);
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
            if(!fighter1.isAlive()) {
                graveyard.addSoldier(fighter1, 1);
                party1.removeAliveMember();
                round.setLoser(1);
            } else{
                party1.updateAliveMember(fighter1, fighterIndex1);
            }
            if(!fighter2.isAlive()) {
                graveyard.addSoldier(fighter2, 2);
                party2.removeAliveMember();
                if(round.getLoser() == 1) { //In case both die at the same time, loser value is 3
                    round.setLoser(3);
                }else {
                    round.setLoser(2);
                }
            } else {
                party1.updateAliveMember(fighter2, fighterIndex2);
            }
            setRoundNumber(getRoundNumber() + 1);
        }
        return round;
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
