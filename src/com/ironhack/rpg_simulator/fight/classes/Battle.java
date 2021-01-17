package com.ironhack.rpg_simulator.fight.classes;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Party;

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

    public RoundStats fight(Character soldier1, Character soldier2) {
        RoundStats round = new RoundStats(soldier1, soldier2, party1.getName(), party2.getName(), getRoundNumber());
        if(round.isValidRound()) {
            while(soldier1.isAlive() && soldier2.isAlive()) {
                AttackStats attackStats = new AttackStats(soldier1.getHp(), soldier2.getHp());
                int[] damageValue1 = soldier1.attack(); //Saving the attack value of each soldier
                int[] damageValue2 = soldier2.attack();
                soldier1.damage(damageValue2[0]); //Damaging the soldiers
                soldier2.damage(damageValue1[0]);
                attackStats.setAttackValue1(damageValue1[0]); //Saving the attack value to attackStats
                attackStats.setAttackValue2(damageValue2[0]);
                attackStats.setAttackType1(damageValue1[1]); //Saving type of attack, 1 for heavy and 2 for weak
                attackStats.setAttackType2(damageValue2[1]);
                attackStats.setFinalHp1(soldier1.getHp()); //Saving final hp of each soldier
                attackStats.setFinalHp2(soldier2.getHp());
                round.addtoAttackLogs(attackStats);
            }
            if(!soldier1.isAlive()) {
                graveyard.addSoldier(1,soldier1);
                round.setLoser(1);
            }
            if(!soldier2.isAlive()) {
                graveyard.addSoldier(2,soldier2);
                if(round.getLoser() == 1) { //In case both die at the same time, loser value is 3
                    round.setLoser(3);
                }else {
                    round.setLoser(2);
                }
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
