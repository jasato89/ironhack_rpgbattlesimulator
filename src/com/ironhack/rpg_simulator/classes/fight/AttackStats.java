package com.ironhack.rpg_simulator.classes.fight;

public class AttackStats {

    //Properties
    private int attackValue1;
    private int attackType1; //1 for heavy, 2 for weak
    private int attackValue2;
    private int attackType2;

    public int getAttackValue1() {
        return attackValue1;
    }

    public void setAttackValue1(int attackValue1) {
        this.attackValue1 = attackValue1;
    }

    public int getAttackType1() {
        return attackType1;
    }

    public void setAttackType1(int attackType1) {
        this.attackType1 = attackType1;
    }

    public int getAttackType2() {
        return attackType2;
    }

    public void setAttackType2(int attackType2) {
        this.attackType2 = attackType2;
    }

    public int getAttackValue2() {
        return attackValue2;
    }

    public void setAttackValue2(int attackValue2) {
        this.attackValue2 = attackValue2;
    }

}
