package com.ironhack.rpg_simulator.fight.classes;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Warrior;

import java.util.ArrayList;
import java.util.List;

public class RoundStats {

    private int class1; //1 for Warrior, 2 for Wizard
    private int class2;
    private String nameTeam1;
    private String nameTeam2;
    private String nameFighter1;
    private String nameFighter2;
    private int loser;//1 for character of team 1, 2 for character of team 2, and 3 if both die
    private List<AttackStats> attackLogs;
    private int roundNumber;
    private boolean validRound;//false if at least one of the soldiers is already dead


    public RoundStats (Character char1, Character char2, String nameTeam1, String nameTeam2, String nameFighter1, String nameFighter2, int roundNumber) {
        if(char1.isAlive() && char2.isAlive()) {
            if(char1 instanceof Warrior) {
                setClass1(1);
            } else{
                setClass1(2);
            }
            if(char2 instanceof Warrior) {
                setClass2(1);
            } else{
                setClass2(2);
            }
            attackLogs = new ArrayList<>();
            setNameTeam1(nameTeam1);
            setNameTeam2(nameTeam2);
            setNameFighter1(nameFighter1);
            setNameFighter2(nameFighter2);
            setRoundNumber(roundNumber);
            setValidRound(true);
        } else {
            setValidRound(false);
        }

    }

    public String getRoundWinner(String soldier1, String soldier2) {
        if(getLoser() == 1) {
            return "The winner is " + soldier2 + " from team " + nameTeam2;
        } else if(getLoser() == 2) {
            return "The winner is " + soldier1 + " from team " + nameTeam1;
        } else{
            return "Any of the contestants survived.";
        }
    }

    public String getNameFighter1() {
        return nameFighter1;
    }

    public void setNameFighter1(String nameFighter1) {
        this.nameFighter1 = nameFighter1;
    }

    public String getNameFighter2() {
        return nameFighter2;
    }

    public void setNameFighter2(String nameFighter2) {
        this.nameFighter2 = nameFighter2;
    }

    public String getNameTeam1() {
        return nameTeam1;
    }

    public void setNameTeam1(String nameTeam1) {
        this.nameTeam1 = nameTeam1;
    }

    public String getNameTeam2() {
        return nameTeam2;
    }

    public void setNameTeam2(String nameTeam2) {
        this.nameTeam2 = nameTeam2;
    }

    public void addtoAttackLogs(AttackStats attackStats) {
        attackLogs.add(attackStats);
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public boolean isValidRound() {
        return validRound;
    }

    public void setValidRound(boolean validRound) {
        this.validRound = validRound;
    }

    public List<AttackStats> getAttackLogs() {
        return attackLogs;
    }

    public void setAttackLogs(List<AttackStats> attackLogs) {
        this.attackLogs = attackLogs;
    }

    public int getLoser() {
        return loser;
    }

    public void setLoser(int loser) {
        this.loser = loser;
    }

    public int getClass1() {
        return class1;
    }

    public void setClass1(int class1) {
        this.class1 = class1;
    }

    public int getClass2() {
        return class2;
    }

    public void setClass2(int class2) {
        this.class2 = class2;
    }
}
