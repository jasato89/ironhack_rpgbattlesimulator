package com.ironhack.rpg_simulator.classes;

public abstract class Character{

        //Propieties
        //The id is static, beacuse the id needs to be unique. it doesn't matter how many instances we create
        private static int id = 0;
        private String name;
        private int hp;
        private boolean isAlive = true;

        public Character(String name, int hp, boolean isAlive) {
                id++;
                setName(name);
                setHp(hp);
                setAlive(isAlive);
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

        //getters and setters

        public static int getId() {
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
}

