package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.interfaces.Atacker;

public abstract class Character{

        //propiedades
//El id es static, porque tiene que ser un idenficador único, independientemente del número de instancias
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

