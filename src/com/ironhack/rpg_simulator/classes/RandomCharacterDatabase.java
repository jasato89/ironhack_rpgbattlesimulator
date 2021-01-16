package com.ironhack.rpg_simulator.classes;

import java.util.Random;

public class RandomCharacterDatabase  {
        /*Create a full party of randomly generated Wizards and Warriors with randomized stats considering this limits.

        name: based on an array of names, pick random position and if is already in the party add Jr at the end.
    hp: random between 100-200 to warriors, 50-100 for wizards)
    stamina: random between 10-50
    strength: random between 1-10
    mana: random between 10-50
intelligence: random between 1-50*/

    private static final int HP_MIN = 100;
    private static final int HP_MAX = 200;
    private static final int STAMINA_MIN = 10;
    private static final int STAMINA_MAX = 50;
    private static final int STRENGTH_MIN = 1;
    private static final int MANA_MIN = 10;
    private static final int MANA_MAX = 50;
    private static final int STRENGTH_MAX = 10;
    private static final int INTELLIGENCE_MIN = 1;
    private static final int INTELLIGENCE_MAX = 50;


    private static final String[] WARRIOR_NAME = {"The Boulder",
            "The Corrupter",
            "The Skeleton",
            "The Flurry",
            "Ironfang",
            "The Exalted",
            "Phoenixgrip",
            "Storm Tongue",
            "Fire Blood",
            "Raven Stride",
            "The Jester",
            "The Surgeon",
            "The Temper",
            "The Deserter",
            "The Honorbound",
            "Deathfury",
            "Hellsword",
            "Giantblade",
            "Demon Brow",
            "Bearcleaver",
            "The Sentinel",
            "The Widow Maker",
            "The Savage",
            "The Delirious",
            "The Honorless",
            "Boulder Song",
            "Gorefist",
            "Goreblood",
            "Fistshade",
            "Firethorn"
    };
    private static final String[] WIZARD_NAME = {"Ogirick",
            "Oshan",
            "Aquam",
            "Uzoneus",
            "Envekron",
            "Ozahl",
            "Avius",
            "Ozustrum",
            "Ogeor",
            "Adiphior",
            "Ivior",
            "Uzutrix",
            "Ulirhan",
            "Izahl",
            "Irish",
            "Inorim",
            "Ahonoran",
            "Uphiphior",
            "Errokelis",
            "Ehadarin",
            "Dhuzith",
            "Iphigreth",
            "Ikalis",
            "Illedeis",
            "Rutior",
            "Ilimorith",
            "Isim",
            "Iffyn",
            "Uhobarin",
            "Orin"
    };


    public static Warrior getRandomWarrior() {
        //public Warrior(String name, int hp, boolean isAlive, int stamina, int strength)

        return new Warrior(WARRIOR_NAME[new Random(WARRIOR_NAME.length).nextInt()],
                new Random(HP_MIN + 1).nextInt() + HP_MAX - HP_MIN, true,
                new Random(STAMINA_MIN + 1).nextInt() + STAMINA_MAX - STAMINA_MIN,
                new Random(STRENGTH_MIN + 1).nextInt() + STRENGTH_MAX - STRENGTH_MIN);
    }

    public static Wizard getRandomWizard() {
        return new Wizard(WIZARD_NAME[new Random(WARRIOR_NAME.length).nextInt()],
                new Random(HP_MIN + 1).nextInt() + HP_MAX - HP_MIN, true,
                new Random(MANA_MIN + 1).nextInt() + MANA_MAX - MANA_MIN,
                new Random(INTELLIGENCE_MIN + 1).nextInt() + INTELLIGENCE_MAX - INTELLIGENCE_MIN);

    }
}
