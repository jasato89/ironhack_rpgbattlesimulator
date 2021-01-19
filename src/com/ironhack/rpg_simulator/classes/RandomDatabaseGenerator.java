package com.ironhack.rpg_simulator.classes;

import java.util.Random;

public class RandomDatabaseGenerator {
        /*Create a full party of randomly generated Wizards and Warriors with randomized stats considering this limits.

        name: based on an array of names, pick random position and if is already in the party add Jr at the end.
    hp: random between 100-200 to warriors, 50-100 for wizards)
    stamina: random between 10-50
    strength: random between 1-10
    mana: random between 10-50
    intelligence: random between 1-50*/

    private static final int HP_WARRIOR_MIN = 100;
    private static final int HP_WARRIOR_MAX = 200;
    private static final int HP_WIZARD_MIN = 50;
    private static final int HP_WIZARD_MAX = 100;
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
    private static final String[] PARTY_NAME = {"Avengers",
            "Goal Diggers",
            "Hot Shots",
            "Masters",
            "Titans",
            "Ringmasters",
            "Brute Force",
            "Pulverizers",
            "Ambassadors",
            "Barbarians",
            "Black Knights",
            "Cavaliers",
            "Crusaders",
            "Dream Crushers",
            "Exterminators",
            "Firing Squad",
            "Ghost Riders",
            "Golden Eagles",
            "Head Hunters",
            "Laser Beams",
            "Neck Breakers",
            "Novastars",
            "Peacekeepers",
            "Prairie Wolves",
            "Puppet Masters",
            "Razorbacks",
            "Retrievers",
            "Scrappers",
            "Speed Demons",
            "Thunder Bolts",
            "Unlimited",
            "Untouchables",
            "White Walkers"
    };


    public static Warrior getRandomWarrior() {

        return new Warrior(WARRIOR_NAME[new Random().nextInt(WARRIOR_NAME.length)],
                new Random().nextInt(HP_WARRIOR_MIN + 1) + HP_WARRIOR_MAX - HP_WARRIOR_MIN,
                new Random().nextInt(STAMINA_MIN + 1) + STAMINA_MAX - STAMINA_MIN,
                new Random().nextInt(STRENGTH_MIN + 1) + STRENGTH_MAX - STRENGTH_MIN);
    }

    public static Wizard getRandomWizard() {
        return new Wizard(WIZARD_NAME[new Random().nextInt(WARRIOR_NAME.length)],
                new Random().nextInt(HP_WIZARD_MIN + 1) + HP_WIZARD_MAX - HP_WIZARD_MIN,
                new Random().nextInt(MANA_MIN + 1) + MANA_MAX - MANA_MIN,
                new Random().nextInt(INTELLIGENCE_MIN + 1) + INTELLIGENCE_MAX - INTELLIGENCE_MIN);

    }

    public static String getRandomName() {
        return PARTY_NAME[new Random().nextInt(PARTY_NAME.length)];
    }
}
