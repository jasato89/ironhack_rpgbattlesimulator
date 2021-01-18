package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.interfaces.Atacker;

public abstract class Character implements Atacker {

        //Propieties
        private static int counter = 0;
        private int id;
        private String name;
        private int hp;
        private boolean isAlive = true;

        public String getClassName() {
                return className;
        }

        public void setClassName(String className) {
                this.className = className;
        }

        private String className = null;

        public Character(String name, int hp, boolean isAlive) {
                counter++;
                setName(name);
                setHp(hp);
                setAlive(isAlive);
                setId();
        }


        //damage(), will be use to change the hp, after receiving damage
        //we implemenet damage here, because this method won't change in the child's Classes.
        public void damage(int damage) {
                //Changed primitives variables to getters and setters
                setHp(getHp() - damage);
                if(getHp() <= 0) {
                        setAlive(false);
                }
        }


        public String toString(){
                return getName() + " " + getClassName() + " " + getHp();
        }

        //getters and setters

        public static int counter() {
                return counter;
        }

        public void setId() { this.id = counter;}

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
}

