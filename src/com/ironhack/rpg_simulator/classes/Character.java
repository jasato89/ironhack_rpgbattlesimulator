package com.ironhack.rpg_simulator.classes;


import com.ironhack.rpg_simulator.interfaces.Attacker;

public abstract class Character implements Attacker {

        //Propieties
        //Counter is static, because we get a fully counter of the total of Character created
        //With counter we setUp an individual id for each Character
        private static int counter = 0;
        private int id;
        private String name;
        private int hp;
        private boolean isAlive = true;
        private String className = null;


        public Character(String name, int hp) {
                counter++;
                setName(name);
                setHp(hp);
                setAlive(isAlive);
                setId();
        }


        //damage is a Method, to let a character change his hp, when is attacked
        public void damage(int damage) {
                setHp(getHp()-damage);
                if(getHp() <= 0) {
                        setAlive(false);
                }
        }
        public abstract int[] attack();

        //setId, set the id as the counter number in the moment of the instance
        public void setId() {
                this.id = counter;
        }

        //getters and setters

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getHp() {
                return hp;
        }

        public void setHp(int hp) {
                this.hp = hp;
        }

        public boolean isAlive() {
                return isAlive;
        }

        public void setAlive(boolean alive) {
                isAlive = alive;
        }

        public String getClassName() {
                return className;
        }

        public void setClassName(String className) {
                this.className = className;
        }
}

