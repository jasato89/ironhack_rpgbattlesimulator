package com.ironhack.rpg_simulator.main;


import java.io.IOException;


public interface Page {

    public abstract void render() throws IOException;

    public abstract void navigation() throws IOException;



}
