package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.classes.Party;
import com.ironhack.rpg_simulator.classes.Warrior;
import com.ironhack.rpg_simulator.classes.Wizard;

public class Main {

    public static void main(String[] args) {
        //Ejemplo de Warrior
        Warrior warrior = new Warrior("juan", 100, true, 4, 44);
        //Ejemplo de flow de ataques
        //warrior.attack();
        //warrior.attack();
        //warrior.attack();

        //Ejemplo de Wizard
        Wizard wizard = new Wizard("Sonia", 50, true, 4, 22);

        //Ejemplo de flow de ataques
        wizard.attack();
        wizard.attack();
        wizard.attack();



    }

}
