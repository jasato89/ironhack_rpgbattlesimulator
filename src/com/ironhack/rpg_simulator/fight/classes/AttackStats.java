package com.ironhack.rpg_simulator.fight.classes;

public class AttackStats {

    private int initialHp1;
    private int finalHp1;
    private int initialHp2;
    private int finalHp2;
    private int attackValue1;
    private int attackType1; //1 for heavy, 2 for weak
    private int attackValue2;
    private int attackType2;

    public AttackStats(int initialHp1, int initialHp2) {
        setInitialHp1(initialHp1);
        setInitialHp2(initialHp2);
    }

    public int getInitialHp1() {
        return initialHp1;
    }

    public void setInitialHp1(int initialHp1) {
        this.initialHp1 = initialHp1;
    }

    public int getFinalHp1() {
        return finalHp1;
    }

    public void setFinalHp1(int finalHp1) {
        this.finalHp1 = finalHp1;
    }

    public int getInitialHp2() {
        return initialHp2;
    }

    public void setInitialHp2(int initialHp2) {
        this.initialHp2 = initialHp2;
    }

    public int getFinalHp2() {
        return finalHp2;
    }

    public void setFinalHp2(int finalHp2) {
        this.finalHp2 = finalHp2;
    }

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
