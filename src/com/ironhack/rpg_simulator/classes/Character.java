package com.ironhack.rpg_simulator.classes;

public abstract class Character {

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

        // Creamos un método no estático, para recibir el daño. No es abstracto porque es igual en las clases que heredan
        public void damage(int damage) {
                this.hp -= damage;
                if(this.hp <= 0) {
                        this.isAlive = false;
                }
        };

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

