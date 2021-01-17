package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Party;
import com.ironhack.rpg_simulator.fight.classes.AttackStats;
import com.ironhack.rpg_simulator.fight.classes.Battle;
import com.ironhack.rpg_simulator.fight.classes.RoundStats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RoundPage implements Page {

    String title;
    String prompt = "1 got to next round 3 to exit";
    List<Party> parties;
    List<Character> fighters;
    Battle battle;

    public RoundPage(Battle battle, List<Party> parties, List<Character> fighters) throws IOException {
        this.parties = parties;
        this.fighters = fighters;
        title = String.format("Battle %s VS %s", parties.get(0).getName(), parties.get(0).getName());
        this.battle = doTheRound(battle);

        navigation();
    }

    @Override
    public void render() throws IOException {
        System.out.println(title);
    }

    @Override
    public void navigation() throws IOException {
        System.out.println(prompt);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = br.readLine().split(" ")[0];
        Page nextPage;

        //if game still on
        switch (selection){
            case "1":
                //continue to chose next fighters
                nextPage = new FighterPickPage(battle, parties);
                break;
            case "2":
                ; //navigate to ->
                break;
            case "3":
                nextPage = new MainMenu();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + selection);
        }

        //else announce winner and go to main menu
    }

    public Battle doTheRound(Battle battle) throws IOException {
        render();
        RoundStats roundStats = battle.fight(fighters.get(0), fighters.get(1));
        List<AttackStats> attackStats = roundStats.getAttackLogs();
        System.out.println("Starting round " + battle.getRoundNumber() + "...");
        for (AttackStats attack : attackStats ) {
            String name1 = fighters.get(0).getName();
            String name2 = fighters.get(1).getName();
            String class1 = roundStats.getClass1() < 2 ? "Warrior" : "Wizard";
            String class2 = roundStats.getClass2() < 2 ? "Warrior" : "Wizard";
            String attackType1 = getAttackName(class1, attack.getAttackType1());
            String attackType2 = getAttackName(class2, attack.getAttackType2());
            int attackValue1 = attack.getAttackValue1();
            int attackValue2 = attack.getAttackValue2();
            System.out.println(name1 + " did " + attackValue1 + " damage using " + attackType1 + ".");
            System.out.println(name2 + " did " + attackValue2 + " damage using " + attackType2 + ".");
        }
        System.out.println(roundStats.getRoundWinner(fighters.get(0), fighters.get(1)));

        return battle;
    }
    private String getAttackName(String className, int attackTypeId) {
        String attackType;
        if (className.equals("Warrior")) {
            attackType = attackTypeId < 2 ? "heavy attack" : "light attack";
        } else {
            attackType = attackTypeId < 2 ? "fireball" : "staff attack";
        }
        return attackType;
    }



}