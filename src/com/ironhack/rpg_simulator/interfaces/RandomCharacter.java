package com.ironhack.rpg_simulator.interfaces;

import com.ironhack.rpg_simulator.classes.Warrior;
import com.ironhack.rpg_simulator.classes.Wizard;

public interface RandomCharacter {
    public Warrior getRandomWarrior();
    public Wizard getRandomWizard();
}
